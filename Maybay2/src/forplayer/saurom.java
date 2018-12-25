package forplayer;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Center.GameObject;
import Center.Handler;
import Center.ID;

public class saurom extends GameObject{
	ImageIcon anh= new ImageIcon("data/anh/saurom.png");
	public saurom(int x, int y, Handler h) {
		super(x, y, ID.saurom);
		this.handler =h;
		this.velx=0;
		this.vely=2;
	}

	@Override
	public void tick() {
		this.y=this.y-vely;
		this.x=this.x+velx;
		check();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(anh.getImage(), x, y, 10, 10, null);
	}

	@Override
	public Rectangle getbounds() {
		return new Rectangle(x, y, 10,10);
	}
	public void check(){
		GameObject e = null;
		for(int i=0;i<handler.getobject().size();i++){
            GameObject tempobject=handler.getobject().get(i);
            if(tempobject.getid()== ID.enemy1 || tempobject.getid()== ID.enemy2 || tempobject.getid()==ID.Boss){
            	if(tempobject.gety()<y && (tempobject.gety() + tempobject.getbounds().getHeight()) >y ){
            		e=tempobject;
            		this.vely=0;
            		break;
            	}
            }
		}
		if(e!=null){
			if(e.getx()>x) this.velx=2;
			else if(e.getx()<x) this.velx=-2;
			else this.velx=0;
		}
	}

}
