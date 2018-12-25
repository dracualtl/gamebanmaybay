package for_enemy;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Center.GameObject;
import Center.Handler;
import Center.ID;

public class enemylaser extends GameObject {
	ImageIcon anh = new ImageIcon("data/anh/enemylaser.png");
	int wid= anh.getIconWidth()*2;
	tudiem t;
	public enemylaser(int x, int y, ID id, Handler h) {
		super(x, y, ID.elaser);
		this.handler=h;
		t=new tudiem(x+25, y, handler);
		this.handler.addobject(t);
	}

	@Override
	public void tick() {
		wid=wid-2;
		x=x+1;
		if(wid<=2){ 
			t.tuhuy();
			this.handler.removeobject(this);
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(anh.getImage(), x, y, wid ,700,  null);
	}

	@Override
	public Rectangle getbounds() {
		return new Rectangle(x, y, wid, 700);
	}

}
