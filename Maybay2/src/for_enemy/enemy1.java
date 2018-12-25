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

public class enemy1 extends GameObject implements plane{
	private int choban=50;
	private int hp=25;
	private dan_enemy1 dan;
	ImageIcon anh = new ImageIcon("data/anh/E1.png");
	public enemy1(int x, int y, ID id, Handler han, int vx, int vy) {
		super(x, y, id.enemy1);
		handler= han;
		this.velx=vx;
		this.vely=vy;
	}

	@Override
	public void tick() {
		x=x+velx;
		y=y+vely;
		choban=choban-1;
		if(choban==0){
			ban();
			choban=50;
		}
		if(hp<=0) {
			this.handler.addobject(new Vuno2(x, y, handler));
			handler.removeobject(this);
		}
		if(x<-1000 || x> Game.width+1000 || y>Game.height+1000 || y<-1000) this.handler.removeobject(this);
		collision();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(anh.getImage(), this.x, this.y, 75, 75, null);
		//g.drawRect(x, y, 75, 75);
	}

	@Override
	public Rectangle getbounds() {
		return new Rectangle(this.x, this.y, 60, 60);
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
            		handler.removeobject(tempobject);
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
		dan= new dan_enemy1(x+32, y+60, handler);
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
