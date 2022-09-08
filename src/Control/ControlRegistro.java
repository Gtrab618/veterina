package Control;

import Vista.vistaRegistro;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author Usuario
 */
public class ControlRegistro {

    private vistaRegistro vRegis;
    private Validaciones vali = new Validaciones();
    private JFileChooser jfc;

    public ControlRegistro(vistaRegistro vRegis) {
        this.vRegis = vRegis;
        referenciarObjetos();
    }

    public void iniciarControl() {
        vRegis.getBtn_registrarR().addActionListener(l -> registrar());
        vRegis.getBtn_examinarR().addActionListener(l -> examinarFoto());
    }
    
    
    private void examinarFoto(){
        
        jfc=new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado= jfc.showOpenDialog(vRegis);
        
        if (estado==JFileChooser.APPROVE_OPTION) {
            
            try {
                Image imagen = ImageIO.read(jfc.getSelectedFile()).getScaledInstance(vRegis.getLbl_foto().getWidth(), vRegis.getLbl_foto().getHeight(), Image.SCALE_DEFAULT);
                
                Icon icono = new ImageIcon(imagen);
                vRegis.getLbl_foto().setIcon(icono);
                vRegis.getLbl_foto().updateUI();
            
            
            } catch (IOException ex) {
                Logger.getLogger(ControlRegistro.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
    
    private void referenciarObjetos() {
        desactivarLblVRegis();

        //salto de linea vistaRegistro tat
        vRegis.getTat_direccionR().setLineWrap(true);
        //Evitar corte de palabras por la mitad
        vRegis.getTat_direccionR().setWrapStyleWord(true);
    }

    private void registrar() {
        //iMPLEMENTAR METODO LIMPIAR 
        desactivarLblVRegis();
        
        String cedula = "", nombre = "", pApellido = "",
                sApellido = "", telefono = "", direccion = "",
                nombreM = "", raza = "", especie = "", sexo = "";
        int bandera = 0;

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
        
        
        if (!cedula.equals("")) {
            bandera = vali.valiCedula(cedula);

            switch (bandera) {

                case 1:
                    vRegis.getLblAlertaCnv().setVisible(true);
                    break;
                case 2:
                    vRegis.getLblAlertaCf().setVisible(true);
                    break;
            }

        } else {

            vRegis.getLblAlertaCcv().setVisible(true);
        }

        if (!nombre.equals("")) {
            if (!vali.valiNombreApe(nombre)) {
                //nombre formato incorrecto
                vRegis.getLblAlertaNf().setVisible(true);      
            }
        } else {
            //campo vacio
            vRegis.getLblAlertaNv().setVisible(true);
        }
        
        
        if (!pApellido.equals("")) {
            if (!vali.valiNombreApe(pApellido)) {
                //papellido error de formato
                vRegis.getLblAlertaPAf().setVisible(true);
            }
        } else {
            //campo vacio
            vRegis.getLblAlertaPAv().setVisible(true);
        }
        
        if (!sApellido.equals("")) {
            if (!vali.valiNombreApe(sApellido)) {
                vRegis.getLblAlertaSAf().setVisible(true);
            }
        } else {
            vRegis.getLblAlertaSAv().setVisible(true);
        }

        if (!telefono.equals("")) {
            bandera = vali.valiNumTelefono(telefono);
            
            switch (bandera) {
                case 1:
                    //telefono error longitud
                    vRegis.getLblAlertaTnv().setVisible(true);
                    break;
                case 2:
                    //telefono error contiene letras
                    vRegis.getLblAlertaTf().setVisible(true);
                    break;

            }
        } 
        
        if (!direccion.equals("")) {
            if (!vali.valiDirec(direccion)) {
                //error direccion muy corta
                vRegis.getLblAlertaDf().setVisible(true);
            }
        } 
        if (!nombreM.equals("")) {
            if (!vali.valiNombreApe(nombreM)) {
                //nombre de la mascota contiene numeros
                vRegis.getLblAlertaNMf().setVisible(true);
            }
        } else {
            //nombre de la mascota vacio
            vRegis.getLblAlertaNMv().setVisible(true);
        }

        if (!raza.equals("")) {
            if (!vali.valiNombreApe(raza)) {
                vRegis.getLblAlertaRf().setVisible(true);
            }
        } else {
            vRegis.getLblAlertaRv().setVisible(true);
        }

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
