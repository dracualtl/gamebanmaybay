/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Center;
import java.awt.*;
import javax.swing.JFrame;
/**
 *
 * @author dell
 */
//DAU TIEN
public class window extends Canvas {
    
    public window(int width,int height,String title,Game game){
        
        JFrame f=new JFrame(title);
        
        f.setPreferredSize(new Dimension(width,height));
        f.setMaximumSize(new Dimension(width,height));
        f.setMinimumSize(new Dimension(width,height));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.add(game);//add game class into frame
        f.setVisible(true);
        game.start();
        
    }
// DAU TIEN            
}
