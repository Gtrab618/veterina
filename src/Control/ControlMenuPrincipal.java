package Control;

import Modelo.ClasesModelo.ModeloCliente;
import Modelo.ClasesModelo.ModeloPersona;
import Modelo.ClasesModelo.ModeloMascota;
import Vista.VistaMas;

import Vista.VistaMenuPrincipal;
import Vista.vistaRegistro;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme;
import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ControlMenuPrincipal {

    private VistaMenuPrincipal vistaMP;
   
    private JPanel[] panelsBtn = new JPanel[5];
    //Controla el cambio de temas de modo dark
    private int bandera = 0;
    private int r = 23, g = 32, b = 48;
    //solo temproal al final se boora
    VistaMas vMas = new VistaMas();

    public ControlMenuPrincipal(VistaMenuPrincipal vista) {
        this.vistaMP = vista;
        this.vistaMP.setLocationRelativeTo(null);
        SinDarck();
        //this.vistaMP.setSize(500,500);
        referenciarObjetos();
        cambiarFondo(r, g, b);
        vista.setVisible(true);
        
    }

    public void iniciarControlMenu() {
        //labels
        vistaMP.getMenuDarkMode().addActionListener(l -> VisualizarDarkMode());
        

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
                        vistaRegistro vRegis = new vistaRegistro();
                        ModeloPersona Mper= new ModeloPersona();
                        ModeloMascota Mmas = new ModeloMascota();
                        ModeloCliente Ccli = new ModeloCliente();
                        ControlRegistro ctn = new ControlRegistro(vRegis,Mper,Mmas,Ccli);
                        ctn.iniciarControl();
                        vRegis.resetKeyboardActions();
                        vRegis.setSize(1155, 863);
                        vRegis.setLocation(0, 0);
                        vistaMP.getPnlContent().removeAll();
                        vistaMP.getPnlContent().add(vRegis, BorderLayout.CENTER);
                        vistaMP.revalidate();
                        vistaMP.getPnlContent().repaint();
                        
                        break;
                    case "grooming":
                        
                        vMas.setSize(835, 863);
                        vMas.setLocation(0, 0);
                        vistaMP.getPnlContent().removeAll();
                        vistaMP.getPnlContent().add(vMas, BorderLayout.CENTER);
                        vistaMP.revalidate();       
                        vistaMP.getPnlContent().repaint();
     
                        break;
                    case "mascota":
                        
                        vMas.setSize(835, 863);
                        vMas.setLocation(0, 0);
                        vistaMP.getPnlContent().removeAll();
                        vistaMP.getPnlContent().add(vMas, BorderLayout.CENTER);                       
                        vistaMP.revalidate();
                        vistaMP.getPnlContent().repaint();
                        break;
                    case "historial":
                      
                        vMas.setSize(835, 670);
                        vMas.setLocation(0, 0);
                        vistaMP.getPnlContent().removeAll();
                        vistaMP.getPnlContent().add(vMas, BorderLayout.CENTER);
                        vistaMP.revalidate();
                        vistaMP.getPnlContent().repaint();
                    
                        break;

                }

            }
        });
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



    //iniciar sin darck mode
    private void SinDarck(){
        vistaMP.getMenuDarkMode().isSelected();
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
