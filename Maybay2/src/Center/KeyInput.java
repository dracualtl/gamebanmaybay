/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Center;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import Interface.plane;

/**
 *
 * @author dell
 */
public class KeyInput extends KeyAdapter {
    private Handler handler;
    plane pin ,pout;
    private boolean[] keydown = new boolean[4];
    public KeyInput(Handler handler){
        this.handler=handler;
        keydown[0]= false; //up
        keydown[1]= false; //down
        keydown[2]= false; //left
        keydown[3]= false; //right
    }
    
    public void keyPressed(KeyEvent e){
        int key=e.getKeyCode();
        //System.out.println(key);
        
        for(int i=0;i<handler.object.size();i++){
            GameObject tempobject=handler.object.get(i);
            
            if(tempobject.getid()==ID.player){//key event for player 1
                pin= (plane) tempobject;
                if(key==KeyEvent.VK_UP) {tempobject.setvely(-5); keydown[0]=true;};//tempobject=ID.player
                if(key==KeyEvent.VK_DOWN) {tempobject.setvely(5); keydown[1]=true;} 
                if(key==KeyEvent.VK_RIGHT) {tempobject.setvelx(5); keydown[3]=true;}
                if(key==KeyEvent.VK_LEFT) {tempobject.setvelx(-5); keydown[2]=true;}
                if(key==KeyEvent.VK_Z) pin.setban(key);
                if(key==KeyEvent.VK_X) pin.x_on();
                if(key==KeyEvent.VK_C) pin.doidan();
            }
            
            /*if(tempobject.getid()==ID.player2){//key event for player 1
                
                if(key==KeyEvent.VK_UP) tempobject.setvely(-5);//tempobject=ID.player
                if(key==KeyEvent.VK_DOWN) tempobject.setvely(5);
                if(key==KeyEvent.VK_RIGHT) tempobject.setvelx(5);
                if(key==KeyEvent.VK_LEFT) tempobject.setvelx(-5);
            }*/
        }
    }
    
    public void keyReleased(KeyEvent e){
        int key=e.getKeyCode();
        
        for(int i=0;i<handler.object.size();i++){
            GameObject tempobject=handler.object.get(i);
            
            if(tempobject.getid()==ID.player){//key event for player 1
                pout = (plane) tempobject;
                if(key==KeyEvent.VK_UP) keydown[0]=false;//tempobject=ID.player
                if(key==KeyEvent.VK_DOWN) keydown[1]=false;
                if(key==KeyEvent.VK_RIGHT) keydown[3]=false;
                if(key==KeyEvent.VK_LEFT) keydown[2]=false;
                if(key==KeyEvent.VK_Z) pout.ngungban();
                if(key==KeyEvent.VK_X) pin.x_off();
                if(!keydown[0] && !keydown[1]) tempobject.setvely(0);
                if(!keydown[2] && !keydown[3]) tempobject.setvelx(0);
            }
            
            /*if(tempobject.getid()==ID.player2){//key event for player 1
                
                if(key==KeyEvent.VK_UP) tempobject.setvely(0);//tempobject=ID.player
                if(key==KeyEvent.VK_DOWN) tempobject.setvely(0);
                if(key==KeyEvent.VK_RIGHT) tempobject.setvelx(0);
                if(key==KeyEvent.VK_LEFT) tempobject.setvelx(0);
            }*/
        }
    }
    
}
