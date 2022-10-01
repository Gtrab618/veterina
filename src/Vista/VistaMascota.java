/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;



/**
 *
 * @author Usuario
 */
public class VistaMascota extends javax.swing.JPanel {


    public VistaMascota() {
        initComponents();
    }

    public JLabel getLblAlertaMrL() {
        return lblAlertaMrL;
    }

    public void setLblAlertaMrL(JLabel lblAlertaMrL) {
        this.lblAlertaMrL = lblAlertaMrL;
    }

    
    public JLabel getLblAlertaMnL() {
        return lblAlertaMnL;
    }

    public void setLblAlertaMnL(JLabel lblAlertaMnL) {
        this.lblAlertaMnL = lblAlertaMnL;
    }

    public JButton getBtn_Vbuscar() {
        return btn_Vbuscar;
    }

    public void setBtn_Vbuscar(JButton btn_Vbuscar) {
        this.btn_Vbuscar = btn_Vbuscar;
    }

    public JButton getBtn_Vmodificar() {
        return btn_Vmodificar;
    }

    public void setBtn_Vmodificar(JButton btn_Vmodificar) {
        this.btn_Vmodificar = btn_Vmodificar;
    }

    public JTable getTblBmascota() {
        return tblBmascota;
    }

    public void setTblBmascota(JTable tblBmascota) {
        this.tblBmascota = tblBmascota;
    }

    public JTable getTblBpersona() {
        return tblBpersona;
    }

    public void setTblBpersona(JTable tblBpersona) {
        this.tblBpersona = tblBpersona;
    }

    public JTextField getTxtBpersona() {
        return txtBpersona;
    }

    public void setTxtBpersona(JTextField txtBpersona) {
        this.txtBpersona = txtBpersona;
    }

    public JPanel getPnlBmascota() {
        return pnlBmascota;
    }

    public void setPnlBmascota(JPanel pnlBmascota) {
        this.pnlBmascota = pnlBmascota;
    }

    public JPanel getPnlGestionarM() {
        return pnlGestionarM;
    }

    public void setPnlGestionarM(JPanel pnlGestionarM) {
        this.pnlGestionarM = pnlGestionarM;
    }

    public JScrollPane getScrBmascota() {
        return scrBmascota;
    }

    public void setScrBmascota(JScrollPane scrBmascota) {
        this.scrBmascota = scrBmascota;
    }

    public JLabel getLblBselecMas() {
        return lblBselecMas;
    }

    public void setLblBselecMas(JLabel lblBselecMas) {
        this.lblBselecMas = lblBselecMas;
    }

    public JLabel getLblAlertBne() {
        return lblAlertBne;
    }

    public void setLblAlertBne(JLabel lblAlertBne) {
        this.lblAlertBne = lblAlertBne;
    }

    public JLabel getLblBFoto() {
        return lblBFoto;
    }

    public void setLblBFoto(JLabel lblBFoto) {
        this.lblBFoto = lblBFoto;
    }

    public JButton getBtnBgestionMascota() {
        return btnBgestionMascota;
    }

    public void setBtnBgestionMascota(JButton btnBgestionMascota) {
        this.btnBgestionMascota = btnBgestionMascota;
    }

    public JButton getBtn_eliminarM() {
        return btn_eliminarM;
    }

    public void setBtn_eliminarM(JButton btn_eliminarM) {
        this.btn_eliminarM = btn_eliminarM;
    }

    public JButton getBtn_examinarM() {
        return btn_examinarM;
    }

    public void setBtn_examinarM(JButton btn_examinarM) {
        this.btn_examinarM = btn_examinarM;
    }

    public JButton getBtn_modificarM() {
        return btn_modificarM;
    }

    public void setBtn_modificarM(JButton btn_modificarM) {
        this.btn_modificarM = btn_modificarM;
    }

    public JComboBox<String> getCmb_especieM() {
        return cmb_especieM;
    }

    public void setCmb_especieM(JComboBox<String> cmb_especieM) {
        this.cmb_especieM = cmb_especieM;
    }

    public JComboBox<String> getCmb_sexoM() {
        return cmb_sexoM;
    }

    public void setCmb_sexoM(JComboBox<String> cmb_sexoM) {
        this.cmb_sexoM = cmb_sexoM;
    }

    public JDateChooser getJdcFechaNacM() {
        return jdcFechaNacM;
    }

    public void setJdcFechaNacM(JDateChooser jdcFechaNacM) {
        this.jdcFechaNacM = jdcFechaNacM;
    }

    public JLabel getLblCedulaM() {
        return lblCedulaM;
    }

