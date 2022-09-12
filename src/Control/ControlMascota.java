package Control;

import Modelo.ClasesModelo.ModeloCliente;
import Modelo.ClasesModelo.ModeloMascota;
import Modelo.Cliente;
import Modelo.Mascota;
import Vista.VistaMascota;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControlMascota {

    private VistaMascota Vmas;
    private ModeloCliente cliM;
    private ModeloMascota masM;

    private int i = 0;

    public ControlMascota(VistaMascota Vmas, ModeloCliente cliM, ModeloMascota masM) {
        this.Vmas = Vmas;
        this.cliM = cliM;
        this.masM = masM;
        referenciarObjetos();
    }

    public void iniciarControl() {

        Vmas.getBtn_Vbuscar().addActionListener(l -> cambiarPanel("buscar"));
        Vmas.getBtn_Vmodificar().addActionListener(l -> cambiarPanel("modificar"));
        evtVerMascota(Vmas.getTblBpersona());
        evtVerFotoMas(Vmas.getTblBmascota());
    }

    //cambiar entre ventanas de los paneles 
    private void cambiarPanel(String tipo) {
        switch (tipo) {

            case "buscar":
                Vmas.getPnlBmascota().setVisible(true);
                Vmas.getPnlGmascota().setVisible(false);
                break;

            case "modificar":
                Vmas.getPnlBmascota().setVisible(false);
                Vmas.getPnlGmascota().setVisible(true);
                break;

        }

    }

    private void referenciarObjetos() {
        llenarTabla();

        //Desactivar la tabla de mascotas para ser mostradas despues si tiene
        Vmas.getScrBmascota().setVisible(false);
        Vmas.getLblBselecMas().setVisible(false);
    }

    private void evtVerMascota(JTable busqueda) {
        busqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verMascotaDni(evt);
            }
        });
    }

    //Crear evento para tener la mascota
    private void evtVerFotoMas(JTable buscarMas) {

        buscarMas.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ponerFotoMascota(evt);
            }
        });

    }

    //Recuperar el id de la mascota para poner mostrar a la gente
    private void ponerFotoMascota(java.awt.event.MouseEvent evt) {
        String idString = "";
        int id= 0;

        DefaultTableModel tm = (DefaultTableModel) Vmas.getTblBmascota().getModel();

        idString =  String.valueOf(tm.getValueAt(Vmas.getTblBmascota().getSelectedRow(), 0));
        id = Integer.parseInt(idString);
        BuscarFotoMascota(id);
    }

    private void BuscarFotoMascota(int id) {
        Mascota masF = new Mascota();
        masF = masM.verFotoMascota(id);

        //llenar imagen
        byte[] bi = masF.getFoto();
        if (bi != null) {

            try {
                BufferedImage image = null;
                InputStream in = new ByteArrayInputStream(bi);
                image = ImageIO.read(in);
                ImageIcon imi = new ImageIcon(image.getScaledInstance(170, 180, Image.SCALE_SMOOTH));
                Vmas.getLblBFoto().setIcon(imi);
                Vmas.getLblBFoto().updateUI();
              
            } catch (IOException ex) {
                Logger.getLogger(ControlMascota.class.getName()).log(Level.SEVERE, null, ex);
            }

        }else{
            Vmas.getLblBFoto().setIcon(null);
            Vmas.getLblBFoto().updateUI();
        }
    }

    //Recuperar la cedula para cargar las mascotas que esten asociadas a al persona
    private void verMascotaDni(java.awt.event.MouseEvent evt) {
        String cedulaB = "";

        DefaultTableModel tm = (DefaultTableModel) Vmas.getTblBpersona().getModel();

        cedulaB = String.valueOf(tm.getValueAt(Vmas.getTblBpersona().getSelectedRow(), 0));
        llenarTablaMascotas(cedulaB);
        Vmas.getLblBselecMas().setVisible(true);
        Vmas.getScrBmascota().setVisible(true);
    }

    private void llenarTablaMascotas(String cedula) {
        DefaultTableModel estructuraTabla;
        estructuraTabla = (DefaultTableModel) Vmas.getTblBmascota().getModel();
        estructuraTabla.setNumRows(0);
        List<Mascota> listmas = masM.consultarMascotaCedu(cedula);
        i = 0;

        listmas.stream().forEach(mascota -> {

            estructuraTabla.addRow(new Object[2]);
            Vmas.getTblBmascota()
                    .setValueAt(mascota.getMas_id(),
                            i, 0);
            Vmas.getTblBmascota()
                    .setValueAt(mascota.getMas_nombreMas(),
                            i, 1);
            Vmas.getTblBmascota()
                    .setValueAt(mascota.getMas_especie(),
                            i, 2);
            Vmas.getTblBmascota()
                    .setValueAt(mascota.getMas_raza(),
                            i, 3);

            i = i + 1;

        });
    }

    private void llenarTabla() {

        i = 0;
        DefaultTableModel estructuraTabla;
        estructuraTabla = (DefaultTableModel) Vmas.getTblBpersona().getModel();
        estructuraTabla.setNumRows(0);
        List<Cliente> listC = cliM.recuperarClientes();
        listC.stream().forEach(cliente -> {
            estructuraTabla.addRow(new Object[1]);

            Vmas.getTblBpersona()
                    .setValueAt(cliente.getPer_dni(), i, 0);
            Vmas.getTblBpersona()
                    .setValueAt(cliente.getPer_nombre1(), i, 1);
            Vmas.getTblBpersona()
                    .setValueAt(cliente.getPer_apellido1(), i, 2);
            Vmas.getTblBpersona()
                    .setValueAt(cliente.getPer_apellido2(), i, 3);
            i = i + 1;
        });
    }
}
