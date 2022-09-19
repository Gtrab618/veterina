package Control;

import Modelo.ClasesModelo.ModeloCliente;
import Modelo.ClasesModelo.ModeloMascota;
import Modelo.Cliente;
import Modelo.Mascota;
import Vista.VistaMascota;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ControlMascota {

    private VistaMascota Vmas;
    private ModeloCliente cliM;
    private ModeloMascota masM;
    private Validaciones vali = new Validaciones();
    private String dni_persona = "", id_mascota = "";
    private boolean banderaFoto = false;
    private JFileChooser jfc;

    private int i = 0;

    public ControlMascota(VistaMascota Vmas, ModeloCliente cliM, ModeloMascota masM) {
        this.Vmas = Vmas;
        this.cliM = cliM;
        this.masM = masM;
        referenciarObjetos();
    }

    public void iniciarControl() {

        Vmas.getBtn_Vbuscar().addActionListener(l -> cambiarPanel("buscar"));
        Vmas.getBtn_Vmodificar().addActionListener(l -> cambiarPanel("modificar"));
        Vmas.getBtnBgestionMascota().addActionListener(l -> CargarDatosModificarMascota());
        Vmas.getBtn_eliminarM().addActionListener(l -> eliminarMascota());
        Vmas.getBtn_examinarM().addActionListener(l -> cambiarFoto());
        Vmas.getBtn_modificarM().addActionListener(l -> modificarMascota());
        evtVerMascota(Vmas.getTblBpersona());
        evtVerFotoMas(Vmas.getTblBmascota());
        evtBusquedaIncre(Vmas.getTxtBpersona());
        //evento para calcular la edad cuando se modifica la fecha
        Vmas.getJdcFechaNacM().addPropertyChangeListener(l -> evtCalcularFechaNacimiento());

        //desactivo los botnes
        desabilitarBtns();

    }

    //cambiar entre ventanas de los paneles 
    private void cambiarPanel(String tipo) {
        switch (tipo) {

            case "buscar":
                //resetear la busqueda 
                limpiarBusqueda();
                //cargar las personas por defecto y desactiva el lbl de alerta
                llenarTabla();
                Vmas.getPnlBmascota().setVisible(true);
                Vmas.getPnlGestionarM().setVisible(false);
                break;

            case "modificar":
                //limpiar el panel de modificar mascota 
                limpiarVmodificarM();
                //desabilitar los botones de panel modificar mascota
                desabilitarBtns();
                desabilitarAlertarModificar();
                Vmas.getPnlBmascota().setVisible(false);
                Vmas.getPnlGestionarM().setVisible(true);
                break;

        }

    }

    private void referenciarObjetos() {
        llenarTabla();
        //dar fecha inicialmente para no causar un error
        Vmas.getJdcFechaNacM().setDate(Date.from(Instant.now()));
        //limitar rango de fechas de ingreso 
        limitarFechaJday();
        //desactivar labels
        desabilitarAlertarModificar();
        //Desactivar la tabla de mascotas para ser mostradas despues si tiene
        Vmas.getScrBmascota().setVisible(false);
        Vmas.getLblBselecMas().setVisible(false);
        Vmas.getPnlGestionarM().setVisible(false);
        Vmas.getLblAlertBne().setVisible(false);
        Vmas.getLblBAlertMne().setVisible(false);
        Vmas.getJdcFechaNacM().getDateEditor().setEnabled(false);
        //desactivar movimiento tralado de columnas jtable
        Vmas.getTblBmascota().getTableHeader().setReorderingAllowed(false);
        Vmas.getTblBpersona().getTableHeader().setReorderingAllowed(false);
    }

    //revisar que esten seleccionados tanto el id de mascota como el dni de la persona
    //para ser pasados a la interfaz de ediccion
    private void CargarDatosModificarMascota() {
        //si las dos son diferentes de vacias se pasa a la siguiente interfaz para ser modificado
        if (!dni_persona.equalsIgnoreCase("") && !id_mascota.equalsIgnoreCase("")) {
            //recupero los datos de la tabla para ser pasador a modificar
            Vmas.getPnlBmascota().setVisible(false);
            //activar panel de modificacion
            Vmas.getPnlGestionarM().setVisible(true);
            //Recuperar los datos para mandar el siguiente jpanel

            recuperarMandarDatosModificar();

        } else if (dni_persona.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null,"Seleccione un propietario");
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una mascota");
        }
    }

    //------------------------------llenar los datos Modificars-----------------------------------------------
    private void recuperarMandarDatosModificar() {

        //recupero informacion de la mascota para cargar los datos 
        Mascota mas = masM.consultarMascotaId(id_mascota);
        //recupedo  imformacion de la persona para cargar los datos 
        Cliente cli = cliM.getClienteEspecifico(dni_persona);

        //cargo los datos de la persona
        Vmas.getLblCedulaM().setText(dni_persona);
        Vmas.getLblNombrePM().setText(cli.getPer_nombre1() + " " + cli.getPer_apellido1() + " " + cli.getPer_apellido2());

        Vmas.getTxtNombreM().setText(mas.getMas_nombreMas());
        Vmas.getTxtRazaM().setText(mas.getMas_raza());
        //poner en un jcombox desde la base de datos
        Vmas.getCmb_especieM().setSelectedItem(mas.getMas_especie());
        Vmas.getCmb_sexoM().setSelectedItem(mas.getMas_sexo());
        Vmas.getJdcFechaNacM().setDate(mas.getMas_fechaNac());

        byte[] bi = mas.getFoto();

        try {
            BufferedImage image = null;
            InputStream in = new ByteArrayInputStream(bi);
            image = ImageIO.read(in);
            ImageIcon imi = new ImageIcon(image.getScaledInstance(Vmas.getLblFotoM().getWidth(), Vmas.getLblFotoM().getHeight(), Image.SCALE_SMOOTH));
            Vmas.getLblFotoM().setIcon(imi);
            Vmas.getLblFotoM().updateUI();
        } catch (IOException ex) {
            Logger.getLogger(ControlMascota.class.getName()).log(Level.SEVERE, null, ex);
        }
        //habilito los botones para la eliminacion modificacion o examinar
        habilitarBtns();
    }

    //buscar la mascota con el dni del propietario
    private void evtVerMascota(JTable busqueda) {
        busqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
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

    //busqueda incremental para la el propietario de la mascota
    private void evtBusquedaIncre(JTextField busc) {

        busc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {

                buscar();
            }
        });

    }

    private void modificarMascota() {
        desabilitarAlertarModificar();
        String nombreM = "", raza = "", especie = "", sexo = "";
        int bandera = 0;
        Date fechaNac;

        nombreM = Vmas.getTxtNombreM().getText().trim();
        raza = Vmas.getTxtRazaM().getText().trim();
        fechaNac = Vmas.getJdcFechaNacM().getDate();
        //Recuperar datos de un combobox
        especie = Vmas.getCmb_especieM().getSelectedItem().toString();
        sexo = Vmas.getCmb_sexoM().getSelectedItem().toString();

        if (!nombreM.equals("")) {
            if (!vali.valiNombreApe(nombreM)) {
                //nombre de la mascota contiene numeros
                Vmas.getLblAlertaMnf().setVisible(true);
                bandera = bandera + 1;
            }
        } else {
            //nombre de la mascota vacio

            Vmas.getLblAlertaMnv().setVisible(true);
            bandera = bandera + 1;
        }

        if (!raza.equals("")) {
            if (!vali.valiString(raza)) {
                //error raza contiene numeros
                Vmas.getLblAlertaMrf().setVisible(true);
                bandera = bandera + 1;
            }
        } else {
            //error raza esta vacio

            Vmas.getLblAlertaMrv().setVisible(true);
            bandera = bandera + 1;
        }

        //si todo esta bien re registra se actualiza la mascota
        if (bandera == 0) {

            //capitalizo la letra 
            masM.setMas_nombreMas(capitalize(nombreM));
            masM.setMas_sexo(sexo);
            masM.setMas_raza(capitalize(raza));
            masM.setMas_fechaNac(fechaNac);
            masM.setMas_especie(especie);
            //si cambia la foto 
            if (banderaFoto) {
                try {

                    byte[] bitIcon = new byte[(int) jfc.getSelectedFile().getAbsoluteFile().length()];
                    InputStream input = new FileInputStream(jfc.getSelectedFile().getAbsoluteFile());
                    input.read(bitIcon);
                    masM.setFoto(bitIcon);
                    if (masM.actualizarMascotaFoto(id_mascota)) {
                        limpiarVmodificarM();
                        desabilitarBtns();
                        JOptionPane.showMessageDialog(null, "Modificación Exitoso.");

                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ControlRegistro.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ControlRegistro.class.getName()).log(Level.SEVERE, null, ex);
                }
                //si no cambia la foto
            } else {
                if (masM.actualizarMascotaSinFoto(id_mascota)) {

                    //reiniciar panel
                    limpiarVmodificarM();
                    desabilitarBtns();
                    JOptionPane.showMessageDialog(null, "Modificación Exitoso");

                }
            }

        }

    }

    private String capitalize(final String line) {
        return Character.toUpperCase(line.charAt(0)) + line.substring(1).toLowerCase();
    }

    //cambiar de estado la mascota
    private void eliminarMascota() {

        int respuesta = 0;

        respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Eliminar!", JOptionPane.YES_NO_OPTION);
        if (respuesta == 0) {

            if (masM.eliminarMascota(id_mascota)) {
                limpiarVmodificarM();
                desabilitarBtns();
                JOptionPane.showMessageDialog(null, "Mascota elimina");

            }

        } else {

            JOptionPane.showMessageDialog(null, "Cancelado");

        }

    }

    //calcular fecha
    private void evtCalcularFechaNacimiento() {

        //llamo al medoto validacion para calcular la edad actual
        Vmas.getLblEdadMas().setText(vali.calcularEdad(Vmas.getJdcFechaNacM().getDate()));

    }

    private void limitarFechaJday() {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha = formato.parse("01/11/1999");
            Vmas.getJdcFechaNacM().setSelectableDateRange(fecha, Date.from(Instant.now()));
        } catch (ParseException ex) {
            Logger.getLogger(ControlRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //buscar foto de mascota
    private void cambiarFoto() {
        jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = jfc.showOpenDialog(Vmas);

        if (estado == JFileChooser.APPROVE_OPTION) {

            try {
                Image imagen = ImageIO.read(jfc.getSelectedFile()).getScaledInstance(Vmas.getLblFotoM().getWidth(), Vmas.getLblFotoM().getHeight(), Image.SCALE_DEFAULT);

                Icon icono = new ImageIcon(imagen);
                Vmas.getLblFotoM().setIcon(icono);
                Vmas.getLblFotoM().updateUI();

                banderaFoto = true;

                //el ioexcepcio tambien captura las imagenes png por lo que para ver si el archivo es compatible se crea el null exption
            } catch (IOException ex) {
                Logger.getLogger(ControlRegistro.class.getName()).log(Level.SEVERE, null, ex);

                //no detecta los png y si otros formatos que no sean  de tipo foto
            } catch (NullPointerException ex) {

                JOptionPane.showMessageDialog(null, "Formato de archivo no admitido", "Revise el archivo", JOptionPane.ERROR_MESSAGE);

            }

        }
    }

    //recuper el criterio de buscque si este esta vacio lleno la tabla con todos las personas
    //registradas
    private void buscar() {
        String criterio = Vmas.getTxtBpersona().getText();

        if (!criterio.equals("")) {
            //buscar los clientes 
            llenarTablaBusqueda(criterio);

        } else {

            llenarTabla();
            Vmas.getLblAlertBne().setVisible(false);
        }
    }

    //busqueda incremental
    private void llenarTablaBusqueda(String criterio) {

        i = 0;
        DefaultTableModel estructuraTabla;
        estructuraTabla = (DefaultTableModel) Vmas.getTblBpersona().getModel();
        estructuraTabla.setNumRows(0);
        List<Cliente> listC = cliM.busquedaIncrementalCliente(criterio);

        if (!listC.isEmpty()) {
            Vmas.getLblAlertBne().setVisible(false);
            listC.stream().forEach(cliente -> {
                estructuraTabla.addRow(new Object[1]);

                Vmas.getTblBpersona()
                        .setValueAt(cliente.getPer_dni(), i, 0);
                Vmas.getTblBpersona()
                        .setValueAt(cliente.getPer_nombre1(), i, 1);
                Vmas.getTblBpersona()
                        .setValueAt(cliente.getPer_apellido1(), i, 2);
                Vmas.getTblBpersona()
                        .setValueAt(cliente.getPer_apellido2(), i, 3);
                i = i + 1;
            });
        } else {
            Vmas.getLblAlertBne().setVisible(true);
        }
    }

    //Recuperar el id de la mascota para poner mostrar a la gente
    private void ponerFotoMascota(java.awt.event.MouseEvent evt) {
        String idString = "";
        int id = 0;

        DefaultTableModel tm = (DefaultTableModel) Vmas.getTblBmascota().getModel();
        idString = String.valueOf(tm.getValueAt(Vmas.getTblBmascota().getSelectedRow(), 0));
        //almaceno id_mascota para despues valorar y mandar a la interfaz de edicion
        id_mascota = idString;
        id = Integer.parseInt(idString);
        BuscarFotoMascota(id);

    }

    private void BuscarFotoMascota(int id) {
        Mascota masF = new Mascota();
        masF = masM.verFotoMascota(id);

        //llenar imagen
        byte[] bi = masF.getFoto();
        if (bi != null) {

            try {
                BufferedImage image = null;
                InputStream in = new ByteArrayInputStream(bi);
                image = ImageIO.read(in);
                ImageIcon imi = new ImageIcon(image.getScaledInstance(Vmas.getLblBFoto().getWidth(), Vmas.getLblBFoto().getHeight(), Image.SCALE_SMOOTH));
                Vmas.getLblBFoto().setIcon(imi);
                Vmas.getLblBFoto().updateUI();

            } catch (IOException ex) {
                Logger.getLogger(ControlMascota.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            Vmas.getLblBFoto().setIcon(null);
            Vmas.getLblBFoto().updateUI();
        }
    }

    //Recuperar la cedula para cargar las mascotas que esten asociadas a al persona
    private void verMascotaDni(java.awt.event.MouseEvent evt) {
        //resear los idpara la seleccion de mastoca y dni
        formatearIds();

        //guardo la cedula para buscar las mascotas
        String cedulaB = "";

        DefaultTableModel tm = (DefaultTableModel) Vmas.getTblBpersona().getModel();

        cedulaB = String.valueOf(tm.getValueAt(Vmas.getTblBpersona().getSelectedRow(), 0));
        //almaceno en dni la cedula para despues comprobar si esta seleccionado mascota y persona y pasar a la siguiente ventana
        dni_persona = cedulaB;
        llenarTablaMascotas(cedulaB);

    }

    private void llenarTablaMascotas(String cedula) {
        DefaultTableModel estructuraTabla;
        estructuraTabla = (DefaultTableModel) Vmas.getTblBmascota().getModel();
        estructuraTabla.setNumRows(0);
        List<Mascota> listmas = masM.consultarMascotaCedu(cedula);
        i = 0;

        if (!listmas.isEmpty()) {
            //activar tabla y label de indicacion
            Vmas.getLblBselecMas().setVisible(true);
            Vmas.getScrBmascota().setVisible(true);
            Vmas.getLblBAlertMne().setVisible(false);

            listmas.stream().forEach(mascota -> {

                estructuraTabla.addRow(new Object[2]);
                Vmas.getTblBmascota()
                        .setValueAt(mascota.getMas_id(),
                                i, 0);
                Vmas.getTblBmascota()
                        .setValueAt(mascota.getMas_nombreMas(),
                                i, 1);
                Vmas.getTblBmascota()
                        .setValueAt(mascota.getMas_especie(),
                                i, 2);
                Vmas.getTblBmascota()
                        .setValueAt(mascota.getMas_raza(),
                                i, 3);

                i = i + 1;

            });
        } else {
            Vmas.getScrBmascota().setVisible(false);
            Vmas.getLblBselecMas().setVisible(false);
            Vmas.getLblBAlertMne().setVisible(true);
        }

    }

    private void llenarTabla() {

        i = 0;
        //desactivar lbl de alerta
        Vmas.getLblAlertBne().setVisible(false);
        DefaultTableModel estructuraTabla;
        estructuraTabla = (DefaultTableModel) Vmas.getTblBpersona().getModel();
        estructuraTabla.setNumRows(0);
        List<Cliente> listC = cliM.recuperarClientes();
        listC.stream().forEach(cliente -> {
            estructuraTabla.addRow(new Object[1]);

            Vmas.getTblBpersona()
                    .setValueAt(cliente.getPer_dni(), i, 0);
            Vmas.getTblBpersona()
                    .setValueAt(cliente.getPer_nombre1(), i, 1);
            Vmas.getTblBpersona()
                    .setValueAt(cliente.getPer_apellido1(), i, 2);
            Vmas.getTblBpersona()
                    .setValueAt(cliente.getPer_apellido2(), i, 3);
            i = i + 1;
        });
    }

    private void formatearIds() {
        dni_persona = "";
        id_mascota = "";
    }

    private void limpiarBusqueda() {
        //texto de busqueda vacio
        Vmas.getTxtBpersona().setText("");
        //esconder la tabla mascotas 
        Vmas.getScrBmascota().setVisible(false);
        //desactivar lbl selecione mascotas 
        Vmas.getLblBselecMas().setVisible(false);
        //quitar la foto de la mascota 
        Vmas.getLblBFoto().setIcon(null);
        //vRegis.getTblBusqueda().clearSelection();
        Vmas.getLblBAlertMne().setVisible(false);
    }

    //descativar botones de eliminar o modificar para evitar validaciones
    private void desabilitarBtns() {
        Vmas.getBtn_eliminarM().setEnabled(false);
        Vmas.getBtn_modificarM().setEnabled(false);
        Vmas.getBtn_examinarM().setEnabled(false);
    }

    private void desabilitarAlertarModificar() {
        Vmas.getLblAlertaMnf().setVisible(false);
        Vmas.getLblAlertaMnv().setVisible(false);
        Vmas.getLblAlertaMrf().setVisible(false);
        Vmas.getLblAlertaMrv().setVisible(false);
    }

    private void habilitarBtns() {
        Vmas.getBtn_eliminarM().setEnabled(true);
        Vmas.getBtn_modificarM().setEnabled(true);
        Vmas.getBtn_examinarM().setEnabled(true);
    }

    private void limpiarVmodificarM() {
        Vmas.getLblCedulaM().setText("");
        Vmas.getLblNombrePM().setText("");
        Vmas.getTxtNombreM().setText("");
        Vmas.getTxtRazaM().setText("");
        Vmas.getJdcFechaNacM().setDate(Date.from(Instant.now()));
        Vmas.getLblFotoM().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/vtMain.png")));
        dni_persona = "";
        id_mascota = "";
        banderaFoto = false;
    }

}