    public void setLblCedulaM(JLabel lblCedulaM) {
        this.lblCedulaM = lblCedulaM;
    }

    public JLabel getLblEdadMas() {
        return lblEdadMas;
    }

    public void setLblEdadMas(JLabel lblEdadMas) {
        this.lblEdadMas = lblEdadMas;
    }

    public JLabel getLblFotoM() {
        return lblFotoM;
    }

    public void setLblFotoM(JLabel lblFotoM) {
        this.lblFotoM = lblFotoM;
    }

    public JLabel getLblIdMas() {
        return lblIdMas;
    }

    public void setLblIdMas(JLabel lblIdMas) {
        this.lblIdMas = lblIdMas;
    }

    public JLabel getLblNombrePM() {
        return lblNombrePM;
    }

    public void setLblNombrePM(JLabel lblNombrePM) {
        this.lblNombrePM = lblNombrePM;
    }

    public JTextField getTxtNombreM() {
        return txtNombreM;
    }

    public void setTxtNombreM(JTextField txtNombreM) {
        this.txtNombreM = txtNombreM;
    }

    public JTextField getTxtRazaM() {
        return txtRazaM;
    }

    public void setTxtRazaM(JTextField txtRazaM) {
        this.txtRazaM = txtRazaM;
    }

    public JLabel getLblAlertaMnf() {
        return lblAlertaMnf;
    }

    public void setLblAlertaMnf(JLabel lblAlertaMnf) {
        this.lblAlertaMnf = lblAlertaMnf;
    }

    public JLabel getLblAlertaMnv() {
        return lblAlertaMnv;
    }

    public void setLblAlertaMnv(JLabel lblAlertaMnv) {
        this.lblAlertaMnv = lblAlertaMnv;
    }

    public JLabel getLblAlertaMrf() {
        return lblAlertaMrf;
    }

    public void setLblAlertaMrf(JLabel lblAlertaMrf) {
        this.lblAlertaMrf = lblAlertaMrf;
    }

    public JLabel getLblAlertaMrv() {
        return lblAlertaMrv;
    }

    public void setLblAlertaMrv(JLabel lblAlertaMrv) {
        this.lblAlertaMrv = lblAlertaMrv;
    }

    public JLabel getLblBAlertMne() {
        return lblBAlertMne;
    }

    public void setLblBAlertMne(JLabel lblBAlertMne) {
        this.lblBAlertMne = lblBAlertMne;
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btn_Vbuscar = new javax.swing.JButton();
        btn_Vmodificar = new javax.swing.JButton();
        pnlBmascota = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        txtBpersona = new javax.swing.JTextField();
        lbltext = new javax.swing.JLabel();
        lbltext2 = new javax.swing.JLabel();
        srlBpersona = new javax.swing.JScrollPane();
        tblBpersona = new javax.swing.JTable();
        lblBFoto = new javax.swing.JLabel();
        lblBselecMas = new javax.swing.JLabel();
        scrBmascota = new javax.swing.JScrollPane();
        tblBmascota = new javax.swing.JTable();
        btnBgestionMascota = new javax.swing.JButton();
        lblAlertBne = new javax.swing.JLabel();
        lblBAlertMne = new javax.swing.JLabel();
        pnlGestionarM = new javax.swing.JPanel();
        lblsexo = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        lblCedulaM = new javax.swing.JLabel();
        lblcedula = new javax.swing.JLabel();
        lblNombrePM = new javax.swing.JLabel();
        lblpropietario = new javax.swing.JLabel();
        lblmascota = new javax.swing.JLabel();
        lblfechanac = new javax.swing.JLabel();
        cmb_especieM = new javax.swing.JComboBox<>();
        cmb_sexoM = new javax.swing.JComboBox<>();
        lblraza = new javax.swing.JLabel();
        lblnombre_m = new javax.swing.JLabel();
        txtNombreM = new javax.swing.JTextField();
        lblFotoM = new javax.swing.JLabel();
        txtRazaM = new javax.swing.JTextField();
        lblespecie = new javax.swing.JLabel();
        jdcFechaNacM = new com.toedter.calendar.JDateChooser();
        btn_examinarM = new javax.swing.JButton();
        btn_modificarM = new javax.swing.JButton();
        btn_eliminarM = new javax.swing.JButton();
        lblEdad = new javax.swing.JLabel();
        lblicoP = new javax.swing.JLabel();
        lblicoM = new javax.swing.JLabel();
        lbltitutlo = new javax.swing.JLabel();
        lblEdadMas = new javax.swing.JLabel();
        lblIdMas = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        lblAlertaMrv = new javax.swing.JLabel();
        lblAlertaMnv = new javax.swing.JLabel();
        lblAlertaMrf = new javax.swing.JLabel();
        lblAlertaMnf = new javax.swing.JLabel();
        lblAlertaMrL = new javax.swing.JLabel();
        lblAlertaMnL = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToolBar1.setBackground(new java.awt.Color(204, 204, 204));
        jToolBar1.setRollover(true);

        btn_Vbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar_32px.png"))); // NOI18N
        btn_Vbuscar.setToolTipText("");
        btn_Vbuscar.setFocusable(false);
        btn_Vbuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Vbuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btn_Vbuscar);

