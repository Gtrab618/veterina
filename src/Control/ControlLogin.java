package Control;

import Modelo.ClasesModelo.ModeloPersonal;
import Vista.VistaLogin;
import Vista.VistaMenuPrincipal;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ControlLogin extends Thread {

    private VistaLogin vistaLogin;
    private ModeloPersonal modelo;
    private int banderaAni = 1;
   

   

    public ControlLogin(String name, VistaLogin vistalogin, ModeloPersonal modelo) {
        super(name);
        this.modelo = modelo;
        this.vistaLogin = vistalogin;
        this.vistaLogin.setLocationRelativeTo(null);
        this.vistaLogin.requestFocus();
        vistaLogin.setTitle("LOGIN");
        this.vistaLogin.setIconImage(new ImageIcon(getClass().getResource("/Iconos/login/pet-house.png")).getImage());
    }

    public ControlLogin(String name, VistaLogin vistalogin) {
        super(name);
        this.vistaLogin = vistalogin;
    
    }

    @Override
    public void run() {

        switch (getName()) {
            //controla todo lo relacionado con botones y logeo
            case "interfaz":
                iniciarControl();

                break;
            //controla todo lo relacionado con animaciones 
            case "animacion":
                esperaTrans();
                moverImagenes();
                break;

        }
    }

    public void iniciarControl() {

        vistaLogin.getBtnIngresar().addActionListener(l -> registrar());
        //evento para borrar letra ingrese su usuario
        evtTxtControl(vistaLogin.getTxtNombreUsuario(), "usu");
        evtTxtControl(vistaLogin.getTxtContraseña(), "pass");
        //mostrar y ocultar contraseña
        evtShowHide(vistaLogin.getLbl_show(), "show");
        evtShowHide(vistaLogin.getLbl_hide(), "hide");
        eventofoco(vistaLogin.getTxtNombreUsuario());

    }

    private void eventofoco(JTextField txt) {
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_DOWN) {
                    vistaLogin.getTxtContraseña().requestFocus();
                }
            }

        });
    }

    public void registrar() {
        vistaLogin.getLbl_AlertU().setLocation(140, 470);
        vistaLogin.getLbl_AlertP().setLocation(140, 470);
        char clave[] = vistaLogin.getTxtContraseña().getPassword();
        String clavedef = new String(clave);

        if (!vistaLogin.getTxtNombreUsuario().getText().equals("Ingrese su nombre de usuario") && !clavedef.equalsIgnoreCase("********") && !vistaLogin.getTxtNombreUsuario().getText().equals("") && !clavedef.equalsIgnoreCase("")) {
            //quitar de la vista las alertas 

            if (modelo.iniciarSecion(vistaLogin.getTxtNombreUsuario().getText().trim(), clavedef)) {
               //terminar hilo de animaciones 
                banderaAni=5;
                vistaLogin.dispose();
                VistaMenuPrincipal menuv = new VistaMenuPrincipal();
                Control.ControlMenuPrincipal controlador = new ControlMenuPrincipal(menuv);
                controlador.iniciarControlMenu();

            } else {
                JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
                        + "Por favor ingrese un usuario y/o contraseña correctos",
                        "Acceso denegado", JOptionPane.ERROR_MESSAGE);
                //poner a la vista  las alertas 
                if (vistaLogin.getTxtNombreUsuario().getText().equals("Ingrese su nombre de usuario") || vistaLogin.getTxtNombreUsuario().getText().equals("")) {
                    vistaLogin.getLbl_AlertU().setLocation(140, 90);
                }

                if (clavedef.equalsIgnoreCase("********") || clavedef.equalsIgnoreCase("")) {
                    vistaLogin.getLbl_AlertP().setLocation(140, 170);
                }

            }
        } else {
            //poner a la vista  las alertas 
            if (vistaLogin.getTxtNombreUsuario().getText().equals("Ingrese su nombre de usuario") || vistaLogin.getTxtNombreUsuario().getText().equals("")) {
                vistaLogin.getLbl_AlertU().setLocation(140, 90);
            }

            if (clavedef.equalsIgnoreCase("********") || clavedef.equalsIgnoreCase("")) {
                vistaLogin.getLbl_AlertP().setLocation(140, 170);
            }
        }

    }

 
 

    //contraola el movimiento de las imagenes
    private void moverImagenes() {

      
            while (banderaAni == 1) {
                vistaLogin.getLbl_ani1().setLocation(vistaLogin.getLbl_ani1().getLocation().x - 1, vistaLogin.getLbl_ani1().getLocation().y);
                hiloTrans();
                if (vistaLogin.getLbl_ani1().getLocation().x == -350) {
                    //siguiente animacion
                    banderaAni = 2;
                    //resetear posicion
                    vistaLogin.getLbl_ani1().setLocation(470, vistaLogin.getLbl_ani1().getLocation().y);
                    //recursividad
                    moverImagenes();
                }
                //dormir hilo cuando se centra la imagen
                if (vistaLogin.getLbl_ani1().getLocation().x == 50) {
                    esperaTrans();
                }
            }

            while (banderaAni == 2) {
                vistaLogin.getLbl_ani2().setLocation(vistaLogin.getLbl_ani2().getLocation().x - 1, vistaLogin.getLbl_ani2().getLocation().y);
                hiloTrans();
                if (vistaLogin.getLbl_ani2().getLocation().x == -350) {
                    banderaAni = 3;
                    vistaLogin.getLbl_ani2().setLocation(470, vistaLogin.getLbl_ani2().getLocation().y);
                    moverImagenes();
                }
                if (vistaLogin.getLbl_ani2().getLocation().x == 50) {
                    esperaTrans();
                }
            }

            while (banderaAni == 3) {
                vistaLogin.getLbl_ani3().setLocation(vistaLogin.getLbl_ani3().getLocation().x - 1, vistaLogin.getLbl_ani3().getLocation().y);
                hiloTrans();
                if (vistaLogin.getLbl_ani3().getLocation().x == -350) {

                    banderaAni = 1;
                    vistaLogin.getLbl_ani3().setLocation(470, vistaLogin.getLbl_ani3().getLocation().y);
                    moverImagenes();
                }
                if (vistaLogin.getLbl_ani3().getLocation().x == 50) {
                    esperaTrans();
                }
            }
        

    }

    //tiempo de espera para mover imagen
    private void hiloTrans() {
        try {
            sleep(5);
        } catch (InterruptedException ex) {
            Logger.getLogger(ControlLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //tiempo de espera para la siguiente trancision
    private void esperaTrans() {
        try {
            sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ControlLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //control iteractivos de los campos usuario y contraseña
    private void evtTxtControl(JTextField txt, String name) {
        String nombreTxt = name;
        txt.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {

                switch (nombreTxt) {
                    case "usu":
                        if (vistaLogin.getTxtNombreUsuario().getText().equals("Ingrese su nombre de usuario")) {
                            vistaLogin.getTxtNombreUsuario().setText("");
                            vistaLogin.getTxtNombreUsuario().setForeground(Color.black);
                        }
                        if (String.valueOf(vistaLogin.getTxtContraseña().getPassword()).isEmpty()) {
                            vistaLogin.getTxtContraseña().setText("********");
                            vistaLogin.getTxtContraseña().setForeground(Color.gray);
                        }
                        break;
                    case "pass":
                        if (String.valueOf(vistaLogin.getTxtContraseña().getPassword()).equals("********")) {
                            vistaLogin.getTxtContraseña().setText("");
                            vistaLogin.getTxtContraseña().setForeground(Color.black);
                        }
                        if (vistaLogin.getTxtNombreUsuario().getText().isEmpty()) {
                            vistaLogin.getTxtNombreUsuario().setText("Ingrese su nombre de usuario");
                            vistaLogin.getTxtNombreUsuario().setForeground(Color.gray);
                        }

                        break;

                }

            }
        });
    }

    //Controlar el mostrar y ocultar imagen
    private void evtShowHide(JLabel lab, String opc) {
        String modo = opc;
        lab.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                switch (modo) {
                    case "show":
                        vistaLogin.getTxtContraseña().setEchoChar((char) 0);
                        //bug en ves de ocultarse solo se desplaza la vista
                        //el bug sucede cada vez que se acutaliza el frame aunque este se use hilos
                        vistaLogin.getLbl_show().setLocation(490, vistaLogin.getLbl_show().getLocation().y);
                        vistaLogin.getLbl_hide().setLocation(420, vistaLogin.getLbl_show().getLocation().y);
                        break;
                    case "hide":
                        vistaLogin.getTxtContraseña().setEchoChar('*');
                        vistaLogin.getLbl_hide().setLocation(490, vistaLogin.getLbl_show().getLocation().y);
                        vistaLogin.getLbl_show().setLocation(420, vistaLogin.getLbl_show().getLocation().y);
                        break;

                }
            }
        });
    }

}
