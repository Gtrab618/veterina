package Control;

import Modelo.ClasesModelo.ModeloCliente;
import Modelo.ClasesModelo.ModeloPersona;
import Modelo.ClasesModelo.ModeloMascota;
import Modelo.Cliente;
import Modelo.Mascota;
import Vista.vistaRegistro;
import com.toedter.calendar.JDateChooser;
import java.awt.Image;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
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

/**
 *
 * @author Usuario
 */
public class ControlRegistro {

    private vistaRegistro vRegis;
    private ModeloPersona Mper;
    private ModeloMascota Mmas;
    private ModeloCliente Ccli;
    private Validaciones vali = new Validaciones();
    private JFileChooser jfc;
    //cedula que se recupera desde la tabla para ser modificada posteroirmente
    private String cedulaB;
    private int idCli;
    private boolean banderaRegistro = true;
    private int i;
    private boolean banderaFoto;

    public ControlRegistro(vistaRegistro vRegis, ModeloPersona Mper, ModeloMascota Mmas, ModeloCliente Ccli) {
        this.vRegis = vRegis;
        this.Mper = Mper;
        this.Mmas = Mmas;
        this.Ccli = Ccli;
        referenciarObjetos();
    }

    public void iniciarControl() {
        //Al dar clic en la tabla busqueda tiene que dirigir 
        //una de las dos ventanas 
        evtBusquedaVentana(vRegis.getTblBusqueda());
        vRegis.getBtn_registrarR().addActionListener(l -> registrar());
        vRegis.getBtn_examinarR().addActionListener(l -> examinarFoto());
        vRegis.getBtn_Vbuscar().addActionListener(l -> cambiarPanel("buscar"));
        vRegis.getBtn_Vregistrar().addActionListener(l -> cambiarPanel("registrar"));
        vRegis.getBtn_Vmodificar().addActionListener(l -> cambiarPanel("modificar"));
        vRegis.getBtn_modificar().addActionListener(l -> modificarCliente());
        vRegis.getBtn_eliminar().addActionListener(l -> EliminarCliente());
        vRegis.getBtn_Bmodificar().addActionListener(l -> dirigerModificarCli(cedulaB));
        vRegis.getBtn_Bregistrar().addActionListener(l -> registrarCliente(cedulaB));
        vRegis.getBtn_cancelarR().addActionListener(l -> cancelar());
        //ver si hay algun cambio en la fecha para calcular la edad
        vRegis.getDtc_fechaNac().addPropertyChangeListener(l->evtCalcularFechaNacimiento());
        evtBusquedaIncre(vRegis.getTxt_buscar());
        evtTxtControl(vRegis.getTxt_Mcedula());
        evtTxtControlRegis(vRegis.getTxt_cedulaR());
    }

    private void cambiarPanel(String tipo) {
        limpiarModificacion();
        limpiarRegistro();
        desactivarLblVRegis();
        if (tipo.equalsIgnoreCase("buscar")) {
            limpiarBusqueda();
            llenarTabla();
            vRegis.getPnl_busqueda().setVisible(true);
            vRegis.getPnlRegistro().setVisible(false);
            vRegis.getPnlModificar().setVisible(false);
        } else if (tipo.equalsIgnoreCase("registrar")) {
            vRegis.getPnl_busqueda().setVisible(false);
            vRegis.getPnlRegistro().setVisible(true);
            vRegis.getPnlModificar().setVisible(false);
        } else if (tipo.equalsIgnoreCase("modificar")) {
            vRegis.getPnlModificar().setVisible(true);
            vRegis.getPnl_busqueda().setVisible(false);
            vRegis.getPnlRegistro().setVisible(false);
        }

    }

