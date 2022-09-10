package Control;

import Modelo.ClasesModelo.ModeloCliente;
import Modelo.ClasesModelo.ModeloPersona;
import Modelo.ClasesModelo.ModeloMascota;
import Modelo.Cliente;
import Vista.vistaRegistro;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
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
    private int i;
    private boolean banderaFoto ;

    public ControlRegistro(vistaRegistro vRegis, ModeloPersona Mper, ModeloMascota Mmas, ModeloCliente Ccli) {
        this.vRegis = vRegis;
        this.Mper = Mper;
        this.Mmas = Mmas;
        this.Ccli = Ccli;
        referenciarObjetos();
    }

    public void iniciarControl() {
        vRegis.getBtn_registrarR().addActionListener(l -> registrar());
        vRegis.getBtn_examinarR().addActionListener(l -> examinarFoto());
        vRegis.getBtn_Vbuscar().addActionListener(l -> cambiarPanel("BUSCAR"));
        vRegis.getBtn_Vregistrar().addActionListener(l -> cambiarPanel("registrar"));
    }

    private void cambiarPanel(String tipo) {

        if (tipo.equalsIgnoreCase("buscar")) {
            vRegis.getPnl_busqueda().setVisible(true);
            vRegis.getPnlRegistro().setVisible(false);
        } else {
            vRegis.getPnl_busqueda().setVisible(false);
            vRegis.getPnlRegistro().setVisible(true);
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

                banderaFoto=true;
            } catch (IOException ex) {
                Logger.getLogger(ControlRegistro.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

    }

    private void referenciarObjetos() {
        desactivarLblVRegis();
        llenarTabla();
        //salto de linea vistaRegistro tat
        vRegis.getTat_direccionR().setLineWrap(true);
        //Evitar corte de palabras por la mitad
        vRegis.getTat_direccionR().setWrapStyleWord(true);

        //linea de prueba hay que borrar mas despues
        vRegis.getPnl_busqueda().setVisible(false);
    }

    private void registrar() {
        //iMPLEMENTAR METODO LIMPIAR 
        desactivarLblVRegis();
        int bandera = 0, id = 0;
        String cedula = "", nombre = "", pApellido = "",
                sApellido = "", telefono = "", direccion = "",
                nombreM = "", raza = "", especie = "", sexo = "";

        cedula = vRegis.getTxt_cedulaR().getText();
        nombre = vRegis.getTxt_nombreR().getText();
        pApellido = vRegis.getTxt_pApellidoR().getText();
        sApellido = vRegis.getTxt_sApellidoR().getText();
        telefono = vRegis.getTxt_telefonoR().getText();
        direccion = vRegis.getTat_direccionR().getText();
        nombreM = vRegis.getTxt_nombreMR().getText();
        raza = vRegis.getTxt_razaR().getText();
        //Recuperar datos de un combobox
        especie = vRegis.getCmb_especieR().getSelectedItem().toString();
        sexo = vRegis.getCmb_sexoR().getSelectedItem().toString();

//        if (!cedula.equals("")) {
//            bandera = vali.valiCedula(cedula);
//
//            switch (bandera) {
//
//                case 1:
//                    vRegis.getLblAlertaCnv().setVisible(true);
//                    bandera = bandera + 1;
//                    break;
//                case 2:
//                    vRegis.getLblAlertaCf().setVisible(true);
//                    bandera = bandera + 1;
//                    break;
//            }
//
//        } else {
//
//            vRegis.getLblAlertaCcv().setVisible(true);
//            bandera = bandera + 1;
//        }

        if (!nombre.equals("")) {
            if (!vali.valiNombreApe(nombre)) {
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
            if (!vali.valiNombreApe(raza)) {
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
            //Recuperar foto
            if (banderaFoto) {

                try {

                    byte[] bitIcon = new byte[(int) jfc.getSelectedFile().getAbsoluteFile().length()];
                    InputStream input = new FileInputStream(jfc.getSelectedFile().getAbsoluteFile());
                    input.read(bitIcon);
                    Mmas.setFoto(bitIcon);

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
                ruta= ruta+"/src/Iconos/mascotasFoto.png";
                
                try {
                    File Icon = new File(ruta);
                  
                    byte[] bitIcon = new byte[(int) Icon.length()];
                    InputStream input = new FileInputStream(Icon);
                    input.read(bitIcon);
                    Mmas.setFoto(bitIcon);
                    if (Mmas.guardarMascota()) {
                        JOptionPane.showMessageDialog(vRegis, "registro exitoso");
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ControlRegistro.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ControlRegistro.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }

    }
    
    private void llenarTabla(){
        
        i=0;
        DefaultTableModel estructuraTabla;
        estructuraTabla = (DefaultTableModel) vRegis.getTblClientes().getModel();
        estructuraTabla.setNumRows(0);
        List<Cliente> listC= Ccli.recuperarCliente();
        listC.stream().forEach(cliente -> {
        estructuraTabla.addRow(new Object[3]);
        
        vRegis.getTblClientes()
                .setValueAt(cliente.getCli_id(), i, 0);
        vRegis.getTblClientes()
                .setValueAt(cliente.getPer_dni(),i,1);
        vRegis.getTblClientes()
                .setValueAt(cliente.getPer_nombre1(),i,2);
        vRegis.getTblClientes()
                .setValueAt(cliente.getPer_apellido1(),i,3);
                i=i+1;
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
    }
}