        btn_Vmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/eliminar_32px.png"))); // NOI18N
        btn_Vmodificar.setFocusable(false);
        btn_Vmodificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Vmodificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btn_Vmodificar);

        add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 42));

        pnlBmascota.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        lblTitle.setText("Gestión Mascota");
        pnlBmascota.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));
        pnlBmascota.add(txtBpersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 244, -1));

        lbltext.setText("Ingrese");
        pnlBmascota.add(lbltext, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        lbltext2.setText("Cédula, nombre, apellido");
        pnlBmascota.add(lbltext2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, 20));

        tblBpersona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cédula", "Nombre", "Primer apellido", "Segundo apellido"
            }
        ));
        srlBpersona.setViewportView(tblBpersona);

        pnlBmascota.add(srlBpersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 670, 220));
        pnlBmascota.add(lblBFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 130, 210, 220));

        lblBselecMas.setText("Seleccione la mascota");
        pnlBmascota.add(lblBselecMas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        tblBmascota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id Mascota", "Nombre", "Especie", "Raza"
            }
        ));
        scrBmascota.setViewportView(tblBmascota);

        pnlBmascota.add(scrBmascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 510, 210));

        btnBgestionMascota.setText("Gestionar Mascota");
        pnlBmascota.add(btnBgestionMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 570, -1, -1));

        lblAlertBne.setForeground(new java.awt.Color(255, 0, 0));
        lblAlertBne.setText("No hay coincidencias");
        pnlBmascota.add(lblAlertBne, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        lblBAlertMne.setForeground(new java.awt.Color(255, 51, 0));
        lblBAlertMne.setText("Mascotas no encontradas");
        pnlBmascota.add(lblBAlertMne, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        add(pnlBmascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 48, 960, 680));

        pnlGestionarM.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblsexo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblsexo.setText("Sexo");
        pnlGestionarM.add(lblsexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 450, -1, -1));

        lblnombre.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblnombre.setText("Nombre");
        pnlGestionarM.add(lblnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, -1, -1));
        pnlGestionarM.add(lblCedulaM, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 150, 30));

        lblcedula.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblcedula.setText("Cédula");
        pnlGestionarM.add(lblcedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));
        pnlGestionarM.add(lblNombrePM, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 270, 30));

        lblpropietario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblpropietario.setText("Propietario");
        pnlGestionarM.add(lblpropietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        lblmascota.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblmascota.setText("Mascota");
        pnlGestionarM.add(lblmascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        lblfechanac.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblfechanac.setText("Fecha de Nacimiento");
        pnlGestionarM.add(lblfechanac, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, -1, -1));

        cmb_especieM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Felino", "Canino" }));
        pnlGestionarM.add(cmb_especieM, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, -1, -1));

        cmb_sexoM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Macho", "Hembra" }));
        pnlGestionarM.add(cmb_sexoM, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 470, -1, -1));

        lblraza.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblraza.setText("Raza");
        pnlGestionarM.add(lblraza, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, -1, -1));

        lblnombre_m.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblnombre_m.setText("Nombre");
        pnlGestionarM.add(lblnombre_m, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));
        pnlGestionarM.add(txtNombreM, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 180, -1));

        lblFotoM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFotoM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/login/vtMain2.png"))); // NOI18N
        lblFotoM.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlGestionarM.add(lblFotoM, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 190, 180));
        pnlGestionarM.add(txtRazaM, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 180, -1));

        lblespecie.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblespecie.setText("Especie");
        pnlGestionarM.add(lblespecie, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, -1, -1));
        pnlGestionarM.add(jdcFechaNacM, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, 180, -1));

        btn_examinarM.setText("Examinar");
        pnlGestionarM.add(btn_examinarM, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 250, -1, -1));

        btn_modificarM.setText("Modificar");
        pnlGestionarM.add(btn_modificarM, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 430, 130, -1));

        btn_eliminarM.setText("Eliminar");
        pnlGestionarM.add(btn_eliminarM, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 480, 130, -1));

        lblEdad.setText("Edad Actual");
        pnlGestionarM.add(lblEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, -1, -1));

        lblicoP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/RePer.png"))); // NOI18N
        pnlGestionarM.add(lblicoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 40, 40));

        lblicoM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ReMas.png"))); // NOI18N
        pnlGestionarM.add(lblicoM, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 50, 50));

        lbltitutlo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbltitutlo.setText("Modificar Mascota");
        pnlGestionarM.add(lbltitutlo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, -1));
        pnlGestionarM.add(lblEdadMas, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 400, 240, 30));
        pnlGestionarM.add(lblIdMas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, 60, 30));
        pnlGestionarM.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 270, 20));
        pnlGestionarM.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 170, 20));

        lblAlertaMrv.setForeground(new java.awt.Color(204, 0, 204));
        lblAlertaMrv.setText("Campo vacío");
        pnlGestionarM.add(lblAlertaMrv, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, -1, -1));

        lblAlertaMnv.setForeground(new java.awt.Color(204, 0, 204));
        lblAlertaMnv.setText("Campo vacío");
        pnlGestionarM.add(lblAlertaMnv, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        lblAlertaMrf.setForeground(new java.awt.Color(212, 172, 13));
        lblAlertaMrf.setText("Ingrese solo texto");
        pnlGestionarM.add(lblAlertaMrf, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, -1, -1));

        lblAlertaMnf.setForeground(new java.awt.Color(212, 172, 13));
        lblAlertaMnf.setText("Ingrese solo texto");
        pnlGestionarM.add(lblAlertaMnf, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        lblAlertaMrL.setForeground(new java.awt.Color(255, 102, 0));
        lblAlertaMrL.setText("Revise longitud");
        pnlGestionarM.add(lblAlertaMrL, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, -1, -1));

        lblAlertaMnL.setForeground(new java.awt.Color(255, 102, 0));
        lblAlertaMnL.setText("Revise longitud");
        pnlGestionarM.add(lblAlertaMnL, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        add(pnlGestionarM, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 960, 680));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBgestionMascota;
    private javax.swing.JButton btn_Vbuscar;
    private javax.swing.JButton btn_Vmodificar;
    private javax.swing.JButton btn_eliminarM;
    private javax.swing.JButton btn_examinarM;
    private javax.swing.JButton btn_modificarM;
    private javax.swing.JComboBox<String> cmb_especieM;
    private javax.swing.JComboBox<String> cmb_sexoM;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private com.toedter.calendar.JDateChooser jdcFechaNacM;
    private javax.swing.JLabel lblAlertBne;
    private javax.swing.JLabel lblAlertaMnL;
    private javax.swing.JLabel lblAlertaMnf;
    private javax.swing.JLabel lblAlertaMnv;
    private javax.swing.JLabel lblAlertaMrL;
    private javax.swing.JLabel lblAlertaMrf;
    private javax.swing.JLabel lblAlertaMrv;
    private javax.swing.JLabel lblBAlertMne;
    private javax.swing.JLabel lblBFoto;
    private javax.swing.JLabel lblBselecMas;
    private javax.swing.JLabel lblCedulaM;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblEdadMas;
    private javax.swing.JLabel lblFotoM;
    private javax.swing.JLabel lblIdMas;
    private javax.swing.JLabel lblNombrePM;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblcedula;
    private javax.swing.JLabel lblespecie;
    private javax.swing.JLabel lblfechanac;
    private javax.swing.JLabel lblicoM;
    private javax.swing.JLabel lblicoP;
    private javax.swing.JLabel lblmascota;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JLabel lblnombre_m;
    private javax.swing.JLabel lblpropietario;
    private javax.swing.JLabel lblraza;
    private javax.swing.JLabel lblsexo;
    private javax.swing.JLabel lbltext;
    private javax.swing.JLabel lbltext2;
    private javax.swing.JLabel lbltitutlo;
    private javax.swing.JPanel pnlBmascota;
    private javax.swing.JPanel pnlGestionarM;
    private javax.swing.JScrollPane scrBmascota;
    private javax.swing.JScrollPane srlBpersona;
    private javax.swing.JTable tblBmascota;
    private javax.swing.JTable tblBpersona;
    private javax.swing.JTextField txtBpersona;
    private javax.swing.JTextField txtNombreM;
    private javax.swing.JTextField txtRazaM;
    // End of variables declaration//GEN-END:variables
}
