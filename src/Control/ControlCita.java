package Control;

import Modelo.ClasesModelo.ModeloCita;
import Modelo.ClasesModelo.ModeloCliente;
import Modelo.ClasesModelo.ModeloMascota;
import Modelo.Cliente;
import Modelo.Conexion;
import Modelo.Mascota;
import Vista.VistaCita;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseEvent;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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

public class ControlCita {

    private VistaCita vistaMP;
    private VistaCita Vcita;
    private ModeloCliente cliM;
    private ModeloCita citM;
    private ModeloMascota masM;
    private String dni_persona = "";
    private String id_mas = "";
    private JDateChooser fecha = new JDateChooser();
    private Validaciones vali = new Validaciones();
    private int i = 0;

    public ControlCita(VistaCita Vcita, ModeloCliente cliM, ModeloMascota masM, ModeloCita citC) {
        this.Vcita = Vcita;
        this.cliM = cliM;
        this.masM = masM;
        this.citM = citC;
        referenciarObjetos();
    }

    public void iniciarControl() {

        //eventos para cambiar de panel
        Vcita.getBtn_Vbuscar().addActionListener(l -> cambiarPanel("buscar"));
        Vcita.getBtn_Vregistrar().addActionListener(l -> cambiarPanel("agregar"));
        Vcita.getBtnCimprimirHis().addActionListener(l -> imprimirRepoCita());
        //eventos para las tablas 
        evtVerMascota(Vcita.getTblBpersona());
        evtVerFotoMas(Vcita.getTblBmascota());
        evtBusquedaIncre(Vcita.getTxtBpersona());
        //implementar acciones para los bonotes de cear cita o imprimir historial
        Vcita.getBtnCrearCita().addActionListener(l -> cargarDatosCitaNueva());

        //implementar acciones del segundo jpanel
        Vcita.getBtnCgenerarConsu().addActionListener(l -> generarConsulta());
        //reiniciar id al ingresar buscqueda incremental
        evtTxtReiniId(Vcita.getTxtBpersona());

    }

    ///------------------------cambio de panes ------------------------------------
    private void cambiarPanel(String tipo) {
        switch (tipo) {

            case "buscar":
                Vcita.getPnlCmascota().setVisible(false);
                Vcita.getPnlBmascota().setVisible(true);
                limpiarVconsulta();
                Vcita.getTblBpersona().clearSelection();

                break;

            case "agregar":
                limpiarVconsulta();

                Vcita.getPnlCmascota().setVisible(true);
                Vcita.getPnlBmascota().setVisible(false);
                break;

        }

    }

    //----------------------------------referenciar objetos ----------------------------------
    private void referenciarObjetos() {

        llenarTabla();
        Vcita.getScrBmascota().setVisible(false);
        Vcita.getPnlCmascota().setVisible(false);
        //desactivar boton crear cita
        desactivarBtnC();
        //desactivar alertas
        desactivarAlert();
        descativarAlert2();
        //salto de linea y no cortar palabras 
        Vcita.getTatCmotivos().setLineWrap(true);
        Vcita.getTatCobservaciones().setLineWrap(true);
        Vcita.getTatCtratamiento().setLineWrap(true);
        Vcita.getTatCmotivos().setWrapStyleWord(true);
        Vcita.getTatCobservaciones().setWrapStyleWord(true);
        Vcita.getTatCtratamiento().setWrapStyleWord(true);
    }

//    
//    
//    //------------------------------acciones solo del primer panel-------------------------
//    
    //----------------------------todo lo relacionado con tablas-----------------------
    private void llenarTabla() {

        i = 0;
        //desactivar lbl de alerta
//        Vcita.getLblAlertBne().setVisible(false);
        DefaultTableModel estructuraTabla;
        estructuraTabla = (DefaultTableModel) Vcita.getTblBpersona().getModel();
        estructuraTabla.setNumRows(0);
        List<Cliente> listC = cliM.recuperarClientes();
        listC.stream().forEach(cliente -> {
            estructuraTabla.addRow(new Object[1]);

            Vcita.getTblBpersona()
                    .setValueAt(cliente.getPer_dni(), i, 0);
            Vcita.getTblBpersona()
                    .setValueAt(cliente.getPer_nombre1(), i, 1);
            Vcita.getTblBpersona()
                    .setValueAt(cliente.getPer_apellido1(), i, 2);
            Vcita.getTblBpersona()
                    .setValueAt(cliente.getPer_apellido2(), i, 3);
            i = i + 1;
        });
    }

