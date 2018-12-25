/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Center;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import Interface.plane;
import for_use.Vuno2;
import forplayer.*;

/**
 *
 * @author dell
 */
public class player extends GameObject implements plane {
    
    //public Random r;
    private ImageIcon anh = new ImageIcon("data/anh/M11.png");
    private ImageIcon adan = new ImageIcon("data/anh/dan.png");
    private Handler handler;
    private HUD hud;
    private MPBar mp;
    private dan_sm dan;
    private dan_wave dw;
    private dantuychinh dtc;
    private laser la;
    private int bandan=0;
    private Giap gi;
    boolean giap=false;
    private int sung=0;
    final int dan1=1;
    final int dan2=2;
    final int dan3=3;
    private int sodan;
    private int dansudung=dan1;
    private int choban=0;
    int ki;
    public player(int x, int y, ID id,Handler handler, int style, int i) {
        super(x, y, id);
        this.handler=handler;
        this.hud=hud;
        this.mp=mp;
        this.sodan=4000;
        sung=(((int)(Math.random()*99))/50) +1;
        switch(style){
        case 1: anh = new ImageIcon("data/anh/M11.png"); break;
        case 2: anh = new ImageIcon("data/anh/M12.png"); break;
        case 3: anh = new ImageIcon("data/anh/M13.png"); break;
        case 4: anh = new ImageIcon("data/anh/M14.png"); break;
        }
        ki=i-1;
        hud=new HUD(100,15,30 + (i-1)*60);
        mp= new MPBar(2000, 15, 45 + (i-1)*60);
    }
    
    public Rectangle getbounds(){
        return new Rectangle(x+27, y+10, 30, 40);
    }

    public void tick() {
        x+=velx;
        y+=vely;
        if(choban>0) choban=choban-1;
        x=Game.clam(x, 0, Game.width-90);
        y=Game.clam(y, 0, Game.height-90);
        if(bandan!=0 && choban==0) ban();
        if(hud.gethp()<=0){
        	this.handler.addobject(new Vuno2(x-35, y-40, handler));
        	handler.removeobject(this);
        }
        if(giap==true && this.mp.getmp()>200){
    		gi = new Giap(x, y, ID.giap, handler);
    		mp.usemp(2);
    		handler.addobject(gi);
    	}
        if(this.mp.getmp()<=200) x_off();
        collision();
    }
    
    public void collision(){
        for(int i=0;i<handler.getobject().size();i++){
            GameObject tempobject=handler.object.get(i);
            
            if(tempobject.getid()==ID.enemy1){
                if(getbounds().intersects(tempobject.getbounds())){//va cham
                	if(giap==false){
                    	hud.damage(25);}
                    	else {
                    		mp.usemp(250);
                    	}
                    	handler.removeobject(tempobject);
                }
            }
            if(tempobject.getid()==ID.dan_enemy1){
                if(getbounds().intersects(tempobject.getbounds())){//va cham
                	if(giap==false){
                	hud.damage(5);}
                	else {
                		mp.usemp(50);
                	}
                	handler.removeobject(tempobject);
                }
            }
            if(tempobject.getid()==ID.elaser){
                if(getbounds().intersects(tempobject.getbounds())){//va cham
                	if(giap==false){
                    	hud.damage(1);}
                    	else {
                    		mp.usemp(10);
                    	}
                }
            }
        }
    }
        

    public void render(Graphics g) {
        g.setColor(Color.white);
        //Graphics2D g2d=(Graphics2D) g;
        //if(id==ID.player2) g.setColor(Color.yellow);
        //g.fillRect(x, y, 32, 32);
        //g.drawRect(x+27, y+10, 30, 40);
        g.drawImage(anh.getImage(), x, y, null);
        g.drawImage(anh.getImage(), 15, 0+ki*60, 45, 30, null);
        g.drawImage(adan.getImage(), 60, 2+ki*60, null);
        g.setColor(Color.black);
        g.fillRect(75, 2+ki*60, 40, 25);
        g.setColor(Color.white);
        g.setFont(new Font("Tahoma", 0, 12));
        g.drawString("X"+sodan, 80, 25+ki*60);
        hud.render(g);
        mp.render(g);
        //g2d.draw(getbounds());
    }
    public void setban(int e){
    	if(e == KeyEvent.VK_Z) bandan=dansudung;
    }
    public void ngungban(){
    	bandan=0;
    }
    public void doidan(){
    	int i=0;
    	if(bandan!=0){ bandan=0; i=1;}
    	if(dansudung == dan1) dansudung=dan2;
    	else if(dansudung == dan2) dansudung=dan3;
    	else if(dansudung == dan3) dansudung=dan1;
    	if(i==1) bandan=dansudung;
    }
    public void ban(){ 
    	//Thuc hien thao tac ban dan
    	if(bandan==dan1){
    	//ban 2 vien
    		if(sung==1){
    			dan= new dan_sm(x+25, y+20, handler);
    			handler.addobject(dan);
    			sung=2;}
    		else if(sung==2){ dan= new dan_sm(x+50, y+20, handler);
    			handler.addobject(dan);
    			sung=1;}
    	this.sodan=sodan-1;
        choban=2;
        }
    	if(bandan==dan2 && this.mp.getmp()>100){
    		//ban dan laser
    		la= new laser(x+33, y+10, handler);
    		handler.addobject(la);
    		mp.usemp(20);
    	}
    	if(bandan==dan3){
    		dtc= new dantuychinh(x+30, y+3, handler, 0, 10);
    		handler.addobject(dtc);
    		dtc= new dantuychinh(x+30, y+3, handler, +1, 9);
    		handler.addobject(dtc);
    		dtc= new dantuychinh(x+30, y+3, handler, -1, 9);
    		handler.addobject(dtc);
    		dtc= new dantuychinh(x+30, y+3, handler, +2, 8);
    		handler.addobject(dtc);
    		dtc= new dantuychinh(x+30, y+3, handler, -2, 8);
    		handler.addobject(dtc);
    		choban=20;
    		mp.usemp(25);
    	}
    }
    public void x_on(){
    	if(mp.getmp()>400)
    	giap=true;
    }
    public void x_off(){
    	giap=false;
    }
}
