package jp.shuma;

import java.awt.Robot;
import java.awt.AWTException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.WindowConstants;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws AWTException
    {
        final Robot rb = new Robot();
//            rb=new Robot();
            rb.setAutoDelay(100);
        
        rb.mouseMove(370, 210);
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame window = new JFrame("catchMouse");
        window.setUndecorated(true);
        System.out.println(System.getProperty("java.runtime.version"));
        if(System.getProperty("java.runtime.version").contains("1.7")) {
            window.setBackground(new Color(120,0,0,120));
        } else {
            com.sun.awt.AWTUtilities.setWindowOpaque(window, false);
        }
        window.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e){}
            public void mouseEntered(MouseEvent e){}
            public void mouseExited(MouseEvent e){
                JFrame window = (JFrame)e.getComponent();
                Toolkit.getDefaultToolkit().beep();
                rb.mouseMove(window.getX()+window.getWidth()/2, window.getY()+window.getHeight()/2);
            }
            public void mousePressed(MouseEvent e){}
            public void mouseReleased(MouseEvent e){}
        });
//        JPanel panel = new JPanel();
//        panel.setOpaque(true);
//        panel.setBackground(new Color(0, 0, 0,0));
// 
//        window.getContentPane().add(panel);
        BufferedImage image = new BufferedImage(16,16,
                                                BufferedImage.TYPE_4BYTE_ABGR);
        
        
        Graphics2D g2 = image.createGraphics();
        // 黒で透明 black & transparency
        g2.setColor(new Color(0,0,0,0));
        g2.fillRect(0,0, 16,16);
        g2.dispose();
        window.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(image, new Point(0,0), "null_cursor"));
        
        
        
        window.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        window.setBounds(320, 160, 100, 100);
        window.setVisible(true);
    }
}