    private void llenarTablaMascotas(String cedula) {
        DefaultTableModel estructuraTabla;
        estructuraTabla = (DefaultTableModel) Vcita.getTblBmascota().getModel();
        estructuraTabla.setNumRows(0);
        List<Mascota> listmas = masM.consultarMascotaCedu(cedula);
        i = 0;

        if (!listmas.isEmpty()) {
            //activar tabla y label de indicacion
            Vcita.getLblBselecmas().setVisible(true);
            Vcita.getScrBmascota().setVisible(true);
            Vcita.getLblBAlertMne().setVisible(false);
            listmas.stream().forEach(mascota -> {

                estructuraTabla.addRow(new Object[2]);
                Vcita.getTblBmascota()
                        .setValueAt(mascota.getMas_id(),
                                i, 0);
                Vcita.getTblBmascota()
                        .setValueAt(mascota.getMas_nombreMas(),
                                i, 1);
                Vcita.getTblBmascota()
                        .setValueAt(mascota.getMas_especie(),
                                i, 2);
                Vcita.getTblBmascota()
                        .setValueAt(mascota.getMas_raza(),
                                i, 3);

                i = i + 1;

            });
        } else {
            Vcita.getScrBmascota().setVisible(false);
            Vcita.getLblBselecmas().setVisible(false);
            Vcita.getLblBAlertMne().setVisible(true);
        }

    }

    private void llenarTablaBusqueda(String criterio) {

        i = 0;
        DefaultTableModel estructuraTabla;
        estructuraTabla = (DefaultTableModel) Vcita.getTblBpersona().getModel();
        estructuraTabla.setNumRows(0);
        List<Cliente> listC = cliM.busquedaIncrementalCliente(criterio);

        if (!listC.isEmpty()) {
            Vcita.getLblAlertBne().setVisible(false);
            listC.stream().forEach(cliente -> {
                estructuraTabla.addRow(new Object[1]);

                Vcita.getTblBpersona()
                        .setValueAt(cliente.getPer_dni(), i, 0);
                Vcita.getTblBpersona()
                        .setValueAt(cliente.getPer_nombre1(), i, 1);
                Vcita.getTblBpersona()
                        .setValueAt(cliente.getPer_apellido1(), i, 2);
                Vcita.getTblBpersona()
                        .setValueAt(cliente.getPer_apellido2(), i, 3);
                i = i + 1;
            });
        } else {
            Vcita.getLblAlertBne().setVisible(true);
        }
    }