    private void examinarFoto() {
        
        jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = jfc.showOpenDialog(vRegis);

        if (estado == JFileChooser.APPROVE_OPTION) {

            try {
                Image imagen = ImageIO.read(jfc.getSelectedFile()).getScaledInstance(vRegis.getLbl_foto().getWidth(), vRegis.getLbl_foto().getHeight(), Image.SCALE_DEFAULT);

                Icon icono = new ImageIcon(imagen);
                vRegis.getLbl_foto().setIcon(icono);
                vRegis.getLbl_foto().updateUI();

                banderaFoto = true;
                
               //el ioexcepcio tambien captura las imagenes png por lo que para ver si el archivo es compatible se crea el null exption
            } catch (IOException ex) {
                Logger.getLogger(ControlRegistro.class.getName()).log(Level.SEVERE, null, ex);

                //no detecta los png y si otros formatos que no sean  de tipo foto
            }catch (NullPointerException ex) {
                
                JOptionPane.showMessageDialog(null,"Formato de archivo no admitido" , "Revise el archivo", JOptionPane.ERROR_MESSAGE);
               
            }
           

        }

    }

    private void referenciarObjetos() {
       
            desactivarLblVRegis();
            
            //salto de linea vistaRegistro tat
            vRegis.getTat_direccionR().setLineWrap(true);
            //Evitar corte de palabras por la mitad
            vRegis.getTat_direccionR().setWrapStyleWord(true);
            //poner la fecha acutal el en jcaledary
            vRegis.getDtc_fechaNac().setDate(Date.from(Instant.now()));
            //!!!!!!!!!!!!!!!!!!!!!!desabilitar que introdusca la fecha manualmente!!!!!!!!!!!!!!!!!!!!!!!
            vRegis.getDtc_fechaNac().getDateEditor().setEnabled(false);
            
            //poner un rango de fecha para que el usuario no lo sobre pase la fecha actual
            limitarFechaJday();
                
            //linea de prueba hay que borrar mas despues
            vRegis.getPnl_busqueda().setVisible(false);
            vRegis.getPnlModificar().setVisible(false);
        
    }
    
