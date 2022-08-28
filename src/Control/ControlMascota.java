
package Control;

import Modelo.ClasesModelo.ModeloMascota;
import Vista.VistaMascota;

public class ControlMascota {
    private ModeloMascota modelo;
    private VistaMascota vista;
    
    
    public ControlMascota(ModeloMascota modelo,VistaMascota vista){
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
        
    }
}
