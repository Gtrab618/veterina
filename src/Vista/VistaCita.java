/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;




/**
 *
 * @author Usuario
 */
public class VistaCita extends javax.swing.JPanel {


    public VistaCita() {
        initComponents();
    }

    public JPanel getPnlBmascota() {
        return pnlBmascota;
    }

    public void setPnlBmascota(JPanel pnlBmascota) {
        this.pnlBmascota = pnlBmascota;
    }

    public JPanel getPnlCmascota() {
        return pnlCmascota;
    }

    public void setPnlCmascota(JPanel pnlCmascota) {
        this.pnlCmascota = pnlCmascota;
    }

    public JScrollPane getScrBmascota() {
        return scrBmascota;
    }

    public void setScrBmascota(JScrollPane scrBmascota) {
        this.scrBmascota = scrBmascota;
    }

    public JButton getBtn_Vbuscar() {
        return btn_Vbuscar;
    }

    public void setBtn_Vbuscar(JButton btn_Vbuscar) {
        this.btn_Vbuscar = btn_Vbuscar;
    }

    public JButton getBtn_Vregistrar() {
        return btn_Vregistrar;
    }

    public void setBtn_Vregistrar(JButton btn_Vregistrar) {
        this.btn_Vregistrar = btn_Vregistrar;
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

    public JButton getBtnCrearCita() {
        return btnCrearCita;
    }

    public void setBtnCrearCita(JButton btnCrearCita) {
        this.btnCrearCita = btnCrearCita;
    }

    public VistaCita(JButton btnCimprimirHis) {
        this.btnCimprimirHis = btnCimprimirHis;
    }

    public JButton getBtnCimprimirHis() {
        return btnCimprimirHis;
    }

    public void setBtnCimprimirHis(JButton btnCimprimirHis) {
        this.btnCimprimirHis = btnCimprimirHis;
    }

    public JButton getBtnCgenerarConsu() {
        return btnCgenerarConsu;
    }

    public void setBtnCgenerarConsu(JButton btnCgenerarConsu) {
        this.btnCgenerarConsu = btnCgenerarConsu;
    }

    public JSpinner getJspCpeso() {
        return jspCpeso;
    }

    public void setJspCpeso(JSpinner jspCpeso) {
        this.jspCpeso = jspCpeso;
    }



    public JLabel getLblCcedula() {
        return lblCcedula;
    }

    public void setLblCcedula(JLabel lblCcedula) {
        this.lblCcedula = lblCcedula;
    }

    public JLabel getLblCespecie() {
        return lblCespecie;
    }

    public void setLblCespecie(JLabel lblCespecie) {
        this.lblCespecie = lblCespecie;
    }

    public JLabel getLblCfecha() {
        return lblCfecha;
    }

    public void setLblCfecha(JLabel lblCfecha) {
        this.lblCfecha = lblCfecha;
    }

    public JLabel getLblCnombreM() {
        return lblCnombreM;
    }

    public void setLblCnombreM(JLabel lblCnombreM) {
        this.lblCnombreM = lblCnombreM;
    }

    public JLabel getLblCnombreP() {
        return lblCnombreP;
    }

    public void setLblCnombreP(JLabel lblCnombreP) {
        this.lblCnombreP = lblCnombreP;
    }

    public JLabel getLblCraza() {
        return lblCraza;
    }

    public void setLblCraza(JLabel lblCraza) {
        this.lblCraza = lblCraza;
    }

    public JLabel getLblCsexo() {
        return lblCsexo;
    }

    public void setLblCsexo(JLabel lblCsexo) {
        this.lblCsexo = lblCsexo;
    }

    public JLabel getLblCedad() {
        return lblCedad;
    }

    public void setLblCedad(JLabel lblCedad) {
        this.lblCedad = lblCedad;
    }

    public JTextArea getTatCmotivos() {
        return tatCmotivos;
    }

    public void setTatCmotivos(JTextArea tatCmotivos) {
        this.tatCmotivos = tatCmotivos;
    }

    public JTextArea getTatCobservaciones() {
        return tatCobservaciones;
    }

    public void setTatCobservaciones(JTextArea tatCobservaciones) {
        this.tatCobservaciones = tatCobservaciones;
    }

    public JTextArea getTatCtratamiento() {
        return tatCtratamiento;
    }

    public void setTatCtratamiento(JTextArea tatCtratamiento) {
        this.tatCtratamiento = tatCtratamiento;
    }

    public JComboBox<String> getCmbCmucos() {
        return cmbCmucos;
    }

    public void setCmbCmucos(JComboBox<String> cmbCmucos) {
        this.cmbCmucos = cmbCmucos;
    }

    public JSpinner getJspCFc() {
        return jspCFc;
    }

    public void setJspCFc(JSpinner jspCFc) {
        this.jspCFc = jspCFc;
    }

    public JSpinner getJspCFr() {
        return jspCFr;
    }

    public void setJspCFr(JSpinner jspCFr) {
        this.jspCFr = jspCFr;
    }

    public JSpinner getJspChidra() {
        return jspChidra;
    }

    public void setJspChidra(JSpinner jspChidra) {
        this.jspChidra = jspChidra;
    }

    public JSpinner getJspCtem() {
        return jspCtem;
    }

    public void setJspCtem(JSpinner jspCtem) {
        this.jspCtem = jspCtem;
    }

    public JTextField getTxtCllenado() {
        return txtCllenado;
    }

    public void setTxtCllenado(JTextField txtCllenado) {
        this.txtCllenado = txtCllenado;
    }

    public JLabel getLblAlertaCmv() {
        return lblAlertaCmv;
    }

    public void setLblAlertaCmv(JLabel lblAlertaCmv) {
        this.lblAlertaCmv = lblAlertaCmv;
    }

    public JLabel getLblAlertaCov() {
        return lblAlertaCov;
    }

    public void setLblAlertaCov(JLabel lblAlertaCov) {
        this.lblAlertaCov = lblAlertaCov;
    }

    public JLabel getLblAlertaCtv() {
        return lblAlertaCtv;
    }

    public void setLblAlertaCtv(JLabel lblAlertaCtv) {
        this.lblAlertaCtv = lblAlertaCtv;
    }

    public JLabel getLblAlertBne() {
        return lblAlertBne;
    }

    public void setLblAlertBne(JLabel lblAlertBne) {
        this.lblAlertBne = lblAlertBne;
    }

    public JLabel getLblBAlertMne() {
        return lblBAlertMne;
    }

    public void setLblBAlertMne(JLabel lblBAlertMne) {
        this.lblBAlertMne = lblBAlertMne;
    }

    public JLabel getLblBselecmas() {
        return lblBselecmas;
    }

    public void setLblBselecmas(JLabel lblBselecmas) {
        this.lblBselecmas = lblBselecmas;
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
        btn_Vregistrar = new javax.swing.JButton();
        pnlCmascota = new javax.swing.JPanel();
        lbltitle2 = new javax.swing.JLabel();
        lblcedula = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lbldatoscli = new javax.swing.JLabel();
        lbldatosmas = new javax.swing.JLabel();
        lblsexo = new javax.swing.JLabel();
        lblraza = new javax.swing.JLabel();
        lblespecie = new javax.swing.JLabel();
        lblfc = new javax.swing.JLabel();
        lblobserva = new javax.swing.JLabel();
        lblpeso = new javax.swing.JLabel();
        lbltratamiento = new javax.swing.JLabel();
        btnCgenerarConsu = new javax.swing.JButton();
        lblfecha = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tatCmotivos = new javax.swing.JTextArea();
        jspCFc = new javax.swing.JSpinner();
        jSeparator5 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tatCobservaciones = new javax.swing.JTextArea();
        lblsintoma1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblfr = new javax.swing.JLabel();
        jspCFr = new javax.swing.JSpinner();
        lblrm = new javax.swing.JLabel();
        lblcapilar = new javax.swing.JLabel();
        txtCllenado = new javax.swing.JTextField();
        lbltemperatura = new javax.swing.JLabel();
        jspCtem = new javax.swing.JSpinner();
        lblgrados = new javax.swing.JLabel();
        jspCpeso = new javax.swing.JSpinner();
        lblkg = new javax.swing.JLabel();
        lblconstantesF = new javax.swing.JLabel();
        jspChidra = new javax.swing.JSpinner();
        lblhidrata = new javax.swing.JLabel();
        lblprocentaje = new javax.swing.JLabel();
        lblmucosa = new javax.swing.JLabel();
        cmbCmucos = new javax.swing.JComboBox<>();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        lblCcedula = new javax.swing.JLabel();
        lblCnombreP = new javax.swing.JLabel();
        lblCnombreM = new javax.swing.JLabel();
        lblCraza = new javax.swing.JLabel();
        lblCsexo = new javax.swing.JLabel();
        lblCespecie = new javax.swing.JLabel();
        lblCfecha = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        lblnombrem1 = new javax.swing.JLabel();
        lblnombrem2 = new javax.swing.JLabel();
        lblCedad = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tatCtratamiento = new javax.swing.JTextArea();
        lblAlertaCtv = new javax.swing.JLabel();
        lblAlertaCmv = new javax.swing.JLabel();
        lblAlertaCov = new javax.swing.JLabel();
        pnlBmascota = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        txtBpersona = new javax.swing.JTextField();
        lbltext = new javax.swing.JLabel();
        lbltext2 = new javax.swing.JLabel();
        srlBpersona = new javax.swing.JScrollPane();
        tblBpersona = new javax.swing.JTable();
        lblBselecmas = new javax.swing.JLabel();
        scrBmascota = new javax.swing.JScrollPane();
        tblBmascota = new javax.swing.JTable();
        btnCrearCita = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnCimprimirHis = new javax.swing.JButton();
        lblBAlertMne = new javax.swing.JLabel();
        lblAlertBne = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToolBar1.setBackground(new java.awt.Color(204, 204, 204));
        jToolBar1.setRollover(true);

        btn_Vbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar_32px.png"))); // NOI18N
        btn_Vbuscar.setToolTipText("");
        btn_Vbuscar.setFocusable(false);
        btn_Vbuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Vbuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btn_Vbuscar);

        btn_Vregistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/agregar_32px.png"))); // NOI18N
        btn_Vregistrar.setFocusable(false);
        btn_Vregistrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Vregistrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btn_Vregistrar);