    private void limitarFechaJday(){
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha = formato.parse("01/11/1999");
            vRegis.getDtc_fechaNac().setSelectableDateRange(fecha, Date.from(Instant.now()));
        } catch (ParseException ex) {
            Logger.getLogger(ControlRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //sierve para recuperar la cedula y guardar los datos
    private void evtTxtControl(JTextField txt) {

        txt.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                desactivarLblVRegis();
                int bandera = 0;
                String cedula = "";
                cedula = vRegis.getTxt_Mcedula().getText().trim();

                if (!cedula.equalsIgnoreCase("")) {

                    bandera = vali.valiCedula(cedula);

                    switch (bandera) {
                        case 0:
                            Cliente clien = Ccli.getClienteEspecifico(cedula);

                            //si la cedula es valida y esta guardado en la base de datos
                            if (clien.getPer_dni() != null) {
                                vRegis.getTxt_Mcedula().setEnabled(false);
                                //recupero los datos para ser llenados y modificados 
                                recuperarDatos(clien);
                                //Activar botones para modificar o eliminar
                                vRegis.getBtn_modificar().setEnabled(true);
                                vRegis.getBtn_eliminar().setEnabled(true);
                                //si la cedula es valida pero no esta guardado en la base de datos
                            } else {

                                vRegis.getLblAlertaMcne().setVisible(true);

                            }
                            break;
                        case 1:
                            vRegis.getLblAlertaMcnv().setVisible(true);

                            break;
                        case 2:
                            //cedula con formato erroneo
                            vRegis.getLblAlertaMcf().setVisible(true);

                            break;
                    }

                }
            }
        });
    }

    //sierve para ver si la cedula ya esta reigistrada y no cargar los datos de nuevo
    private void evtTxtControlRegis(JTextField txt) {
        txt.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {

                int bandera = 0;
                idCli = 0;
                String cedula = "";
                cedula = vRegis.getTxt_cedulaR().getText().trim();

                if (!cedula.equalsIgnoreCase("")) {

                    bandera = vali.valiCedula(cedula);

                    switch (bandera) {
                        case 0:
                            Cliente clien = Ccli.getClienteEspecifico(cedula);

                            //si la cedula es valida y esta guardado en la base de datos
                            if (clien.getPer_dni() != null) {

                                idCli = clien.getCli_id();
                                //con la bandera eligo el tipo de registro si es completo o solo la mascota
                                desactivarRegistroPerson();
                                desactivarLblVRegis();
                                JOptionPane.showMessageDialog(null, "Cliente encontrado Por favor ingrese los datos de la mascota");

                                //si la cedula es valida pero no esta guardado en la base de datos
                            } else {
                                banderaRegistro = true;

                            }

                    }

                }
            }
        });
    }

    //cuando se acutaliza la fecha calcular la edad
    private void evtCalcularFechaNacimiento() {
        
        //llamo al medoto validacion para calcular la edad actual
        vRegis.getLblEdadMas().setText(vali.calcularEdad(vRegis.getDtc_fechaNac().getDate()));
        
    }

    private void evtBusquedaIncre(JTextField busc) {

        busc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {

                buscar();
            }
        });

    }

    private void evtBusquedaVentana(JTable busqueda) {
        busqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verIdDatos(evt);
            }
        });

    }

    //capitalizar letra
    private String capitalize(final String line) {
        return Character.toUpperCase(line.charAt(0)) + line.substring(1).toLowerCase();
    }

    private void registrar() {

        desactivarLblVRegis();
        //sirve para saber si el usuario ya esta registro o hay que registrar
        if (banderaRegistro) {
            //iMPLEMENTAR METODO LIMPIAR 

            int bandera = 0, id = 0;
            String cedula = "", nombre = "", pApellido = "",
                    sApellido = "", telefono = "", direccion = "",
                    nombreM = "", raza = "", especie = "", sexo = "";
            Date fechaNac;
            //Recupero los datos
            cedula = vRegis.getTxt_cedulaR().getText().trim();
            nombre = vRegis.getTxt_nombreR().getText().trim();
            pApellido = vRegis.getTxt_pApellidoR().getText().trim();
            sApellido = vRegis.getTxt_sApellidoR().getText().trim();
            telefono = vRegis.getTxt_telefonoR().getText().trim();
            direccion = vRegis.getTat_direccionR().getText().trim();
            nombreM = vRegis.getTxt_nombreMR().getText().trim();
            raza = vRegis.getTxt_razaR().getText().trim();
            fechaNac=vRegis.getDtc_fechaNac().getDate();
            //Recuperar datos de un combobox
            especie = vRegis.getCmb_especieR().getSelectedItem().toString();
            sexo = vRegis.getCmb_sexoR().getSelectedItem().toString();

            if (!cedula.equals("")) {
                bandera = vali.valiCedula(cedula);

                switch (bandera) {

                    case 1:
                        vRegis.getLblAlertaCnv().setVisible(true);
                        bandera = bandera + 1;
                        break;
                    case 2:
                        vRegis.getLblAlertaCf().setVisible(true);
                        bandera = bandera + 1;
                        break;
                }

            } else {

                vRegis.getLblAlertaCcv().setVisible(true);
                bandera = bandera + 1;
            }
            if (!nombre.equals("")) {
                if (!vali.valiString(nombre)) {
                    //nombre formato incorrecto
                    vRegis.getLblAlertaNf().setVisible(true);
                    bandera = bandera + 1;
                }
            } else {
                //campo vacio
                vRegis.getLblAlertaNv().setVisible(true);
                bandera = bandera + 1;
            }

            if (!pApellido.equals("")) {
                if (!vali.valiNombreApe(pApellido)) {
                    //papellido error de formato
                    vRegis.getLblAlertaPAf().setVisible(true);
                    bandera = bandera + 1;
                }
            } else {
                //campo vacio
                vRegis.getLblAlertaPAv().setVisible(true);
                bandera = bandera + 1;
            }

            if (!sApellido.equals("")) {
                if (!vali.valiNombreApe(sApellido)) {
                    //error contiene numeros
                    vRegis.getLblAlertaSAf().setVisible(true);
                    bandera = bandera + 1;
                }
            } else {
                //error campo vacio
                vRegis.getLblAlertaSAv().setVisible(true);
                bandera = bandera + 1;
            }

            if (!telefono.equals("")) {
                bandera = vali.valiNumTelefono(telefono);

                switch (bandera) {
                    case 1:
                        //telefono error longitud
                        vRegis.getLblAlertaTnv().setVisible(true);
                        bandera = bandera + 1;
                        break;
                    case 2:
                        //telefono error contiene letras
                        vRegis.getLblAlertaTf().setVisible(true);
                        bandera = bandera + 1;
                        break;

                }
            }

            if (!direccion.equals("")) {
                if (!vali.valiDirec(direccion)) {
                    //error direccion muy corta
                    vRegis.getLblAlertaDf().setVisible(true);
                    bandera = bandera + 1;
                }
            }
            if (!nombreM.equals("")) {
                if (!vali.valiNombreApe(nombreM)) {
                    //nombre de la mascota contiene numeros
                    vRegis.getLblAlertaNMf().setVisible(true);
                    bandera = bandera + 1;
                }
            } else {
                //nombre de la mascota vacio
                vRegis.getLblAlertaNMv().setVisible(true);
                bandera = bandera + 1;
            }

            if (!raza.equals("")) {
                if (!vali.valiString(raza)) {
                    //error raza contiene numeros
                    vRegis.getLblAlertaRf().setVisible(true);
                    bandera = bandera + 1;
                }
            } else {
                //error raza esta vacio
                vRegis.getLblAlertaRv().setVisible(true);
                bandera = bandera + 1;
            }
            //--------------------revisar--------------------------------------------
            //validar  que la fecha sea anteroir a la actual
//            if (vali.validarFechaNac(vRegis.getDtc_fechaNac().getDate())) {
//                System.out.println(vali.calcularEdad(vRegis.getDtc_fechaNac().getDate()));
//
//                //fecha no valida
//            } else {
//                System.out.println("ingrese una fecha menor a la actual");
//            }

            if (bandera == 0) {
                //capitalizar la letra         
                nombre = capitalize(nombre);
                pApellido = capitalize(pApellido);
                sApellido = capitalize(sApellido);
                nombreM = capitalize(nombreM);
                raza = capitalize(raza);
                //Recuperar datos de un combobox

                //Guardar persona
                Mper.setPer_dni(cedula);
                Mper.setPer_nombre1(nombre);
                Mper.setPer_apellido1(pApellido);
                Mper.setPer_apellido2(sApellido);

                //Recuperar id persona
                id = Mper.guardarPersonaId();

                //Guardar cliente
                Ccli.setCli_direccion(direccion);
                Ccli.setCli_telefono(telefono);
                Ccli.setPer_idFk(id);

                //recuperar id para guardar mascota
                id = Ccli.guardarClienteRId();

                //Guardar mascota
                Mmas.setMas_nombreMas(nombreM);
                Mmas.setMas_sexo(sexo);
                Mmas.setMas_raza(raza);
                Mmas.setMas_especie(especie);
                Mmas.setCli_idFK(id);
                Mmas.setMas_fechaNac(fechaNac);
                //Recuperar foto
                if (banderaFoto) {

                    try {

                        byte[] bitIcon = new byte[(int) jfc.getSelectedFile().getAbsoluteFile().length()];
                        InputStream input = new FileInputStream(jfc.getSelectedFile().getAbsoluteFile());
                        input.read(bitIcon);
                        Mmas.setFoto(bitIcon);
                        if (Mmas.guardarMascota()) {
                            JOptionPane.showMessageDialog(vRegis, "Registro Exitoso");
                        }
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(ControlRegistro.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(ControlRegistro.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //si no tiene foto precargar una para evitar una expcion
                } else {
                    //Recuperar ruta del sistema para guradar una imagen en caso 
                    //que este vacia 
                    String ruta = System.getProperty("user.dir");
                    ruta = ruta + "/src/Iconos/mascotasFoto.png";

                    try {
                        File Icon = new File(ruta);

                        byte[] bitIcon = new byte[(int) Icon.length()];
                        InputStream input = new FileInputStream(Icon);
                        input.read(bitIcon);
                        Mmas.setFoto(bitIcon);
                        if (Mmas.guardarMascota()) {
                            JOptionPane.showMessageDialog(vRegis, "Registro Exitoso");
                        }

                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(ControlRegistro.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(ControlRegistro.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

                limpiarRegistro();

            }

            //registrar solo mascota
        } else if (!banderaRegistro) {
            String nombreM = "", raza = "", especie = "", sexo = "";
            int bandera = 0;
            Date fechaNac;

            nombreM = vRegis.getTxt_nombreMR().getText().trim();
            raza = vRegis.getTxt_razaR().getText().trim();
            fechaNac= vRegis.getDtc_fechaNac().getDate();
            //Recuperar datos de un combobox
            especie = vRegis.getCmb_especieR().getSelectedItem().toString();
            sexo = vRegis.getCmb_sexoR().getSelectedItem().toString();

            if (!nombreM.equals("")) {
                if (!vali.valiNombreApe(nombreM)) {
                    //nombre de la mascota contiene numeros
                    vRegis.getLblAlertaNMf().setVisible(true);
                    bandera = bandera + 1;
                }
            } else {
                //nombre de la mascota vacio
                vRegis.getLblAlertaNMv().setVisible(true);
                bandera = bandera + 1;
            }

            if (!raza.equals("")) {
                if (!vali.valiString(raza)) {
                    //error raza contiene numeros
                    vRegis.getLblAlertaRf().setVisible(true);
                    bandera = bandera + 1;
                }
            } else {
                //error raza esta vacio
                vRegis.getLblAlertaRv().setVisible(true);
                bandera = bandera + 1;
            }

            if (bandera == 0) {

                //capitalizo la letra
                nombreM = capitalize(nombreM);
                raza = capitalize(raza);

                Mmas.setMas_nombreMas(nombreM);
                Mmas.setMas_sexo(sexo);
                Mmas.setMas_raza(raza);
                Mmas.setMas_fechaNac(fechaNac);
                Mmas.setMas_especie(especie);
                Mmas.setCli_idFK(idCli);

                //si la mascota tiene o no tiene foto
                if (banderaFoto) {

                    try {

                        byte[] bitIcon = new byte[(int) jfc.getSelectedFile().getAbsoluteFile().length()];
                        InputStream input = new FileInputStream(jfc.getSelectedFile().getAbsoluteFile());
                        input.read(bitIcon);
                        Mmas.setFoto(bitIcon);
                        if (Mmas.guardarMascota()) {
                            JOptionPane.showMessageDialog(vRegis, "Registro Exitoso");

                        }

                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(ControlRegistro.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(ControlRegistro.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //si no tiene foto precargar una para evitar una expcion
                } else {
                    //Recuperar ruta del sistema para guradar una imagen en caso 
                    //que este vacia 
                    String ruta = System.getProperty("user.dir");
                    ruta = ruta + "/src/Iconos/mascotasFoto.png";

                    try {
                        File Icon = new File(ruta);

                        byte[] bitIcon = new byte[(int) Icon.length()];
                        InputStream input = new FileInputStream(Icon);
                        input.read(bitIcon);
                        Mmas.setFoto(bitIcon);
                        if (Mmas.guardarMascota()) {
                            JOptionPane.showMessageDialog(vRegis, "Registro Exitoso");

                        }

                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(ControlRegistro.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(ControlRegistro.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                idCli = 0;
                limpiarRegistro();
            }
        }

    }

    private void recuperarDatos(Cliente cli) {

        String cedula = "", nombre = "", pApellido = "",
                sApellido = "", telefono = "", direccion = "";

        nombre = cli.getPer_nombre1();
        pApellido = cli.getPer_apellido1();
        sApellido = cli.getPer_apellido2();
        telefono = cli.getCli_telefono();
        direccion = cli.getCli_direccion();

        vRegis.getTxt_Mnombre().setText(nombre);
        vRegis.getTxt_MPApellido().setText(pApellido);
        vRegis.getTxt_MSApellido().setText(sApellido);
        vRegis.getTxt_Mtelefono().setText(telefono);
        vRegis.getTat_Mdireccion().setText(direccion);

    }

    private void modificarCliente() {
        //iMPLEMENTAR METODO desactivar label
        desactivarLblVRegis();
        int bandera = 0;
        String cedula = "", nombre = "", pApellido = "",
                sApellido = "", telefono = "", direccion = "";

        cedula = vRegis.getTxt_Mcedula().getText().trim();
        nombre = vRegis.getTxt_Mnombre().getText().trim();
        pApellido = vRegis.getTxt_MPApellido().getText().trim();
        sApellido = vRegis.getTxt_MSApellido().getText().trim();
        telefono = vRegis.getTxt_Mtelefono().getText().trim();
        direccion = vRegis.getTat_Mdireccion().getText().trim();

        if (!nombre.equals("")) {
            if (!vali.valiNombreApe(nombre)) {
                //nombre formato incorrecto

                bandera = bandera + 1;
            }
        } else {
            //campo vacio
            vRegis.getLblAlertaMnv().setVisible(true);
            bandera = bandera + 1;
        }

        if (!pApellido.equals("")) {
            if (!vali.valiNombreApe(pApellido)) {
                //papellido error de formato
                vRegis.getLblAlertaPAf().setVisible(true);
                bandera = bandera + 1;
            }
        } else {
            //campo vacio
            vRegis.getLblAlertaMpav().setVisible(true);
            bandera = bandera + 1;
        }

        if (!sApellido.equals("")) {
            if (!vali.valiNombreApe(sApellido)) {
                //error contiene numeros
                vRegis.getLblAlertaSAf().setVisible(true);
                bandera = bandera + 1;
            }
        } else {
            //error campo vacio
            vRegis.getLblAlertaMsav().setVisible(true);
            bandera = bandera + 1;
        }

        if (!telefono.equals("")) {
            bandera = vali.valiNumTelefono(telefono);

            switch (bandera) {
                case 1:
                    //telefono error longitud
                    vRegis.getLblAlertaMtnv().setVisible(true);
                    bandera = bandera + 1;
                    break;
                case 2:
                    //telefono error contiene letras
                    vRegis.getLblAlertaMtf().setVisible(true);
                    bandera = bandera + 1;
                    break;

            }
        }

        if (!direccion.equals("")) {
            if (!vali.valiDirec(direccion)) {
                //error direccion muy corta
                vRegis.getLblAlertaMdf().setVisible(true);
                bandera = bandera + 1;
            }
        }

        if (bandera == 0) {

            Ccli.setPer_nombre1(nombre);
            Ccli.setPer_apellido1(pApellido);
            Ccli.setPer_apellido2(sApellido);
            Ccli.setCli_direccion(direccion);
            Ccli.setCli_telefono(telefono);

            if (Ccli.updateCliente(cedula) && Ccli.updatePersona(cedula)) {
                JOptionPane.showMessageDialog(vRegis, "Cliente Modificado");
                limpiarModificacion();
            }

        }

    }

    private void EliminarCliente() {
        String cedula = "";
        cedula = vRegis.getTxt_Mcedula().getText();

        llenarTablaMascotas(cedula);
        vRegis.getScr_Mascota().setVisible(true);
        if (Mmas.consultarMascotaCedu(cedula).isEmpty()) {

            int respuesta = 0;

            respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Eliminar!", JOptionPane.YES_NO_OPTION);
            if (respuesta == 0) {
                Ccli.eliminarCliente(cedula);
                limpiarModificacion();
            } else {

                JOptionPane.showMessageDialog(vRegis, "Cancelado");

            }
        } else {
            JOptionPane.showMessageDialog(null, "Elimine a las mascotas primero", "Accion no permitida", JOptionPane.ERROR_MESSAGE);

        }

    }

    //desde la tabla busqueda dirige a recupera el cliente para ser modificado o eliminados posteior mente
    private void dirigerModificarCli(String cedula) {

        vRegis.getPnlModificar().setVisible(true);
        vRegis.getPnl_busqueda().setVisible(false);
        vRegis.getTxt_Mcedula().setText(cedula);
        //desabilitar boton para que no realize busquedas 
        vRegis.getTxt_Mcedula().setEnabled(false);
        vRegis.getBtn_modificar().setEnabled(true);
        vRegis.getBtn_eliminar().setEnabled(true);
        Cliente clien = Ccli.getClienteEspecifico(cedula);
        recuperarDatos(clien);

    }

    private void registrarCliente(String cedula) {

        vRegis.getTxt_cedulaR().setText(cedula);
        vRegis.getPnl_busqueda().setVisible(false);
        vRegis.getPnlRegistro().setVisible(true);
        Cliente clien = Ccli.getClienteEspecifico(cedula);
        idCli = clien.getCli_id();
        //desactiva atributos cuando la persona es registrada
        desactivarRegistroPerson();
        JOptionPane.showMessageDialog(null, "Ingrese datos de la Mascota");

    }

    private void desactivarRegistroPerson() {
        vRegis.getTxt_cedulaR().setEnabled(false);
        vRegis.getTxt_nombreR().setEditable(false);
        vRegis.getTxt_pApellidoR().setEditable(false);
        vRegis.getTxt_sApellidoR().setEditable(false);
        vRegis.getTxt_telefonoR().setEditable(false);
        vRegis.getTat_direccionR().setEditable(false);
        banderaRegistro = false;
    }

    private void verIdDatos(java.awt.event.MouseEvent evt) {
        cedulaB = "";
        vRegis.getBtn_Bmodificar().setEnabled(true);
        vRegis.getBtn_Bregistrar().setEnabled(true);
        DefaultTableModel tm = (DefaultTableModel) vRegis.getTblBusqueda().getModel();

        cedulaB = String.valueOf(tm.getValueAt(vRegis.getTblBusqueda().getSelectedRow(), 1));

    }

    private void buscar() {
        String criterio = vRegis.getTxt_buscar().getText();

        if (!criterio.equals("")) {

            llenarTablaBusqueda(criterio);

        } else {

            llenarTabla();
            vRegis.getLblAlertBne().setVisible(false);
        }
    }

    //busqueda incremental
    private void llenarTablaBusqueda(String criterio) {
        i = 0;
        DefaultTableModel estructuraTabla;
        estructuraTabla = (DefaultTableModel) vRegis.getTblBusqueda().getModel();
        estructuraTabla.setNumRows(0);
        criterio = criterio.toLowerCase();
        List<Cliente> listC = Ccli.busquedaIncrementalCliente(criterio);

        if (!listC.isEmpty()) {
            vRegis.getLblAlertBne().setVisible(false);
            listC.stream().forEach(cliente -> {
                estructuraTabla.addRow(new Object[3]);

                vRegis.getTblBusqueda()
                        .setValueAt(cliente.getCli_id(), i, 0);
                vRegis.getTblBusqueda()
                        .setValueAt(cliente.getPer_dni(), i, 1);
                vRegis.getTblBusqueda()
                        .setValueAt(cliente.getPer_nombre1(), i, 2);
                vRegis.getTblBusqueda()
                        .setValueAt(cliente.getPer_apellido1(), i, 3);
                vRegis.getTblBusqueda()
                        .setValueAt(cliente.getPer_apellido2(), i, 4);
                i = i + 1;
            });

        } else {
            vRegis.getLblAlertBne().setVisible(true);
        }

    }

    private void llenarTablaMascotas(String cedula) {
        DefaultTableModel estructuraTabla;
        estructuraTabla = (DefaultTableModel) vRegis.getTbl_mascota().getModel();
        estructuraTabla.setNumRows(0);
        List<Mascota> listmas = Mmas.consultarMascotaCedu(cedula);
        i = 0;

        listmas.stream().forEach(mascota -> {
            estructuraTabla.addRow(new Object[2]);
            vRegis.getTbl_mascota()
                    .setValueAt(mascota.getMas_nombreMas(),
                            i, 0);
            vRegis.getTbl_mascota()
                    .setValueAt(mascota.getMas_especie(),
                            i, 1);

            i = i + 1;

        });
    }

    private void cancelar() {
        limpiarRegistro();
        limpiarRegistro();
        desactivarLblVRegis();
    }

    private void limpiarBusqueda() {
        vRegis.getTxt_buscar().setText("");
        vRegis.getBtn_Bmodificar().setEnabled(false);
        vRegis.getBtn_Bregistrar().setEnabled(false);
        //vRegis.getTblBusqueda().clearSelection();
    }

    private void limpiarModificacion() {
        vRegis.getTxt_Mcedula().setText("");
        vRegis.getTxt_Mnombre().setText("");
        vRegis.getTxt_MPApellido().setText("");
        vRegis.getTxt_MSApellido().setText("");
        vRegis.getTxt_Mtelefono().setText("");
        vRegis.getTat_Mdireccion().setText("");
        vRegis.getTxt_Mcedula().setEnabled(true);
        vRegis.getBtn_modificar().setEnabled(false);
        vRegis.getBtn_eliminar().setEnabled(false);
        vRegis.getScr_Mascota().setVisible(false);
    }

    private void limpiarRegistro() {
        cedulaB = "";
        banderaRegistro = true;
        vRegis.getLbl_foto().setIcon(null);
        vRegis.getTxt_cedulaR().setEnabled(true);
        vRegis.getTxt_nombreR().setEditable(true);
        vRegis.getTxt_pApellidoR().setEditable(true);
        vRegis.getTxt_sApellidoR().setEditable(true);
        vRegis.getTxt_telefonoR().setEditable(true);
        vRegis.getTat_direccionR().setEditable(true);
        vRegis.getTxt_cedulaR().setText("");
        vRegis.getTxt_nombreR().setText("");
        vRegis.getTxt_pApellidoR().setText("");
        vRegis.getTxt_sApellidoR().setText("");
        vRegis.getTxt_telefonoR().setText("");
        vRegis.getTat_direccionR().setText("");
        vRegis.getTxt_nombreMR().setText("");
        vRegis.getTxt_razaR().setText("");

    }

    private void llenarTabla() {

        i = 0;
        DefaultTableModel estructuraTabla;
        estructuraTabla = (DefaultTableModel) vRegis.getTblBusqueda().getModel();
        estructuraTabla.setNumRows(0);
        List<Cliente> listC = Ccli.recuperarClientes();
        listC.stream().forEach(cliente -> {
            estructuraTabla.addRow(new Object[3]);

            vRegis.getTblBusqueda()
                    .setValueAt(cliente.getCli_id(), i, 0);
            vRegis.getTblBusqueda()
                    .setValueAt(cliente.getPer_dni(), i, 1);
            vRegis.getTblBusqueda()
                    .setValueAt(cliente.getPer_nombre1(), i, 2);
            vRegis.getTblBusqueda()
                    .setValueAt(cliente.getPer_apellido1(), i, 3);
            vRegis.getTblBusqueda()
                    .setValueAt(cliente.getPer_apellido2(), i, 4);
            i = i + 1;
        });
    }

    public void desactivarLblVRegis() {
        vRegis.getLblAlertaCcv().setVisible(false);
        vRegis.getLblAlertaCf().setVisible(false);
        vRegis.getLblAlertaCnv().setVisible(false);
        vRegis.getLblAlertaNv().setVisible(false);
        vRegis.getLblAlertaPAv().setVisible(false);
        vRegis.getLblAlertaSAv().setVisible(false);
        vRegis.getLblAlertaNMv().setVisible(false);
        vRegis.getLblAlertaRv().setVisible(false);
        vRegis.getLblAlertaNf().setVisible(false);
        vRegis.getLblAlertaPAf().setVisible(false);
        vRegis.getLblAlertaSAf().setVisible(false);
        vRegis.getLblAlertaNMf().setVisible(false);
        vRegis.getLblAlertaRf().setVisible(false);
        vRegis.getLblAlertaTf().setVisible(false);
        vRegis.getLblAlertaTnv().setVisible(false);
        vRegis.getLblAlertaDf().setVisible(false);
        vRegis.getLblAlertaMcnv().setVisible(false);
        vRegis.getLblAlertaMcf().setVisible(false);
        vRegis.getLblAlertaMnv().setVisible(false);
        vRegis.getLblAlertaMsav().setVisible(false);
        vRegis.getLblAlertaMpav().setVisible(false);
        vRegis.getLblAlertaMtnv().setVisible(false);
        vRegis.getLblAlertaMtf().setVisible(false);
        vRegis.getLblAlertaMdf().setVisible(false);
        vRegis.getLblAlertaMcne().setVisible(false);
        vRegis.getLblAlertBne().setVisible(false);
    }
}
