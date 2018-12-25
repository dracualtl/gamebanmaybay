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

public class enemy2 extends GameObject implements plane{
	private int choban=50;
	private int tt=30;
	private int hp=100;
	private int they;
	private dan_enemy1 dan;
	ImageIcon anh = new ImageIcon("data/anh/E2.png");
	public enemy2(int x, int y, ID id, Handler han, int ty) {
		super(x, y, id.enemy2);
		handler= han;
		this.velx=0;
		this.vely=2;
		this.they = ty;
	}

	@Override
	public void tick() {
		this.theomuctieu();
		x=x+velx;
		if(this.y>they) this.vely=0;
		y=y+vely;
		if(x<-1000 || x> Game.width+1000) this.handler.removeobject(this);
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
		dan= new dan_enemy1(x+32, y+60, handler);
		this.handler.addobject(dan);
	}
	
	public void theomuctieu(){
		for(int i=0;i<handler.getobject().size();i++){
            GameObject tempobject=handler.getobject().get(i);
            if(tempobject.getid()==ID.player){
            	if(this.x<tempobject.getx()-3) this.velx=+3;
            	else if(this.x>tempobject.getx()+3) this.velx=-3;
            	else this.velx=0;
            }
		}
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
