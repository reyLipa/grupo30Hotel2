
package Vistas;


import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Graphics;


/**
 *
 * @author URSULA
 */
public class Imagen extends javax.swing.JLabel{
    int x, y;
    public Imagen(JPanel panel){
        this.x=panel.getWidth();
        this.y=panel.getHeight();
        this.setSize(x, y);
    
        this.setSize(panel.getWidth(),panel.getHeight());
    }
    public void paint(Graphics g){
        ImageIcon img= new ImageIcon(getClass().getResource("/Imagenes/hotel2.jpg"));
      //  ImageIcon img= new ImageIcon(getClass().getResource("/Imagenes/hotel2.jpg"));
        g.drawImage(img.getImage(),0,0,x,y,null);
    }
}