    //------------------------------eventos acciones al precionar en tablas -------------
    //seleccionar tabla persona
    private void evtVerMascota(JTable busqueda) {
        busqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                limiarIdBtable();
                Vcita.getBtnCimprimirHis().setEnabled(false);
                verMascotaDni(evt);

            }
        });
    }

    //eligo el id de la mascota para poner la foto
    private void evtVerFotoMas(JTable buscarMas) {

        buscarMas.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verIdMascota(evt);
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

    private void evtTxtReiniId(JTextField txt) {

        txt.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                limpiarId();

                Vcita.getScrBmascota().setVisible(false);
            }

        });
    }

    //----------------------------------------zona metodos para las tablas------------------
    private void verMascotaDni(java.awt.event.MouseEvent evt) {
        //resear los idpara la seleccion de mastoca y dni
        limpiarId();
        //guardo la cedula para buscar las mascotas
        String cedulaB = "";

        DefaultTableModel tm = (DefaultTableModel) Vcita.getTblBpersona().getModel();

        cedulaB = String.valueOf(tm.getValueAt(Vcita.getTblBpersona().getSelectedRow(), 0));
        //almaceno en dni la cedula para despues comprobar si esta seleccionado mascota y persona y pasar a la siguiente ventana
        dni_persona = cedulaB;
        llenarTablaMascotas(cedulaB);

    }

    //busco las mascotas
    private void buscar() {
        String criterio = Vcita.getTxtBpersona().getText();
        criterio=criterio.toLowerCase();
            
        if (!criterio.equals("")) {
            //buscar los clientes 
            llenarTablaBusqueda(criterio);

        } else {

            llenarTabla();
            Vcita.getLblAlertBne().setVisible(false);
        }
    }

    private void verIdMascota(java.awt.event.MouseEvent evt) {
        String idString = "";
        String id_mascota = "";

        DefaultTableModel tm = (DefaultTableModel) Vcita.getTblBmascota().getModel();
        idString = String.valueOf(tm.getValueAt(Vcita.getTblBmascota().getSelectedRow(), 0));
        //almaceno id_mascota para despues valorar y mandar a la interfaz de edicion
        id_mas = idString;

        activarVBtnC();
    }

    //------------------------metodos para los bonones---------------------
    private void cargarDatosCitaNueva() {
        if (!dni_persona.equalsIgnoreCase("") && !id_mas.equalsIgnoreCase("")) {
            recuperarMandarDatosCita();
            //descativar y activar paneles corresponidientes 
            Vcita.getPnlBmascota().setVisible(false);
            Vcita.getPnlCmascota().setVisible(true);
        } else if (dni_persona.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Seleccione un propietario");
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una mascota");
        }

    }

    private void recuperarMandarDatosCita() {

        //recupero informacion de la mascota para cargar los datos 
        Mascota mas = masM.consultarMascotaId(id_mas);
        //recupedo  imformacion de la persona para cargar los datos 
        Cliente cli = cliM.getClienteEspecifico(dni_persona);

        Vcita.getLblCcedula().setText(cli.getPer_dni());
        Vcita.getLblCnombreP().setText(cli.getPer_nombre1() + " " + cli.getPer_apellido1() + " " + cli.getPer_apellido2());
        Vcita.getLblCnombreM().setText(mas.getMas_nombreMas());
        Vcita.getLblCraza().setText(mas.getMas_raza());
        Vcita.getLblCsexo().setText(mas.getMas_sexo());
        Vcita.getLblCespecie().setText(mas.getMas_especie());

        fecha.setDate(mas.getMas_fechaNac());
        Date fechaNac = fecha.getDate();
        Vcita.getLblCedad().setText(vali.calcularEdad(fechaNac));
        Vcita.getLblCfecha().setText(LocalDate.now() + "");
        activarCbtnG();
        limpiarPersonaAnimatabla();
    }

