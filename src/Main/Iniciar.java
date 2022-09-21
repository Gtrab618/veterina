
package Main;


import Control.ControlLogin;
import Modelo.ClasesModelo.ModeloPersonal;
import Vista.VistaLogin;
import com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme;

public class Iniciar {
    public static void main(String[] args) {
        VistaLogin vLogin = new VistaLogin();
        ModeloPersonal modeloPer = new ModeloPersonal();
        vLogin.setVisible(true);
        ControlLogin hilo1 = new ControlLogin("interfaz", vLogin ,modeloPer);
        ControlLogin hilo2 = new ControlLogin("animacion", vLogin);
        hilo1.start();
        hilo2.start();
        
        FlatCarbonIJTheme.setup();

        
    }
}
