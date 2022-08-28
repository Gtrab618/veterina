
package Vista;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;

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
    

    public JDesktopPane getDkpPrincipal() {
        return DkpPrincipal;
    }

    public void setDkpPrincipal(JDesktopPane DkpPrincipal) {
        this.DkpPrincipal = DkpPrincipal;
    }

    public JLabel getLblClientes() {
        return LblClientes;
    }

    public void setLblClientes(JLabel LblClientes) {
        this.LblClientes = LblClientes;
    }


    public JLabel getLblFotoUsuario() {
        return LblFotoUsuario;
    }

    public void setLblFotoUsuario(JLabel LblFotoUsuario) {
        this.LblFotoUsuario = LblFotoUsuario;
    }

    public JLabel getLblGrooming() {
        return LblGrooming;
    }

    public void setLblGrooming(JLabel LblGrooming) {
        this.LblGrooming = LblGrooming;
    }

    public JLabel getLblHistorial() {
        return LblHistorial;
    }

    public void setLblHistorial(JLabel LblHistorial) {
        this.LblHistorial = LblHistorial;
    }

    public JLabel getLblLogOut() {
        return LblLogOut;
    }

    public void setLblLogOut(JLabel LblLogOut) {
        this.LblLogOut = LblLogOut;
    }

    public JLabel getLblMascota() {
        return LblMascota;
    }

    public void setLblMascota(JLabel LblMascota) {
        this.LblMascota = LblMascota;
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



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        LblFotoUsuario = new javax.swing.JLabel();
        LblNombreUsuario = new javax.swing.JLabel();
        LblTipoAcceso = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        LblMascota = new javax.swing.JLabel();
        LblGrooming = new javax.swing.JLabel();
        LblHistorial = new javax.swing.JLabel();
        LblLogOut = new javax.swing.JLabel();
        LblClientes = new javax.swing.JLabel();
        ImageIcon icon = new ImageIcon(getClass().getResource("/Iconos/vtMain.png"));
        Image image = icon.getImage();
        DkpPrincipal = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuDarkMode = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        LblFotoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Avatar_60px.png"))); // NOI18N
        LblFotoUsuario.setToolTipText("Foto Usuario");

        LblNombreUsuario.setText("N O M B R E     U S U A R I O");

        LblTipoAcceso.setText("ADMIN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(LblFotoUsuario)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LblNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(LblTipoAcceso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(LblNombreUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LblTipoAcceso))
                    .addComponent(LblFotoUsuario))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        LblMascota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/mascota_45px.png"))); // NOI18N
        LblMascota.setText("M A S C O T A");
        LblMascota.setToolTipText("Registro Mascota");

        LblGrooming.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/grooming_45px.png"))); // NOI18N
        LblGrooming.setText("G R O O M I NG");
        LblGrooming.setToolTipText("Grooming");

        LblHistorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/historial_45px.png"))); // NOI18N
        LblHistorial.setText("H I S T O R I A L");
        LblHistorial.setToolTipText("Visualizacion Historial");

        LblLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/exit_45px.png"))); // NOI18N
        LblLogOut.setText("L O G   O U T");
        LblLogOut.setToolTipText("Log Out");

        LblClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/clientes_45px.png"))); // NOI18N
        LblClientes.setText("C L I E N T E S");
        LblClientes.setToolTipText("Registro Clientes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LblMascota, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(LblGrooming, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(LblHistorial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
            .addComponent(LblLogOut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(LblClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LblClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(LblMascota, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(LblGrooming, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(LblHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(LblLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(186, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DkpPrincipalLayout = new javax.swing.GroupLayout(DkpPrincipal);
        DkpPrincipal.setLayout(DkpPrincipalLayout);
        DkpPrincipalLayout.setHorizontalGroup(
            DkpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1561, Short.MAX_VALUE)
        );
        DkpPrincipalLayout.setVerticalGroup(
            DkpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jMenu1.setText("Ajustes");

        menuDarkMode.setSelected(true);
        menuDarkMode.setText("DarkMode");
        jMenu1.add(menuDarkMode);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(DkpPrincipal))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(DkpPrincipal))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane DkpPrincipal;
    private javax.swing.JLabel LblClientes;
    private javax.swing.JLabel LblFotoUsuario;
    private javax.swing.JLabel LblGrooming;
    private javax.swing.JLabel LblHistorial;
    private javax.swing.JLabel LblLogOut;
    private javax.swing.JLabel LblMascota;
    private javax.swing.JLabel LblNombreUsuario;
    private javax.swing.JLabel LblTipoAcceso;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JCheckBoxMenuItem menuDarkMode;
    // End of variables declaration//GEN-END:variables
}
