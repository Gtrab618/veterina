
package Vista;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class VistaMenuPrincipal extends javax.swing.JFrame {

    public VistaMenuPrincipal() {
        initComponents();
    }

    public JCheckBoxMenuItem getMenuDarkMode() {
        return menuDarkMode;
    }

    public void setMenuDarkMode(JCheckBoxMenuItem menuDarkMode) {
        this.menuDarkMode = menuDarkMode;
    }

    public JLabel getLblFotoUsuario() {
        return LblFotoUsuario;
    }

    public void setLblFotoUsuario(JLabel LblFotoUsuario) {
        this.LblFotoUsuario = LblFotoUsuario;
    }

    public JLabel getLblNombreUsuario() {
        return LblNombreUsuario;
    }

    public void setLblNombreUsuario(JLabel LblNombreUsuario) {
        this.LblNombreUsuario = LblNombreUsuario;
    }

    public JLabel getLblTipoAcceso() {
        return LblTipoAcceso;
    }

    public void setLblTipoAcceso(JLabel LblTipoAcceso) {
        this.LblTipoAcceso = LblTipoAcceso;
    }

    public JPanel getFondo() {
        return fondo;
    }

    public void setFondo(JPanel fondo) {
        this.fondo = fondo;
    }

    public JMenu getjMenu1() {
        return jMenu1;
    }

    public void setjMenu1(JMenu jMenu1) {
        this.jMenu1 = jMenu1;
    }

    public JMenuBar getjMenuBar1() {
        return jMenuBar1;
    }

    public void setjMenuBar1(JMenuBar jMenuBar1) {
        this.jMenuBar1 = jMenuBar1;
    }

    public JPanel getPnlBtnClien() {
        return pnlBtnClien;
    }

    public void setPnlBtnClien(JPanel pnlBtnClien) {
        this.pnlBtnClien = pnlBtnClien;
    }

    public JPanel getPnlBtnGroo() {
        return pnlBtnGroo;
    }

    public void setPnlBtnGroo(JPanel pnlBtnGroo) {
        this.pnlBtnGroo = pnlBtnGroo;
    }

    public JPanel getPnlBtnHist() {
        return pnlBtnHist;
    }

    public void setPnlBtnHist(JPanel pnlBtnHist) {
        this.pnlBtnHist = pnlBtnHist;
    }

    public JPanel getPnlBtnMasc() {
        return pnlBtnMasc;
    }

    public void setPnlBtnMasc(JPanel pnlBtnMasc) {
        this.pnlBtnMasc = pnlBtnMasc;
    }

    public JPanel getPnlMenu() {
        return pnlMenu;
    }

    public void setPnlMenu(JPanel pnlMenu) {
        this.pnlMenu = pnlMenu;
        
    }

    public JPanel getPnlHead() {
        return pnlHead;
    }

    public void setPnlHead(JPanel pnlHead) {
        this.pnlHead = pnlHead;
    }

    public JLabel getLblFecha() {
        return lblFecha;
    }

    public void setLblFecha(JLabel lblFecha) {
        this.lblFecha = lblFecha;
    }

    public JPanel getPnlContent() {
        return pnlContent;
    }

    public void setPnlContent(JPanel pnlContent) {
        this.pnlContent = pnlContent;
    }
    
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        pnlMenu = new javax.swing.JPanel();
        LblFotoUsuario = new javax.swing.JLabel();
        LblNombreUsuario = new javax.swing.JLabel();
        LblTipoAcceso = new javax.swing.JLabel();
        pnlBtnClien = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnlBtnMasc = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pnlBtnGroo = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pnlBtnHist = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pnlHead = new javax.swing.JPanel();
        lblFecha = new javax.swing.JLabel();
        pnlContent = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuDarkMode = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMenu.setBackground(new java.awt.Color(23, 32, 52));
        pnlMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LblFotoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Avatar_60px.png"))); // NOI18N
        LblFotoUsuario.setToolTipText("Foto Usuario");
        pnlMenu.add(LblFotoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 6, -1, -1));

        LblNombreUsuario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LblNombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        LblNombreUsuario.setText("N O M B R E     ");
        pnlMenu.add(LblNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 18, 159, -1));

        LblTipoAcceso.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LblTipoAcceso.setForeground(new java.awt.Color(255, 255, 255));
        LblTipoAcceso.setText("ADMIN");
        pnlMenu.add(LblTipoAcceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 49, 159, -1));

        pnlBtnClien.setBackground(new java.awt.Color(23, 32, 70));
        pnlBtnClien.setPreferredSize(new java.awt.Dimension(148, 60));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Clientes");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cliente.png"))); // NOI18N

        javax.swing.GroupLayout pnlBtnClienLayout = new javax.swing.GroupLayout(pnlBtnClien);
        pnlBtnClien.setLayout(pnlBtnClienLayout);
        pnlBtnClienLayout.setHorizontalGroup(
            pnlBtnClienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBtnClienLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap(158, Short.MAX_VALUE))
        );
        pnlBtnClienLayout.setVerticalGroup(
            pnlBtnClienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBtnClienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBtnClienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(pnlBtnClienLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlMenu.add(pnlBtnClien, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 119, 300, -1));

        pnlBtnMasc.setBackground(new java.awt.Color(23, 32, 70));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mascotas");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/mascota_45px.png"))); // NOI18N

        javax.swing.GroupLayout pnlBtnMascLayout = new javax.swing.GroupLayout(pnlBtnMasc);
        pnlBtnMasc.setLayout(pnlBtnMascLayout);
        pnlBtnMascLayout.setHorizontalGroup(
            pnlBtnMascLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBtnMascLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addContainerGap(144, Short.MAX_VALUE))
        );
        pnlBtnMascLayout.setVerticalGroup(
            pnlBtnMascLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBtnMascLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBtnMascLayout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        pnlMenu.add(pnlBtnMasc, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 182, 300, 60));

        pnlBtnGroo.setBackground(new java.awt.Color(23, 32, 70));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Grooming");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/grooming_45px.png"))); // NOI18N

        javax.swing.GroupLayout pnlBtnGrooLayout = new javax.swing.GroupLayout(pnlBtnGroo);
        pnlBtnGroo.setLayout(pnlBtnGrooLayout);
        pnlBtnGrooLayout.setHorizontalGroup(
            pnlBtnGrooLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBtnGrooLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(146, Short.MAX_VALUE))
        );
        pnlBtnGrooLayout.setVerticalGroup(
            pnlBtnGrooLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBtnGrooLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel5)
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(pnlBtnGrooLayout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlMenu.add(pnlBtnGroo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 245, 300, 60));

        pnlBtnHist.setBackground(new java.awt.Color(23, 32, 70));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/historial_45px.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Historial");

        javax.swing.GroupLayout pnlBtnHistLayout = new javax.swing.GroupLayout(pnlBtnHist);
        pnlBtnHist.setLayout(pnlBtnHistLayout);
        pnlBtnHistLayout.setHorizontalGroup(
            pnlBtnHistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBtnHistLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addContainerGap(161, Short.MAX_VALUE))
        );
        pnlBtnHistLayout.setVerticalGroup(
            pnlBtnHistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBtnHistLayout.createSequentialGroup()
                .addGroup(pnlBtnHistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBtnHistLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7))
                    .addGroup(pnlBtnHistLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pnlMenu.add(pnlBtnHist, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 308, 300, 60));

        fondo.add(pnlMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 670));

        pnlHead.setBackground(new java.awt.Color(23, 32, 52));
        pnlHead.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFecha.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(255, 255, 255));
        pnlHead.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 15, 533, 48));

        fondo.add(pnlHead, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 840, 80));

        pnlContent.setPreferredSize(new java.awt.Dimension(840, 590));

        javax.swing.GroupLayout pnlContentLayout = new javax.swing.GroupLayout(pnlContent);
        pnlContent.setLayout(pnlContentLayout);
        pnlContentLayout.setHorizontalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 835, Short.MAX_VALUE)
        );
        pnlContentLayout.setVerticalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );

        fondo.add(pnlContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 835, 590));

        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 670));

        jMenu1.setText("Ajustes");

        menuDarkMode.setSelected(true);
        menuDarkMode.setText("DarkMode");
        jMenu1.add(menuDarkMode);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LblFotoUsuario;
    private javax.swing.JLabel LblNombreUsuario;
    private javax.swing.JLabel LblTipoAcceso;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JCheckBoxMenuItem menuDarkMode;
    private javax.swing.JPanel pnlBtnClien;
    private javax.swing.JPanel pnlBtnGroo;
    private javax.swing.JPanel pnlBtnHist;
    private javax.swing.JPanel pnlBtnMasc;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JPanel pnlHead;
    private javax.swing.JPanel pnlMenu;
    // End of variables declaration//GEN-END:variables
}
