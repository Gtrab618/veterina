package Control;

import Modelo.ClasesModelo.ModeloMascota;
import Vista.VistaMas;
import Vista.VistaMascota;
import Vista.VistaMenuPrincipal;
import Vista.vistaRegistro;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme;
import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ControlMenuPrincipal {

    private VistaMenuPrincipal vistaMP;
    private vistaRegistro vRegis = new vistaRegistro();
    private Validaciones vali = new Validaciones();

    private JPanel[] panelsBtn = new JPanel[5];
    //Controla el cambio de temas de modo dark
    private int bandera = 0;
    private int r = 23, g = 32, b = 48;

    public ControlMenuPrincipal(VistaMenuPrincipal vista) {
        this.vistaMP = vista;
        this.vistaMP.setLocationRelativeTo(null);
        //this.vistaMP.setSize(500,500);
        referenciarObjetos();
        cambiarFondo(r, g, b);
        vista.setVisible(true);

    }

    public void iniciarControlMenu() {
        //labels
        vistaMP.getMenuDarkMode().addActionListener(l -> VisualizarDarkMode());
        vRegis.getBtn_registrarR().addActionListener(l -> registrar());

        evtMouseBtn(vistaMP.getPnlBtnClien(), "cliente");
        evtMouseBtn(vistaMP.getPnlBtnGroo(), "grooming");
        evtMouseBtn(vistaMP.getPnlBtnMasc(), "mascota");
        evtMouseBtn(vistaMP.getPnlBtnHist(), "historial");

    }

    private void referenciarObjetos() {
        vistaMP.getPnlBtnClien().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vistaMP.getPnlBtnGroo().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vistaMP.getPnlBtnMasc().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vistaMP.getPnlBtnHist().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        //vista Registro personaMascota
        desactivarLblVRegis();
        //salto de linea vistaRegistro tat
        vRegis.getTat_direccionR().setLineWrap(true);
        //Evitar corte de palabras por la mitad
        vRegis.getTat_direccionR().setWrapStyleWord(true);
        //desactivar alertas

        //Poner fecha
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int dia = now.getDayOfMonth();
        int month = now.getMonthValue();
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", " Septiembre",
            "Octubre", "Noviembre", "Diciemrbre"};
        vistaMP.getLblFecha().setText("Es " + dia + " de " + meses[month - 1] + " de " + year);
    }

    private void evtMouseBtn(JPanel panel, String name) {
        panel.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {

                switch (name) {
                    case "cliente":
                        vistaMP.getPnlBtnClien().setBackground(new Color(r, g + 30, b));
                        ;
                        break;
                    case "grooming":
                        vistaMP.getPnlBtnGroo().setBackground(new Color(r, g + 30, b));
                        break;
                    case "mascota":
                        vistaMP.getPnlBtnMasc().setBackground(new Color(r, g + 30, b));
                        break;
                    case "historial":
                        vistaMP.getPnlBtnHist().setBackground(new Color(r, g + 30, b));
                        break;

                }

            }

            @Override
            public void mouseExited(MouseEvent e) {

                switch (name) {
                    case "cliente":
                        vistaMP.getPnlBtnClien().setBackground(new Color(r, g, b));
                        ;
                        break;
                    case "grooming":
                        vistaMP.getPnlBtnGroo().setBackground(new Color(r, g, b));
                        break;
                    case "mascota":
                        vistaMP.getPnlBtnMasc().setBackground(new Color(r, g, b));
                        break;
                    case "historial":
                        vistaMP.getPnlBtnHist().setBackground(new Color(r, g, b));
                        break;

                }

            }

            @Override
            public void mousePressed(MouseEvent e) {

                switch (name) {
                    case "cliente":
                        vRegis.resetKeyboardActions();
                        vRegis.setSize(1155, 863);
                        vRegis.setLocation(0, 0);
                        vistaMP.getPnlContent().removeAll();
                        vistaMP.getPnlContent().add(vRegis, BorderLayout.CENTER);
                        vistaMP.revalidate();
                        vistaMP.getPnlContent().repaint();
                        break;
                    case "grooming":
                        VistaMas vMas = new VistaMas();
                        vMas.setSize(835, 597);
                        vMas.setLocation(0, 0);
                        vistaMP.getPnlContent().removeAll();
                        vistaMP.getPnlContent().add(vMas, BorderLayout.CENTER);
                        vistaMP.revalidate();
                        vistaMP.getPnlContent().repaint();
                        break;
                    case "mascota":
                        VistaMas vMa = new VistaMas();
                        vMa.setSize(835, 597);
                        vMa.setLocation(0, 0);
                        vistaMP.getPnlContent().removeAll();
                        vistaMP.getPnlContent().add(vMa, BorderLayout.CENTER);
                        vistaMP.revalidate();
                        vistaMP.getPnlContent().repaint();
                        break;
                    case "historial":
                        VistaMas vM = new VistaMas();
                        vM.setSize(835, 670);
                        vM.setLocation(0, 0);
                        vistaMP.getPnlContent().removeAll();
                        vistaMP.getPnlContent().add(vM, BorderLayout.CENTER);
                        vistaMP.revalidate();
                        vistaMP.getPnlContent().repaint();
                        break;

                }

            }
        });
    }

    private void registrar() {
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
        //iMPLEMENTAR METODO LIMPIAR 
        System.out.println(cedula);
        if (!cedula.equals("")) {
            bandera = vali.valiCedula(cedula);

            switch (bandera) {
                case 0:

                    break;
                case 1:
                    vRegis.getLblAlertaCnv().setVisible(true);
                    break;
                default:
                    vRegis.getLblAlertaCf().setVisible(true);
                    break;
            }

        } else {

            vRegis.getLblAlertaCcv().setVisible(true);
        }

        if (!nombre.equals("")) {

        } else {
            vRegis.getLblAlertaNv().setVisible(true);
        }
        if (!pApellido.equals("")) {

        } else {
            vRegis.getLblAlertaPAv().setVisible(true);
        }
        if (!sApellido.equals("")) {

        } else {
            vRegis.getLblAlertaSAv().setVisible(true);
        }
//        if (!telefono.equals("")) {
//            
//        }else{
//           
//        }
//        if (!direccion.equals("")) {
//            
//        }else{
//            
//        }

        if (!nombreM.equals("")) {
            
        } else {
            vRegis.getLblAlertaNMv().setVisible(true);
        }
        
        if (!raza.equals("")) {

        } else {
            vRegis.getLblAlertaRv().setVisible(true);
        }

    }

    private void VisualizarDarkMode() {
        if (vistaMP.getMenuDarkMode().isSelected()) {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    FlatCarbonIJTheme.setup();
                    FlatLaf.updateUI();

                    cambiarFondo(23, 32, 48);
                    r = 23;
                    g = 32;
                    b = 48;
                }
            });
        } else {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    FlatIntelliJLaf.setup();
                    FlatLaf.updateUI();
                    cambiarFondo(13, 71, 161);
                    r = 13;
                    g = 71;
                    b = 161;
                }
            });
        }
    }

    private void cambiarFondo(int r, int g, int b) {

        vistaMP.getPnlMenu().setBackground(new Color(r, g, b + 30));
        vistaMP.getPnlBtnClien().setBackground(new Color(r, g, b));
        vistaMP.getPnlBtnMasc().setBackground(new Color(r, g, b));
        vistaMP.getPnlBtnGroo().setBackground(new Color(r, g, b));
        vistaMP.getPnlBtnHist().setBackground(new Color(r, g, b));
        vistaMP.getPnlHead().setBackground(new Color(r, g, b + 30));
    }

    private void VisualizarMascota(JLabel lab) {
        lab.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent ex8) {

                VistaMascota vm = new VistaMascota();
                ModeloMascota mm = new ModeloMascota();

                Control.ControlMascota control = new ControlMascota(mm, vm);
            }
        });
    }

    private void desactivarLblVRegis() {
        vRegis.getLblAlertaCcv().setVisible(false);
        vRegis.getLblAlertaCf().setVisible(false);
        vRegis.getLblAlertaCnv().setVisible(false);
        vRegis.getLblAlertaNv().setVisible(false);
        vRegis.getLblAlertaPAv().setVisible(false);
        vRegis.getLblAlertaSAv().setVisible(false);
        vRegis.getLblAlertaNMv().setVisible(false);
        vRegis.getLblAlertaRv().setVisible(false);
    }

}
