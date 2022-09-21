package Control;

import Vista.VistaAcerca;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class ControlAcercaDe extends Thread {

    private VistaAcerca vis;
    static boolean bucleAniP = true;
    static int bandera = 1;

    public ControlAcercaDe(VistaAcerca vis) {
        this.vis = vis;
        
    }

    @Override
    public void run() {
        referenciarObjetos();
        moverGato();

    }

    private void moverGato() {
        referenciarObjetos();
        while (bandera == 1) {
            vis.getCatHB().setLocation(vis.getCatHB().getLocation().x + 1, 690);
            hiloTrans();
           
            if (vis.getCatHB().getLocation().x > 980) {

                bandera = gatoRandom();
                moverGato();
            }
            
        }
        while (bandera == 2) {
            vis.getCatDS().setLocation(920, vis.getCatDS().getLocation().y - 1);
            hiloTrans();
            
            if (vis.getCatDS().getLocation().y < -80) {

                bandera = gatoRandom();
                 moverGato();
            }

        }

        while (bandera == 3) {
            vis.getCatHA().setLocation(vis.getCatHA().getLocation().x - 1, 0);
            hiloTrans();
            
            if (vis.getCatHA().getLocation().x <-70) {

                bandera = gatoRandom();
                moverGato();
            }

        }

        while (bandera == 4) {
            vis.getCatIzqB().setLocation(0, vis.getCatIzqB().getLocation().y + 1);
            hiloTrans();
            
            if (vis.getCatIzqB().getLocation().y > 700) {

                bandera = gatoRandom();
                moverGato();

            }

        }

    }

    private void referenciarObjetos() {
//        vis.getCatDS().setVisible(false);
//        vis.getCatHA().setVisible(false);
//        vis.getCatHB().setVisible(false);
//        vis.getCatIzqB().setVisible(false);
        vis.getCatDS().setLocation(920, 730);
        vis.getCatHA().setLocation(980, 0);
        vis.getCatHB().setLocation(-80, 690);
        vis.getCatIzqB().setLocation(0, -85);
    }

    //tiempo de espera para mover imagen
    private void hiloTrans() {
        try {
            sleep(5);
        } catch (InterruptedException ex) {
            Logger.getLogger(ControlLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //selecicionar gato aleatorio
    private int gatoRandom(){
         return (int) (Math.random()*4 + 1);
    }


}
