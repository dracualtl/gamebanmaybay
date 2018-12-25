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

public class bossE1 extends GameObject implements plane{
	private int choban=200;
	private int hp=10000;
	HUD mauboss = new HUD(500, 200, 20);
	private int they;
	private dan_enemy1 dan;
	private dantuychinhenemy dantc;
	private enemylazer_redy laz;
	ImageIcon anh = new ImageIcon("data/anh/BE1.png");
	public bossE1(int x, int y, ID id, Handler han, int ty) {
		super(x, y, id.Boss);
		handler= han;
		this.velx=0;
		this.vely=2;
		this.they = ty;
	}

	@Override
	public void tick() {
		mauboss.sethp(hp/20);
		choban=choban-1;
		if(choban==0) choban=200;
		if(hp>4000) bankieu1();
		else bankieu2();
		if(this.y>they) this.vely=0;
		//else this.theomuctieu();
		x=x+velx;
		y=y+vely;
		
		if(hp<=0){
			this.handler.addobject(new Vuno2(x, y, handler));
			this.handler.removeobject(this);
		}
		if(x<-100 || x> Game.width+75) this.handler.removeobject(this);
		collision();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(anh.getImage(), this.x, this.y, null);
		mauboss.render(g);
		//g.drawRect(x, y, 75, 75);
	}

	@Override
	public Rectangle getbounds() {
		return new Rectangle(this.x, this.y, anh.getIconWidth(), anh.getIconHeight());
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
            if(tempobject.getid()==ID.dan_tc){
            	if(getbounds().intersects(tempobject.getbounds())){//va cham
            		this.hp=hp-10;
            		handler.removeobject(tempobject);
            	}
            }
            if(tempobject.getid()==ID.superlazer){
            	if(getbounds().intersects(tempobject.getbounds())){//va cham
            		this.hp=hp-40;
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
	}
	public void bankieu1(){
		if(choban%10==0){
			int danvelx=((int)(Math.random()*99))/5;
			int dau = ((int)(Math.random()*99))/50;
			if(dau==0) danvelx=-danvelx;
			dantc = new dantuychinhenemy(x, y+50, handler, danvelx, 5);
			this.handler.addobject(dantc);
			dantc = new dantuychinhenemy(x+140, y+50, handler, -danvelx, 5);
			this.handler.addobject(dantc);
			dan = new dan_enemy1(x+60, y+60, handler);
			this.handler.addobject(dan);
			dan = new dan_enemy1(x+85, y+60, handler);
			this.handler.addobject(dan);
		}
	}
	public void bankieu2(){
		if(choban>100) theomuctieu();
		if(choban<100) this.velx=0;
		if(choban%5==0 && choban <=100){
			dan = new dan_enemy1(x+5, y+60, handler);
			this.handler.addobject(dan);
			dan = new dan_enemy1(x+140, y+60, handler);
			this.handler.addobject(dan);
		}
		if(choban==100){
			laz= new enemylazer_redy(x+52, y+60, ID.nonobject, handler);
			this.handler.addobject(laz);
		}
	}
	public void theomuctieu(){
		for(int i=0;i<handler.getobject().size();i++){
            GameObject tempobject=handler.getobject().get(i);
            if(tempobject.getid()==ID.player){
            	if(this.x<tempobject.getx()-30) this.velx=+3;
            	else if(this.x>tempobject.getx()+-30) this.velx=-3;
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
