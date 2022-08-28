
package Control;

import Modelo.ClasesModelo.ModeloMascota;
import Vista.VistaMascota;
import Vista.VistaMenuPrincipal;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme;

import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class ControlMenuPrincipal {
    VistaMenuPrincipal vista;


    public ControlMenuPrincipal(    VistaMenuPrincipal vista){
        this.vista = vista;
        vista.setVisible(true);
        vista.setExtendedState(Frame.MAXIMIZED_BOTH);
        iniciarControlMenu();
    }
    
    public void iniciarControlMenu(){
        //labels
        VisualizarMascota(vista.getLblMascota());
        vista.getMenuDarkMode().addActionListener(l-> VisualizarDarkMode());
        
        
    }
    public void VisualizarDarkMode(){
        if(vista.getMenuDarkMode().isSelected()){
            EventQueue.invokeLater(new Runnable(){
                @Override
                public void run(){
                    FlatCarbonIJTheme.setup();
                    FlatLaf.updateUI();
                    
                }
            });
        }else{
            EventQueue.invokeLater(new Runnable(){
                @Override
                public void run(){
                    FlatIntelliJLaf.setup();
                    FlatLaf.updateUI();
                    
                }
            });
        }
    }
    
    private void VisualizarMascota(JLabel lab){
        lab.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent ex8) {

            VistaMascota vm = new VistaMascota();
            ModeloMascota mm = new ModeloMascota();
            
            vista.getDkpPrincipal().add(vm);
            Control.ControlMascota control = new ControlMascota(mm,vm);
            }
        });
    }
}
