
package Vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VistaLogin extends javax.swing.JFrame {

    public VistaLogin() {
        initComponents();
    }

    public JLabel getLbl_AlertU() {
        return lbl_AlertU;
    }

    public void setLbl_AlertU(JLabel lbl_AlertU) {
        this.lbl_AlertU = lbl_AlertU;
    }

    public JLabel getLbl_AlertP() {
        return lbl_AlertP;
    }

    public void setLbl_AlertP(JLabel lbl_AlertP) {
        this.lbl_AlertP = lbl_AlertP;
    }


    
    public JButton getBtnIngresar() {
        return btnIngresar;
    }

    public void setBtnIngresar(JButton btnIngresar) {
        this.btnIngresar = btnIngresar;
    }

    public JPasswordField getTxtContraseña() {
        return txtContraseña;
    }

    public void setTxtContraseña(JPasswordField txtContraseña) {
        this.txtContraseña = txtContraseña;
    }

    public JTextField getTxtNombreUsuario() {
        return txtNombreUsuario;
    }

    public void setTxtNombreUsuario(JTextField txtNombreUsuario) {
        this.txtNombreUsuario = txtNombreUsuario;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getLbl_ani1() {
        return lbl_ani1;
    }

    public void setLbl_ani1(JLabel lbl_ani1) {
        this.lbl_ani1 = lbl_ani1;
    }

    public JLabel getLbl_ani2() {
        return lbl_ani2;
    }

    public void setLbl_ani2(JLabel lbl_ani2) {
        this.lbl_ani2 = lbl_ani2;
    }

    public JLabel getLbl_ani3() {
        return lbl_ani3;
    }

    public void setLbl_ani3(JLabel lbl_ani3) {
        this.lbl_ani3 = lbl_ani3;
    }

    public JLabel getLbl_hide() {
        return lbl_hide;
    }

    public void setLbl_hide(JLabel lbl_hide) {
        this.lbl_hide = lbl_hide;
    }

    public JLabel getLbl_show() {
        return lbl_show;
    }

    public void setLbl_show(JLabel lbl_show) {
        this.lbl_show = lbl_show;
    }

    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        pnl_Principal = new javax.swing.JPanel();
        pnl_1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbl_imgLogo = new javax.swing.JLabel();
        pnl_animacion = new javax.swing.JPanel();
        lbl_ani1 = new javax.swing.JLabel();
        lbl_ani2 = new javax.swing.JLabel();
        lbl_ani3 = new javax.swing.JLabel();
        lbl_fondo = new javax.swing.JLabel();
        pnl_2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        lbl_icoUse = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txtNombreUsuario = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        txtContraseña = new javax.swing.JPasswordField();
        lbl_icoPass = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        lbl_title = new javax.swing.JLabel();
        lbl_hide = new javax.swing.JLabel();
        lbl_show = new javax.swing.JLabel();
        lbl_AlertU = new javax.swing.JLabel();
        lbl_AlertP = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_Principal.setBackground(new java.awt.Color(51, 51, 51));
        pnl_Principal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Control de Acceso");
        pnl_1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, -1, -1));

        lbl_imgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/login/vtMain2.png"))); // NOI18N
        pnl_1.add(lbl_imgLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 160));

        pnl_animacion.setOpaque(false);
        pnl_animacion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_ani1.setBackground(new java.awt.Color(204, 204, 204));
        lbl_ani1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/login/ani1.png"))); // NOI18N
        pnl_animacion.add(lbl_ani1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 360, 230));

        lbl_ani2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/login/ani2.png"))); // NOI18N
        pnl_animacion.add(lbl_ani2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 360, 230));

        lbl_ani3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/login/ani3.png"))); // NOI18N
        pnl_animacion.add(lbl_ani3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 360, 230));

        pnl_1.add(pnl_animacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 840, 230));

        lbl_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/login/fondoLogin.jpeg"))); // NOI18N
        pnl_1.add(lbl_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 470));

        pnl_Principal.add(pnl_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 470));

        pnl_2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        pnl_2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 71, 382, 10));

        lbl_icoUse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/login/imgUser.png"))); // NOI18N
        lbl_icoUse.setToolTipText("Usuario");
        pnl_2.add(lbl_icoUse, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 104, -1, -1));

        jSeparator2.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        pnl_2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 287, 10));

        txtNombreUsuario.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txtNombreUsuario.setForeground(new java.awt.Color(153, 153, 153));
        txtNombreUsuario.setText("Ingrese su nombre de usuario");
        txtNombreUsuario.setToolTipText("");
        txtNombreUsuario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtNombreUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        pnl_2.add(txtNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 119, 271, 36));

        jSeparator3.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator3.setForeground(new java.awt.Color(204, 204, 204));
        pnl_2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 243, 287, 10));

        txtContraseña.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txtContraseña.setForeground(new java.awt.Color(204, 204, 204));
        txtContraseña.setText("********");
        txtContraseña.setToolTipText("");
        txtContraseña.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnl_2.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 195, 273, 36));

        lbl_icoPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/login/imgPass.png"))); // NOI18N
        lbl_icoPass.setToolTipText("Contraseña");
        pnl_2.add(lbl_icoPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 195, -1, -1));

        btnIngresar.setBackground(new java.awt.Color(114, 71, 197));
        btnIngresar.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(204, 204, 204));
        btnIngresar.setText("I N G R E S A R");
        btnIngresar.setToolTipText("Ingresar ");
        btnIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnl_2.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 309, 304, 49));

        lbl_title.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        lbl_title.setText("Ingrese sus Datos");
        lbl_title.setEnabled(false);
        pnl_2.add(lbl_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 40, 201, -1));

        lbl_hide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/login/hide.png"))); // NOI18N
        pnl_2.add(lbl_hide, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 195, 40, 40));

        lbl_show.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/login/show.png"))); // NOI18N
        pnl_2.add(lbl_show, new org.netbeans.lib.awtextra.AbsoluteConstraints(421, 195, 40, 40));

        lbl_AlertU.setForeground(new java.awt.Color(255, 0, 0));
        lbl_AlertU.setText("Ingrese un usuario");
        pnl_2.add(lbl_AlertU, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 470, -1, -1));

        lbl_AlertP.setForeground(new java.awt.Color(255, 0, 0));
        lbl_AlertP.setText("Ingrese una contraseña");
        pnl_2.add(lbl_AlertP, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 470, -1, -1));

        pnl_Principal.add(pnl_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 520, 500));

        getContentPane().add(pnl_Principal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lbl_AlertP;
    private javax.swing.JLabel lbl_AlertU;
    private javax.swing.JLabel lbl_ani1;
    private javax.swing.JLabel lbl_ani2;
    private javax.swing.JLabel lbl_ani3;
    private javax.swing.JLabel lbl_fondo;
    private javax.swing.JLabel lbl_hide;
    private javax.swing.JLabel lbl_icoPass;
    private javax.swing.JLabel lbl_icoUse;
    private javax.swing.JLabel lbl_imgLogo;
    private javax.swing.JLabel lbl_show;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JPanel pnl_1;
    private javax.swing.JPanel pnl_2;
    private javax.swing.JPanel pnl_Principal;
    private javax.swing.JPanel pnl_animacion;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtNombreUsuario;
    // End of variables declaration//GEN-END:variables
}