//    
//    
//    //------------------------------acciones solo del segundo panel-------------------------
//    
    private void generarConsulta() {
        int Fc, Fr, Hidratacion, bandera = 0;
        double temperatura, peso;
        String llenadoCap, motivosCon, observa, tratami, mucosa;

        motivosCon = Vcita.getTatCmotivos().getText();
        observa = Vcita.getTatCobservaciones().getText();
        tratami = Vcita.getTatCtratamiento().getText();
        desactivarAlert();
        if (motivosCon.equalsIgnoreCase("")) {
            bandera = bandera + 1;
            Vcita.getLblAlertaCmv().setVisible(true);
        }

        if (observa.equalsIgnoreCase("")) {
            bandera = bandera + 1;
            Vcita.getLblAlertaCov().setVisible(true);
        }

        if (tratami.equalsIgnoreCase("")) {
            bandera = bandera + 1;
            Vcita.getLblAlertaCtv().setVisible(true);
        }

        if (bandera == 0) {

            //recupero los datos 
            Fc = Integer.parseInt(Vcita.getJspCFc().getValue().toString());
            Fr = Integer.parseInt(Vcita.getJspCFr().getValue().toString());
            Hidratacion = (Integer) Vcita.getJspChidra().getValue();
            temperatura = (double) Vcita.getJspCtem().getValue();
            peso = (double) Vcita.getJspCpeso().getValue();
            llenadoCap = Vcita.getTxtCllenado().getText();
            mucosa = Vcita.getCmbCmucos().getSelectedItem().toString();
            citM.setCon_motivos(motivosCon);
            citM.setCon_observaciones(observa);
            citM.setCon_tratamiento(tratami);
            citM.setCon_frecuenciaCardiaca(Fc);
            citM.setCon_fercunciaRespiratoria(Fr);
            citM.setCon_hidratacion(Hidratacion);
            citM.setCon_temperatura(temperatura);
            citM.setPeso(peso);
            citM.setCon_llenadoCapilar(llenadoCap);
            citM.setCon_muscosa(mucosa);
            citM.setCon_fecha(Date.from(Instant.now()));
            int id = Integer.parseInt(id_mas);
            citM.setMas_id(id);

            if (citM.guardarCita()) {
                JOptionPane.showMessageDialog(null, "Registro creado");
                limpiarVconsulta();
            } else {
                JOptionPane.showMessageDialog(null, "Contacte al progrados Error CC");
            }
        }
    }

    private void imprimirRepoCita() {
        String edad = Vcita.getLblCedad().getText();
        String rutaLogo = System.getProperty("user.dir");
        rutaLogo = rutaLogo + "/src/Iconos/vtMain.png";
        try {
            Conexion con = new Conexion();

            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/Vista/reportes/ReportCita.jasper"));
            //cargar ruta de imagen
            Map<String, Object> parametro = new HashMap<String, Object>();
            //ver edad
            Mascota mas = masM.consultarMascotaId(id_mas);
            fecha.setDate(mas.getMas_fechaNac());
            Date fechaNac = fecha.getDate();

            parametro.put("rutaLogo", rutaLogo);
            parametro.put("edad", vali.calcularEdad(fechaNac));

            parametro.put("idMascota", Integer.parseInt(id_mas));
            JasperPrint jp = JasperFillManager.fillReport(jr, parametro, con.getCon());
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ControlGrooming.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //------------------descativar alertas bntones etc---------------------
    private void desactivarBtnC() {

        Vcita.getBtnCimprimirHis().setEnabled(false);
        Vcita.getBtnCgenerarConsu().setEnabled(false);
    }

    private void activarVBtnC() {

        Vcita.getBtnCimprimirHis().setEnabled(true);
    }

    private void activarCbtnG() {
        Vcita.getBtnCimprimirHis().setEnabled(true);
        Vcita.getBtnCgenerarConsu().setEnabled(true);
    }

    //alertas 2 jpanel
    private void desactivarAlert() {
        Vcita.getLblAlertaCtv().setVisible(false);
        Vcita.getLblAlertaCov().setVisible(false);
        Vcita.getLblAlertaCmv().setVisible(false);
    }

    //alertas 1 jpanel
    private void descativarAlert2() {
        Vcita.getLblBAlertMne().setVisible(false);
        Vcita.getLblBselecmas().setVisible(false);
        Vcita.getLblAlertBne().setVisible(false);
    }

    private void limpiarVconsulta() {
        Vcita.getLblCcedula().setText("");
        Vcita.getLblCnombreP().setText("");
        Vcita.getLblCnombreM().setText("");
        Vcita.getLblCraza().setText("");
        Vcita.getLblCsexo().setText("");
        Vcita.getLblCespecie().setText("");
        Vcita.getJspCFc().setValue(70);
        Vcita.getJspCFr().setValue(5);
        Vcita.getJspChidra().setValue(1);
        Vcita.getJspCtem().setValue(37.5);
        Vcita.getJspCpeso().setValue(0.5);
        Vcita.getTxtCllenado().setText("");
        Vcita.getCmbCmucos().setSelectedItem("Rosado");
        Vcita.getTatCmotivos().setText("");
        Vcita.getTatCobservaciones().setText("");
        Vcita.getTatCtratamiento().setText("");
        Vcita.getLblCedad().setText("");
        Vcita.getBtnCgenerarConsu().setEnabled(false);
        limpiarId();
    }

    private void limpiarId() {
        dni_persona = "";
        id_mas = "";
    }

    private void limpiarPersonaAnimatabla() {
        Vcita.getTblBmascota().clearSelection();
        Vcita.getTblBpersona().clearSelection();
        Vcita.getScrBmascota().setVisible(false);
    }
}
