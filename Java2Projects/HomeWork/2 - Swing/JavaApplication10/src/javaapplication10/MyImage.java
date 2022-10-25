package javaapplication10;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class MyImage extends JComponent {
   private Image         image;
   private BufferedImage buf;
    
   public void setImage(InputStream in){
     try{  
        buf=ImageIO.read(in); 
        if (buf!=null)  repaint();
     }  
     catch(IOException ex){ System.out.println(ex.getMessage()); }
   }
   
   @Override
   protected void paintComponent(Graphics g) {
        if (buf!=null) {
            double k=(double)getWidth()/buf.getWidth();
            int h=(int)(buf.getHeight()*k);
            image=buf.getScaledInstance(getWidth(),h,Image.SCALE_FAST);
            
            if (image!=null) {
                Graphics2D g2=(Graphics2D) g;
                g2.drawImage(image, 0, 0, null);
            }
        }
        else g.drawString("No Picture!!!", 20, 20);
    }
}
