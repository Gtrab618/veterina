package Control;

import Modelo.ClasesModelo.ModeloCliente;
import Modelo.ClasesModelo.ModeloGrooming;
import Modelo.ClasesModelo.ModeloMascota;
import Modelo.Cliente;
import Modelo.Conexion;
import Modelo.Mascota;
import Vista.VistaGrooming;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Usuario
 */
public class ControlGrooming {

    private VistaGrooming Vgro;
    private ModeloCliente Ccli;
    private ModeloMascota Mmas;
    private ModeloGrooming Mgro;
    private Validaciones vali = new Validaciones();
    //este sirve para contador del bucle tabla 
    private int i = 0;
    private String dni_persona = "", id_mascota = "";

    public ControlGrooming(VistaGrooming Vgro, ModeloCliente Ccli, ModeloMascota Mmas, ModeloGrooming Mgro) {
        this.Vgro = Vgro;
        this.Ccli = Ccli;
        this.Mmas = Mmas;
        this.Mgro = Mgro;
        referenciarObjetos();
    }

    public void iniciarControl() {
        //cambiar de paneles
        Vgro.getBtn_Pbuscar().addActionListener(l -> cambiarPanel("buscar"));
        Vgro.getBtn_Pregistrar().addActionListener(l -> cambiarPanel("registro"));
        Vgro.getBtn_NueRepor().addActionListener(l -> cargarDatorReporteNuevo());
        Vgro.getBtn_Gimprimir().addActionListener(l -> imprimirReporte());
        //eventos de las tablas 
        evtVerMascota(Vgro.getTblBpersona());
        evtVerFotoMas(Vgro.getTblBmascota());
        evtBusquedaIncre(Vgro.getTxtBpersona());
        //guardar datos de grooming
        Vgro.getJdt_Gfecha().setEnabled(false);
        Vgro.getBtn_GguardarR().addActionListener(l -> guardarReporte());
        //reiniciar id al ingresar buscqueda incremental
        evtTxtReiniId(Vgro.getTxtBpersona());
    }

    private void cambiarPanel(String tipo) {

        if (tipo.equalsIgnoreCase("buscar")) {
            limpiarBusqueda();
            llenarTabla();
            limpiarRegistroGroo();
            Vgro.getPnl_Busqueda().setVisible(true);
            Vgro.getPnl_Registro().setVisible(false);
        } else if (tipo.equalsIgnoreCase("registro")) {
            limpiarRegistroGroo();
            desabilitarBtn();
            Vgro.getPnl_Busqueda().setVisible(false);
            Vgro.getPnl_Registro().setVisible(true);
        }

    }

    private void referenciarObjetos() {
        //cargar datos en la tabla
        llenarTabla();
        //dessactivar los panel que no son necesarios al inico del grooming
        Vgro.getPnl_Registro().setVisible(false);

        //desactivo la tabla mascotas
        Vgro.getScrBmascota().setVisible(false);
        Vgro.getLblBselecMas().setVisible(false);
        Vgro.getLblBAlertMne().setVisible(false);
        //desabilitar fecha
//        Vgro.getJdt_Gfecha().setEnabled(false);
        //desactivar lbl
        desabiliarAlertaG();
        //desactivar botones
        desabilitarBtn();
        //salto de linea vistaRegistro tat
        Vgro.getTat_Gdescripcion().setLineWrap(true);
        //Evitar corte de palabras por la mitad
        Vgro.getTat_Gdescripcion().setWrapStyleWord(true);
    }

