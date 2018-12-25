package forplayer;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Center.GameObject;
import Center.Handler;
import Center.ID;
import for_use.Vuno_tenlua;
import for_use.duoilua;

public class tenlualenthang extends GameObject{
	ImageIcon anh = new ImageIcon("data/anh/tenlua.png");
	int tieplua=9;
	public tenlualenthang(int x, int y, Handler h) {
		super(x, y, ID.tenlualenthang);
		this.handler=h;
		this.vely=0;
	}

	@Override
	public void tick() {
		tieplua=tieplua-1;
		this.y=this.y-vely;
		vely=vely+1;
		if(tieplua<=0) this.handler.addobject(new duoilua(x-88, y+40, handler));
		if(this.y<-anh.getIconHeight()){
			handler.removeobject(this);
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(anh.getImage(), x, y,20, 35, null);
	}

	@Override
	public Rectangle getbounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x, y, 20, 35);
	}
	public void huy(){
		this.handler.addobject(new Vuno_tenlua(x, y, handler));
		this.handler.removeobject(this);
	}
}
