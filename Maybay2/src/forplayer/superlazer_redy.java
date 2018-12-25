package forplayer;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Center.GameObject;
import Center.Handler;
import Center.ID;

public class superlazer_redy extends  GameObject {
	ImageIcon anh = new ImageIcon("data/anh/super lazer-redy.png");
	int t=3;
	superlazer laz;
	public superlazer_redy(int x, int y, ID id, Handler h) {
		super(x, y, ID.superlazer);
		this.handler=h;
	}

	@Override
	public void tick() {
		t=t-1;
		if(t<=0){
			laz = new superlazer(this.x, this.y, ID.superlazer, this.handler);
			this.handler.addobject(laz);
			this.handler.removeobject(this);
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(anh.getImage(), x, y, null);
	}

	@Override
	public Rectangle getbounds() {
		return new Rectangle(x, y, anh.getIconWidth(), anh.getIconHeight());
	}

}
