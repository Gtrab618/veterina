
package Vista;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

public class VistaMascota extends javax.swing.JInternalFrame {

    public VistaMascota() {
        initComponents();
    }

    public JButton getBtnAgregar() {
        return BtnAgregar;
    }

    public void setBtnAgregar(JButton BtnAgregar) {
        this.BtnAgregar = BtnAgregar;
    }

    public JButton getBtnEditar() {
        return BtnEditar;
    }

    public void setBtnEditar(JButton BtnEditar) {
        this.BtnEditar = BtnEditar;
    }

    public JButton getBtnEliminar() {
        return BtnEliminar;
    }

    public void setBtnEliminar(JButton BtnEliminar) {
        this.BtnEliminar = BtnEliminar;
    }

    public JButton getBtnImprimir() {
        return BtnImprimir;
    }

    public void setBtnImprimir(JButton BtnImprimir) {
        this.BtnImprimir = BtnImprimir;
    }

    public JButton getBtnVisualizar() {
        return BtnVisualizar;
    }

    public void setBtnVisualizar(JButton BtnVisualizar) {
        this.BtnVisualizar = BtnVisualizar;
    }

    public JTable getTblMascota() {
        return TblMascota;
    }

    public void setTblMascota(JTable TblMascota) {
        this.TblMascota = TblMascota;
    }

    public JTextField getTxtBuscar() {
        return TxtBuscar;
    }

    public void setTxtBuscar(JTextField TxtBuscar) {
        this.TxtBuscar = TxtBuscar;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TxtBuscar = new javax.swing.JTextField();
        BtnVisualizar = new javax.swing.JButton();
        BtnAgregar = new javax.swing.JButton();
        BtnEditar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        BtnImprimir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblMascota = new javax.swing.JTable();

        setClosable(true);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/mascota_45px.png"))); // NOI18N
        jLabel1.setToolTipText("Icon Mascota");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        BtnVisualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/visualizar_32px.png"))); // NOI18N
        BtnVisualizar.setText("Visualizar");
        BtnVisualizar.setToolTipText("Boton Visualizar");

        BtnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/agregar_32px.png"))); // NOI18N
        BtnAgregar.setText("Agregar");
        BtnAgregar.setToolTipText("Boton Agregar");

        BtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/editar_32px.png"))); // NOI18N
        BtnEditar.setText("Editar");
        BtnEditar.setToolTipText("Boton Editar");

        BtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/eliminar_32px.png"))); // NOI18N
        BtnEliminar.setText("Eliminar");
        BtnEliminar.setToolTipText("Boton Eliminar");

        BtnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/imprimir_32px.png"))); // NOI18N
        BtnImprimir.setText("Imprimir");
        BtnImprimir.setToolTipText("Boton Imprimir");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar_32px.png"))); // NOI18N
        jLabel3.setToolTipText("Buscar ");

        TblMascota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TblMascota);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnVisualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnImprimir)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TxtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BtnVisualizar)
                        .addComponent(BtnAgregar)
                        .addComponent(BtnEditar)
                        .addComponent(BtnEliminar)
                        .addComponent(BtnImprimir)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnEditar;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnImprimir;
    private javax.swing.JButton BtnVisualizar;
    private javax.swing.JTable TblMascota;
    private javax.swing.JTextField TxtBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
