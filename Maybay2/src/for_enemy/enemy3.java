package for_enemy;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.time.temporal.TemporalAmount;

import javax.swing.ImageIcon;

import Center.*;
import Interface.plane;
import for_use.Vuno;
import for_use.Vuno2;
import forplayer.tenlualenthang;

public class enemy3 extends GameObject implements plane{
	private int choban=50;
	private int tt=30;
	private int hp=100;
	private int they, waill, vel;
	private dantuychinhenemy dan;
	ImageIcon anh = new ImageIcon("data/anh/E2.png");
	public enemy3(int x, int y, Handler han, int ty, int wailin,int vel1,int vel2) {
		super(x, y, ID.enemy2);
		handler= han;
		this.velx=0;
		this.vely=vel1;
		this.they = ty;
		this.waill=wailin;
		this.vel=vel2;
	}

	@Override
	public void tick() {
		x=x+velx;
		if(this.y>they) this.vely=0;
		else waill=waill-1;
		y=y+vely;
		if(waill<0) this.vely=vel;
		if(x<-800 || x> Game.width+750 || y>Game.height+1000 ||y<-1000) this.handler.removeobject(this);
		if(choban!=0) choban=choban-1;
		if(choban==0){
			if(tt==30 || tt==20 || tt==10) {ban(); tt=tt-1;}
			else tt=tt-1;
			if(tt==0){ choban=50; tt=30;};
		}
		if(hp<=0){
			this.handler.addobject(new Vuno2(x, y, handler));
			this.handler.removeobject(this);
		}
		collision();
	    //System.out.println("consong");
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(anh.getImage(), this.x, this.y, 75, 50, null);
		//g.drawRect(x, y, 75, 75);
	}

	@Override
	public Rectangle getbounds() {
		return new Rectangle(this.x, this.y, 75, 60);
	}
	public void collision(){
        for(int i=0;i<handler.getobject().size();i++){
            GameObject tempobject=handler.getobject().get(i);
            if(tempobject.getid()==ID.laser){
            	if(getbounds().intersects(tempobject.getbounds())){//va cham
            		this.hp=hp-5;
            	}
            }
            
            if(tempobject.getid()==ID.dan_sm){
            	if(getbounds().intersects(tempobject.getbounds())){//va cham
            		this.hp=hp-5;
            		tempobject.setx(-100);
            	}
            }
            if(tempobject.getid()==ID.superlazer){
            	if(getbounds().intersects(tempobject.getbounds())){//va cham
            		this.hp=hp-40;
            		handler.removeobject(tempobject);
            	}
            }
            if(tempobject.getid()==ID.dan_tc){
            	if(getbounds().intersects(tempobject.getbounds())){//va cham
            		this.hp=hp-10;
            		handler.removeobject(tempobject);
            	}
            }
            if(tempobject.getid()==ID.saurom){
            	if(getbounds().intersects(tempobject.getbounds())){//va cham
            		this.hp=hp-2;
            		handler.removeobject(tempobject);
            	}
            }
            if(tempobject.getid()==ID.tenlualenthang){
            	if(getbounds().intersects(tempobject.getbounds())){//va cham
            		this.hp=hp-50;
            		tenlualenthang a = (tenlualenthang) tempobject;
            		a.huy();
            	}
            }
            if(tempobject.getid()==ID.hieuungno){
            	if(getbounds().intersects(tempobject.getbounds())){//va cham
            		this.hp=hp-1;
            	}
            }
        }
	}
	@Override
	public void setban(int e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ngungban() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ban() {
		dan = new dantuychinhenemy(x+32, y+60, handler, -3, 10);
		this.handler.addobject(dan);
		dan = new dantuychinhenemy(x+32, y+60, handler, +3, 10);
		this.handler.addobject(dan);
		dan = new dantuychinhenemy(x+32, y+60, handler, 0, 10);
		this.handler.addobject(dan);
	}
	

	@Override
	public void x_on() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void x_off() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doidan() {
		// TODO Auto-generated method stub
		
	}

}
