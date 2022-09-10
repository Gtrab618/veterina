
package Control;

import Vista.VistaLogin;

public class ControlPrincipal {
    private VistaLogin vlogin;
    public ControlPrincipal(VistaLogin vlogin){
        this.vlogin = vlogin;
        vlogin.setVisible(true);
        
    }
    
}
