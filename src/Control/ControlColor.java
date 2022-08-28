
package Control;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class ControlColor extends JPanel{
    private Color color1 = Color.BLUE;
    private Color color2 = Color.RED;
    
    
    public void paint(Graphics2D g){
        super.paint(g);
        Graphics2D G2D = (Graphics2D) g;
        int w = getWidth();
        int h = getHeight();
        
        GradientPaint gp = new GradientPaint(0,0, color1, 0,h, color2);
        G2D.setPaint(gp);
        G2D.fillRect(0, 0, w, h);
    }
}