    //-------------------zona de eventos para teclas o mouse etc-----------------------
    //seleccionar tabla persona
    private void evtVerMascota(JTable busqueda) {
        busqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                limiarIdBtable();
                verMascotaDni(evt);

            }
        });
    }

    //eligo el id de la mascota para poner la foto
    private void evtVerFotoMas(JTable buscarMas) {

        buscarMas.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ponerFotoMascota(evt);
            }
        });

    }

    private void evtBusquedaIncre(JTextField busc) {

        busc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {

                buscar();
            }
        });

    }

    //limpiar panel cuando seleciono el txt busqueda
    private void evtTxtReiniId(JTextField txt) {

        txt.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                limpiarIdBuscq();
            }

        });
    }

    //-----------------------imprimir reportes------------------------------
    private void imprimirReporte() {

        String nombreP = Vgro.getLblGnombreP().getText();
        //solo funciona para neat no jar
//        String rutaLogo = System.getProperty("user.dir");
//        rutaLogo = rutaLogo + "/Iconos/vtMain.png";
        //conseguir la ruta relativa para cuando se  comprime en un jar
//        URL resource = getClass().getResource("/Iconos/vtMain.png");
//        String ruta= resource+"";

        try {
            Conexion con = new Conexion();

            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/Vista/reportes/ReportGroo2.jasper"));
            //cargar ruta de imagen
            Map<String, Object> parametro = new HashMap<String, Object>();

            parametro.put("nombreP", nombreP);
            parametro.put("cedula", dni_persona);
            parametro.put("idMascota", Integer.parseInt(id_mascota));
            JasperPrint jp = JasperFillManager.fillReport(jr, parametro, con.getCon());
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ControlGrooming.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //----------------------------------------zona metodos para las tablas------------------
    private void verMascotaDni(java.awt.event.MouseEvent evt) {
        //resear los idpara la seleccion de mastoca y dni

        //guardo la cedula para buscar las mascotas
        String cedulaB = "";

        DefaultTableModel tm = (DefaultTableModel) Vgro.getTblBpersona().getModel();

        cedulaB = String.valueOf(tm.getValueAt(Vgro.getTblBpersona().getSelectedRow(), 0));
        //almaceno en dni la cedula para despues comprobar si esta seleccionado mascota y persona y pasar a la siguiente ventana
        dni_persona = cedulaB;
        llenarTablaMascotas(cedulaB);

    }

    //recupero el id de la mascota para despues ser puesto en el label
    private void ponerFotoMascota(java.awt.event.MouseEvent evt) {
        String idString = "";
        int id = 0;

        DefaultTableModel tm = (DefaultTableModel) Vgro.getTblBmascota().getModel();
        idString = String.valueOf(tm.getValueAt(Vgro.getTblBmascota().getSelectedRow(), 0));
        //almaceno id_mascota para despues valorar y mandar a la interfaz de edicion
        id_mascota = idString;
        id = Integer.parseInt(idString);
        BuscarFotoMascota(id);

    }

    //cargo la imgen en el label
    private void BuscarFotoMascota(int id) {
        Mascota masF = new Mascota();
        masF = Mmas.verFotoMascota(id);

        //llenar imagen
        byte[] bi = masF.getFoto();
        if (bi != null) {

            try {
                BufferedImage image = null;
                InputStream in = new ByteArrayInputStream(bi);
                image = ImageIO.read(in);
                ImageIcon imi = new ImageIcon(image.getScaledInstance(Vgro.getLblBFoto().getWidth(), Vgro.getLblBFoto().getHeight(), Image.SCALE_SMOOTH));
                Vgro.getLblBFoto().setIcon(imi);
                Vgro.getLblBFoto().updateUI();

            } catch (IOException ex) {
                Logger.getLogger(ControlMascota.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            Vgro.getLblBFoto().setIcon(null);
            Vgro.getLblBFoto().updateUI();
        }
    }

    //busco las mascotas
    private void buscar() {
        String criterio = Vgro.getTxtBpersona().getText();
        criterio = criterio.toLowerCase();
        if (!criterio.equals("")) {
            //buscar los clientes 
            llenarTablaBusqueda(criterio);

        } else {

            llenarTabla();
            Vgro.getLblAlertBne().setVisible(false);
        }
    }

    //---------------------------------------zona para las tablas----------------------------
    private void llenarTabla() {

        i = 0;
        //desactivar lbl de alerta
        Vgro.getLblAlertBne().setVisible(false);
        DefaultTableModel estructuraTabla;
        estructuraTabla = (DefaultTableModel) Vgro.getTblBpersona().getModel();
        estructuraTabla.setNumRows(0);
        List<Cliente> listC = Ccli.recuperarClientes();
        listC.stream().forEach(cliente -> {
            estructuraTabla.addRow(new Object[1]);

            Vgro.getTblBpersona()
                    .setValueAt(cliente.getPer_dni(), i, 0);
            Vgro.getTblBpersona()
                    .setValueAt(cliente.getPer_nombre1(), i, 1);
            Vgro.getTblBpersona()
                    .setValueAt(cliente.getPer_apellido1(), i, 2);
            Vgro.getTblBpersona()
                    .setValueAt(cliente.getPer_apellido2(), i, 3);
            i = i + 1;
        });
    }

    private void llenarTablaMascotas(String cedula) {
        DefaultTableModel estructuraTabla;
        estructuraTabla = (DefaultTableModel) Vgro.getTblBmascota().getModel();
        estructuraTabla.setNumRows(0);
        List<Mascota> listmas = Mmas.consultarMascotaCedu(cedula);
        i = 0;

        if (!listmas.isEmpty()) {
            //activar tabla y label de indicacion
            Vgro.getLblBselecMas().setVisible(true);
            Vgro.getScrBmascota().setVisible(true);
            Vgro.getLblBAlertMne().setVisible(false);
            listmas.stream().forEach(mascota -> {

                estructuraTabla.addRow(new Object[2]);
                Vgro.getTblBmascota()
                        .setValueAt(mascota.getMas_id(),
                                i, 0);
                Vgro.getTblBmascota()
                        .setValueAt(mascota.getMas_nombreMas(),
                                i, 1);
                Vgro.getTblBmascota()
                        .setValueAt(mascota.getMas_especie(),
                                i, 2);
                Vgro.getTblBmascota()
                        .setValueAt(mascota.getMas_raza(),
                                i, 3);

                i = i + 1;

            });
        } else {
            Vgro.getScrBmascota().setVisible(false);
            Vgro.getLblBselecMas().setVisible(false);
            Vgro.getLblBAlertMne().setVisible(true);
        }

    }

    private void llenarTablaBusqueda(String criterio) {

        i = 0;
        DefaultTableModel estructuraTabla;
        estructuraTabla = (DefaultTableModel) Vgro.getTblBpersona().getModel();
        estructuraTabla.setNumRows(0);
        List<Cliente> listC = Ccli.busquedaIncrementalCliente(criterio);

        if (!listC.isEmpty()) {
            Vgro.getLblAlertBne().setVisible(false);
            listC.stream().forEach(cliente -> {
                estructuraTabla.addRow(new Object[1]);

                Vgro.getTblBpersona()
                        .setValueAt(cliente.getPer_dni(), i, 0);
                Vgro.getTblBpersona()
                        .setValueAt(cliente.getPer_nombre1(), i, 1);
                Vgro.getTblBpersona()
                        .setValueAt(cliente.getPer_apellido1(), i, 2);
                Vgro.getTblBpersona()
                        .setValueAt(cliente.getPer_apellido2(), i, 3);
                i = i + 1;
            });
        } else {
            Vgro.getLblAlertBne().setVisible(true);
        }
    }

    //---------------------------metodos para limpiar los paneles--------------------------
    private void limpiarBusqueda() {
        //texto de busqueda vacio
        Vgro.getTxtBpersona().setText("");
        //esconder la tabla mascotas 
        Vgro.getScrBmascota().setVisible(false);
        //desactivar lbl selecione mascotas 
        Vgro.getLblBselecMas().setVisible(false);
        //quitar la foto de la mascota 
        Vgro.getLblBFoto().setIcon(null);
        //vRegis.getTblBusqueda().clearSelection();
        Vgro.getLblBAlertMne().setVisible(false);
    }

    //----------------pasar a al siguiente panel ------------
    private void cargarDatorReporteNuevo() {

        //si las dos son diferentes de vacias se pasa a la siguiente interfaz para ser modificado
        if (!dni_persona.equalsIgnoreCase("") && !id_mascota.equalsIgnoreCase("")) {
            //recupero los datos de la tabla para ser pasador a modificar
            Vgro.getPnl_Busqueda().setVisible(false);
            //activar panel de modificacion
            Vgro.getPnl_Registro().setVisible(true);
            //Recuperar los datos para mandar el siguiente jpanel

            recuperarMandarDatosModificar();

        } else if (dni_persona.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Seleccione un propietario");
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una mascota");
        }

    }

    //recupero los datos para ser llenados en la siguiente interfaz
    private void recuperarMandarDatosModificar() {
        //recupero informacion de la mascota para cargar los datos 
        Mascota mas = Mmas.consultarMascotaId(id_mascota);
        //recupedo  imformacion de la persona para cargar los datos 
        Cliente cli = Ccli.getClienteEspecifico(dni_persona);

        //cargo los datos de la persona
        Vgro.getLblGcedula().setText(dni_persona);
        Vgro.getLblGnombreP().setText(cli.getPer_nombre1() + " " + cli.getPer_apellido1() + " " + cli.getPer_apellido2());

        Vgro.getLblGnombreM().setText(mas.getMas_nombreMas());
        Vgro.getLblGraza().setText(mas.getMas_raza());
        Vgro.getLblGsexo().setText(mas.getMas_sexo());
        //pasar a date 
        Vgro.getJdt_Gfecha().setDate(mas.getMas_fechaNac());
        //pasar a localdate y calcular edad
        Vgro.getLblGedad().setText(vali.calcularEdad(Vgro.getJdt_Gfecha().getDate()));
        //poner la fecha actual
        Vgro.getJdt_Gfecha().setDate(Date.from(Instant.now()));

        byte[] bi = mas.getFoto();

        try {
            BufferedImage image = null;
            InputStream in = new ByteArrayInputStream(bi);
            image = ImageIO.read(in);
            ImageIcon imi = new ImageIcon(image.getScaledInstance(Vgro.getLblGfoto().getWidth(), Vgro.getLblGfoto().getHeight(), Image.SCALE_SMOOTH));
            Vgro.getLblGfoto().setIcon(imi);
            Vgro.getLblGfoto().updateUI();
        } catch (IOException ex) {
            Logger.getLogger(ControlMascota.class.getName()).log(Level.SEVERE, null, ex);
        }
        //habilito los botones para la eliminacion modificacion o examinar
        habilitarBtn();
    }

    //---------------------accione de los botones 
    private void guardarReporte() {
        desabiliarAlertaG();
        String nombreCorte = "", alergia = "";
        double precio = 0;
        int tipoError=0;

        //parsear id mascota
        int bandera = 0, mascota_id = 0;
        mascota_id = Integer.parseInt(id_mascota);
        //recuperar variables 
        nombreCorte = Vgro.getTxt_GtipoCorte().getText();
        precio = (double) Vgro.getJspGprecio().getValue();

        //Validaciones 
        if (!nombreCorte.equalsIgnoreCase("")) {

            tipoError = vali.valiNombreV2(nombreCorte);
            switch (tipoError) {

                case 1:
                    //error longitud
                    Vgro.getLblAlertaGnL().setVisible(true);
                    bandera = bandera + 1;
                    break;
                case 2:

                    //nombre de la mascota contiene numeros
                    Vgro.getLblAlertaGnf().setVisible(true);
                    bandera = bandera + 1;
                    break;

            }
        } else {
            Vgro.getLblAlertaGcv().setVisible(true);
            bandera = bandera + 1;
        }
        if (precio == 0) {
            bandera = bandera + 1;
            Vgro.getLblAlertaGpv().setVisible(true);
        }

        //registrar si todo es perfecto
        if (bandera == 0) {
            //capilatizo la letra
            Mgro.setGro_tipo_corte(capitalize(nombreCorte));
            Mgro.setDescripcion(Vgro.getTat_Gdescripcion().getText());
            Mgro.setGro_precio(precio);
            Mgro.setMas_id_mascotafk(mascota_id);
            Mgro.setGro_fecha(Vgro.getJdt_Gfecha().getDate());

            if (Mgro.InsertarGrooming()) {
                JOptionPane.showMessageDialog(null, "Registro creado");
                limpiarRegistroGroo();
                desabilitarBtn();
            }

        }

    }

    private String capitalize(final String line) {
        return Character.toUpperCase(line.charAt(0)) + line.substring(1).toLowerCase();
    }

    //----------------Activar o desactivar botones o labes ----------------------
    private void desabiliarAlertaG() {
        Vgro.getLblAlertaGcv().setVisible(false);
        Vgro.getLblAlertaGnf().setVisible(false);
        Vgro.getLblAlertaGpv().setVisible(false);
        Vgro.getLblAlertaGnL().setVisible(false);
    }

    private void limpiarRegistroGroo() {
        //reiniciar id
        dni_persona = "";
        id_mascota = "";
        //reinicar panel
        Vgro.getLblGcedula().setText("");
        Vgro.getLblGnombreP().setText("");
        Vgro.getLblGnombreM().setText("");
        Vgro.getLblGraza().setText("");
        Vgro.getLblGsexo().setText("");
        Vgro.getLblGedad().setText("");
        Vgro.getTat_Gdescripcion().setText("");
        //poner la fecha actual
        Vgro.getJdt_Gfecha().setDate(Date.from(Instant.now()));
        Vgro.getTxt_GtipoCorte().setText("");
        Vgro.getLblGfoto().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/vtMain.png")));
        Vgro.getJspGprecio().setValue(0);
    }

    private void desabilitarBtn() {

        Vgro.getBtn_GguardarR().setEnabled(false);
        Vgro.getBtn_Gimprimir().setEnabled(false);
    }

    private void habilitarBtn() {

        Vgro.getBtn_GguardarR().setEnabled(true);
        Vgro.getBtn_Gimprimir().setEnabled(true);
    }

    private void limpiarIdBuscq() {
        dni_persona = "";
        id_mascota = "";
        Vgro.getLblBselecMas().setVisible(false);
        Vgro.getScrBmascota().setVisible(false);
        Vgro.getLblBFoto().setIcon(null);
        Vgro.getLblBFoto().updateUI();
        Vgro.getTblBpersona().clearSelection();

    }

    private void limiarIdBtable() {
        dni_persona = "";
        id_mascota = "";
        Vgro.getLblBFoto().setIcon(null);
        Vgro.getLblBFoto().updateUI();
    }

}