        add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1260, 42));

        pnlCmascota.setPreferredSize(new java.awt.Dimension(870, 500));
        pnlCmascota.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbltitle2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbltitle2.setText("CONSULTA MÉDICA");
        pnlCmascota.add(lbltitle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, -1, -1));

        lblcedula.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblcedula.setText("Cédula");
        pnlCmascota.add(lblcedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        lblnombre.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblnombre.setText("Nombre");
        pnlCmascota.add(lblnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, -1, -1));
        pnlCmascota.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 960, 10));

        lbldatoscli.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbldatoscli.setText("Datos de Cliente");
        pnlCmascota.add(lbldatoscli, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        lbldatosmas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbldatosmas.setText("Datos de la Mascota");
        pnlCmascota.add(lbldatosmas, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, -1, -1));

        lblsexo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblsexo.setText("Sexo");
        pnlCmascota.add(lblsexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 70, -1, -1));

        lblraza.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblraza.setText("Raza");
        pnlCmascota.add(lblraza, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, -1, -1));

        lblespecie.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblespecie.setText("Especie");
        pnlCmascota.add(lblespecie, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 70, -1, -1));

        lblfc.setText("Fc");
        pnlCmascota.add(lblfc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, 20));

        lblobserva.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblobserva.setText("Observaciones");
        pnlCmascota.add(lblobserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 440, -1, -1));

        lblpeso.setText("Peso");
        pnlCmascota.add(lblpeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, -1, -1));

        lbltratamiento.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbltratamiento.setText("Tratamiento");
        pnlCmascota.add(lbltratamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 190, -1, -1));

        btnCgenerarConsu.setText("Generar Consulta");
        pnlCmascota.add(btnCgenerarConsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 620, -1, -1));

        lblfecha.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblfecha.setText("Fecha:");
        pnlCmascota.add(lblfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 40, -1, -1));

        tatCmotivos.setColumns(20);
        tatCmotivos.setRows(5);
        jScrollPane2.setViewportView(tatCmotivos);

        pnlCmascota.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 350, 230));

        jspCFc.setModel(new javax.swing.SpinnerNumberModel(50, 50, 200, 1));
        pnlCmascota.add(jspCFc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 120, -1));
        pnlCmascota.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 960, 20));

        tatCobservaciones.setColumns(20);
        tatCobservaciones.setRows(5);
        jScrollPane1.setViewportView(tatCobservaciones);

        pnlCmascota.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 460, 350, 220));

        lblsintoma1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblsintoma1.setText("Motivos de consulta");
        pnlCmascota.add(lblsintoma1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, -1, -1));

        jLabel3.setText("L/m");
        pnlCmascota.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, -1, -1));

        lblfr.setText("Fr");
        pnlCmascota.add(lblfr, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, 20));

        jspCFr.setModel(new javax.swing.SpinnerNumberModel(5, 5, 50, 1));
        pnlCmascota.add(jspCFr, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 120, -1));

        lblrm.setText("R/m");
        pnlCmascota.add(lblrm, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, -1, -1));

        lblcapilar.setText("T.Llenado capilar");
        pnlCmascota.add(lblcapilar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, -1, -1));
        pnlCmascota.add(txtCllenado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, 120, -1));

        lbltemperatura.setText("Temperatura rectal");
        pnlCmascota.add(lbltemperatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, -1, -1));

        jspCtem.setModel(new javax.swing.SpinnerNumberModel(37.5d, 1.0d, 45.0d, 1.0d));
        pnlCmascota.add(jspCtem, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 120, -1));

        lblgrados.setText("°");
        pnlCmascota.add(lblgrados, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 440, -1, -1));

        jspCpeso.setModel(new javax.swing.SpinnerNumberModel(0.5d, 0.5d, 120.0d, 1.0d));
        pnlCmascota.add(jspCpeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 120, -1));

        lblkg.setText("kg");
        pnlCmascota.add(lblkg, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 510, -1, -1));

        lblconstantesF.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblconstantesF.setText("Constates fisiológicas");
        pnlCmascota.add(lblconstantesF, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jspChidra.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));
        pnlCmascota.add(jspChidra, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 120, -1));

        lblhidrata.setText("Hidratación");
        pnlCmascota.add(lblhidrata, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        lblprocentaje.setText("%");
        pnlCmascota.add(lblprocentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, -1, -1));

        lblmucosa.setText("Muscosa");
        pnlCmascota.add(lblmucosa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 610, -1, -1));

        cmbCmucos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rosado", "Rojo", "Azul", "Palido", "Punteadas", "Negro" }));
        pnlCmascota.add(cmbCmucos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 640, 120, -1));
        pnlCmascota.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 170, -1, -1));
        pnlCmascota.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 110, 110, 10));
        pnlCmascota.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 110, 10));
        pnlCmascota.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 200, 10));

        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);
        pnlCmascota.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 10, 100));
        pnlCmascota.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, 120, 10));
        pnlCmascota.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 110, 110, 10));
        pnlCmascota.add(lblCcedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 110, 20));
        pnlCmascota.add(lblCnombreP, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 200, 20));
        pnlCmascota.add(lblCnombreM, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 120, 20));
        pnlCmascota.add(lblCraza, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, 120, 20));
        pnlCmascota.add(lblCsexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 90, 110, 20));
        pnlCmascota.add(lblCespecie, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 90, 110, 20));
        pnlCmascota.add(lblCfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 40, 210, 20));
        pnlCmascota.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, 120, 10));
        pnlCmascota.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 960, 10));

        lblnombrem1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblnombrem1.setText("Mascota");
        pnlCmascota.add(lblnombrem1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, -1, -1));

        lblnombrem2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblnombrem2.setText("Edad");
        pnlCmascota.add(lblnombrem2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, -1, -1));
        pnlCmascota.add(lblCedad, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, 220, 20));

        tatCtratamiento.setColumns(20);
        tatCtratamiento.setRows(5);
        jScrollPane4.setViewportView(tatCtratamiento);

        pnlCmascota.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, 360, 400));

        lblAlertaCtv.setForeground(new java.awt.Color(204, 0, 204));
        lblAlertaCtv.setText("Campo vacío");
        pnlCmascota.add(lblAlertaCtv, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 190, -1, -1));

        lblAlertaCmv.setForeground(new java.awt.Color(204, 0, 204));
        lblAlertaCmv.setText("Campo vacío");
        pnlCmascota.add(lblAlertaCmv, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, -1, -1));

        lblAlertaCov.setForeground(new java.awt.Color(204, 0, 204));
        lblAlertaCov.setText("Campo vacío");
        pnlCmascota.add(lblAlertaCov, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 440, -1, -1));

        add(pnlCmascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 960, 690));

        pnlBmascota.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitle.setText("Historial clínico");
        pnlBmascota.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));
        pnlBmascota.add(txtBpersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 244, -1));

        lbltext.setText("Ingrese");
        pnlBmascota.add(lbltext, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        lbltext2.setText("Cédula, nombre, apellido");
        pnlBmascota.add(lbltext2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, 20));

        tblBpersona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cédula", "Nombre", "Papellido", "Sapellido"
            }
        ));
        srlBpersona.setViewportView(tblBpersona);

        pnlBmascota.add(srlBpersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 740, 170));

        lblBselecmas.setText("Seleccione la mascota");
        pnlBmascota.add(lblBselecmas, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, -1, -1));

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

        pnlBmascota.add(scrBmascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, 740, 210));

        btnCrearCita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/agregar_32px.png"))); // NOI18N
        btnCrearCita.setText("Crear reporte");
        pnlBmascota.add(btnCrearCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 220, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar_32px.png"))); // NOI18N
        pnlBmascota.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));
        pnlBmascota.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 810, 20));

        btnCimprimirHis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/imprimir_32px.png"))); // NOI18N
        btnCimprimirHis.setText("Imprimir historial");
        pnlBmascota.add(btnCimprimirHis, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, -1, -1));

        lblBAlertMne.setForeground(new java.awt.Color(255, 51, 0));
        lblBAlertMne.setText("Mascotas no encontradas");
        pnlBmascota.add(lblBAlertMne, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, -1, -1));

        lblAlertBne.setForeground(new java.awt.Color(255, 0, 0));
        lblAlertBne.setText("No hay coincidencias");
        pnlBmascota.add(lblAlertBne, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));

        add(pnlBmascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 38, 960, 690));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCgenerarConsu;
    private javax.swing.JButton btnCimprimirHis;
    private javax.swing.JButton btnCrearCita;
    private javax.swing.JButton btn_Vbuscar;
    private javax.swing.JButton btn_Vregistrar;
    private javax.swing.JComboBox<String> cmbCmucos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JSpinner jspCFc;
    private javax.swing.JSpinner jspCFr;
    private javax.swing.JSpinner jspChidra;
    private javax.swing.JSpinner jspCpeso;
    private javax.swing.JSpinner jspCtem;
    private javax.swing.JLabel lblAlertBne;
    private javax.swing.JLabel lblAlertaCmv;
    private javax.swing.JLabel lblAlertaCov;
    private javax.swing.JLabel lblAlertaCtv;
    private javax.swing.JLabel lblBAlertMne;
    private javax.swing.JLabel lblBselecmas;
    private javax.swing.JLabel lblCcedula;
    private javax.swing.JLabel lblCedad;
    private javax.swing.JLabel lblCespecie;
    private javax.swing.JLabel lblCfecha;
    private javax.swing.JLabel lblCnombreM;
    private javax.swing.JLabel lblCnombreP;
    private javax.swing.JLabel lblCraza;
    private javax.swing.JLabel lblCsexo;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblcapilar;
    private javax.swing.JLabel lblcedula;
    private javax.swing.JLabel lblconstantesF;
    private javax.swing.JLabel lbldatoscli;
    private javax.swing.JLabel lbldatosmas;
    private javax.swing.JLabel lblespecie;
    private javax.swing.JLabel lblfc;
    private javax.swing.JLabel lblfecha;
    private javax.swing.JLabel lblfr;
    private javax.swing.JLabel lblgrados;
    private javax.swing.JLabel lblhidrata;
    private javax.swing.JLabel lblkg;
    private javax.swing.JLabel lblmucosa;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JLabel lblnombrem1;
    private javax.swing.JLabel lblnombrem2;
    private javax.swing.JLabel lblobserva;
    private javax.swing.JLabel lblpeso;
    private javax.swing.JLabel lblprocentaje;
    private javax.swing.JLabel lblraza;
    private javax.swing.JLabel lblrm;
    private javax.swing.JLabel lblsexo;
    private javax.swing.JLabel lblsintoma1;
    private javax.swing.JLabel lbltemperatura;
    private javax.swing.JLabel lbltext;
    private javax.swing.JLabel lbltext2;
    private javax.swing.JLabel lbltitle2;
    private javax.swing.JLabel lbltratamiento;
    private javax.swing.JPanel pnlBmascota;
    private javax.swing.JPanel pnlCmascota;
    private javax.swing.JScrollPane scrBmascota;
    private javax.swing.JScrollPane srlBpersona;
    private javax.swing.JTextArea tatCmotivos;
    private javax.swing.JTextArea tatCobservaciones;
    private javax.swing.JTextArea tatCtratamiento;
    private javax.swing.JTable tblBmascota;
    private javax.swing.JTable tblBpersona;
    private javax.swing.JTextField txtBpersona;
    private javax.swing.JTextField txtCllenado;
    // End of variables declaration//GEN-END:variables
}
