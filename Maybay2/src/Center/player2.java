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
public class player2 extends GameObject implements plane {
    
    //public Random r;
    private ImageIcon anh = new ImageIcon("data/anh/M22.png");
    private ImageIcon adan = new ImageIcon("data/anh/dan.png");
    private ImageIcon atenlua = new ImageIcon("data/anh/tenlua.png");
    private Handler handler;
    private HUD hud;
    private MPBar mp;
    private dan_sm dan;
    private redysaurom sr;
    private tenlualenthang tenlua;
    private superlazer_redy laz;
    private int bandan=0;
    private boolean btx=false;
    private int wail_x=2;
    private int sung=0;
    private int sungx=0;
    final int dan1=1;
    final int dan2=2;
    final int dan3=3;
    int sodan, sotenlua;
    private int dansudung=dan1;
    private int choban=0;
    private int chobansaurom=0;
    int ki;
    public player2(int x, int y, ID id,Handler handler, int style, int i) {
        super(x, y, id);
        this.handler=handler;
        sodan=3000;
        sotenlua=250;
        sung=(((int)(Math.random()*99))/50) +1;
        sungx=(((int)(Math.random()*99))/50) +1;
        switch(style){
        case 1: anh = new ImageIcon("data/anh/M21.png"); break;
        case 2: anh = new ImageIcon("data/anh/M22.png"); break;
        case 3: anh = new ImageIcon("data/anh/M23.png"); break;
        case 4: anh = new ImageIcon("data/anh/M24.png"); break;
        }
        ki=i-1;
        hud=new HUD(100,15,30 + (i-1)*60);
        mp= new MPBar(2000, 15, 45 + (i-1)*60);
    }
    
    public Rectangle getbounds(){
        return new Rectangle(x+30, y+20, 30, 60);
    }

    public void tick() {
        x+=velx;
        y+=vely;
        if(choban>0) choban=choban-1;
        if(wail_x>0) wail_x=wail_x-1;
        if(chobansaurom>0) chobansaurom= chobansaurom-1;
        x=Game.clam(x, 0, Game.width-90);
        y=Game.clam(y, 0, Game.height-90);
        if(bandan!=0 && choban==0) ban();
        if(wail_x==0 && btx==true && mp.getmp()>100){
        	fire_super_lazer();
        	wail_x=2;
        }
        if(hud.gethp()<=0){
        	this.handler.addobject(new Vuno2(x-35, y-20, handler));
        	handler.removeobject(this);
        }
        collision();
    }
    
    public void collision(){
        for(int i=0;i<handler.getobject().size();i++){
            GameObject tempobject=handler.object.get(i);
            
            if(tempobject.getid()==ID.enemy1){
                if(getbounds().intersects(tempobject.getbounds())){//va cham
                	hud.damage(25);
                	handler.removeobject(tempobject);
                }
            }
            if(tempobject.getid()==ID.dan_enemy1){
                if(getbounds().intersects(tempobject.getbounds())){//va cham
                	hud.damage(5);
                	handler.removeobject(tempobject);
                }
            }
            if(tempobject.getid()==ID.elaser){
                if(getbounds().intersects(tempobject.getbounds())){//va cham
                	hud.damage(1);
                }
            }
        }
    }
        

    public void render(Graphics g) {
        g.setColor(Color.white);
        //Graphics2D g2d=(Graphics2D) g;
        //if(id==ID.player2) g.setColor(Color.yellow);
        //g.fillRect(x, y, 32, 32);
        //g.drawRect(x+30, y+20, 30, 60);
        g.drawImage(anh.getImage(), x, y, null);
        g.drawImage(anh.getImage(), 15, 0+ki*60, 33, 30, null);
        g.drawImage(adan.getImage(), 60, 2+ki*60, null);
        g.drawImage(atenlua.getImage(), 120, 0+ki*60, null);
        g.setColor(Color.black);
        g.fillRect(75, 2+ki*60, 40, 25);
        g.fillRect(120, 30+ki*60, 40, 20);
        g.setColor(Color.white);
        g.setFont(new Font("Tahoma", 0, 14));
        g.drawString("X"+sodan, 75, 25+ki*60);
        g.drawString(""+sotenlua, 125, 45+ki*60);
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
    	if(bandan==dan1 && sodan>0){
    		dan= new dan_sm(x+41, y, handler);
    		handler.addobject(dan);
    		dan= new dan_sm(x, y+40, handler);
    		handler.addobject(dan);
    		dan= new dan_sm(x+82, y+40, handler);
    		handler.addobject(dan);
    		sodan=sodan-3;
    		choban=7;
        }
    	if(bandan==dan2 && sotenlua>0){
    		if(sung == 1){
    			tenlua = new tenlualenthang(x+10, y+20, handler);
    			sung=2;
    			sotenlua=sotenlua-1;
    		}
    		else if(sung == 2){
    			tenlua = new tenlualenthang(x+60, y+20, handler);
    			sung=1;
    			sotenlua=sotenlua-1;
    		}
    		this.handler.addobject(tenlua);
    		choban=20;
    	}
    	if(bandan==dan3 && chobansaurom==0){
    		sr= new redysaurom(x+40, y+3, handler);
    		handler.addobject(sr);
    		chobansaurom=200;
    	}
    }
    public void x_on(){
    	btx=true;
    }
    public void x_off(){
    	btx=false;
    }
    public void fire_super_lazer(){
    	if(sungx==1){
			laz = new superlazer_redy(x, y+20, ID.superlazer, handler);
			mp.usemp(40);
			sungx=2;}
		else if(sungx==2){
			laz = new superlazer_redy(x+30, y+20, ID.superlazer, handler);
			mp.usemp(40);
			sungx=1;}
    	handler.addobject(laz);
    }
}
