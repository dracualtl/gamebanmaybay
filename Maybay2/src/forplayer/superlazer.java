package forplayer;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Center.GameObject;
import Center.Handler;
import Center.ID;

public class superlazer extends GameObject {
	ImageIcon anh = new ImageIcon("data/anh/superlazer.png");
	public superlazer(int x, int y, ID id, Handler h) {
		super(x, y+50, ID.superlazer);
		this.handler=h;
	}

	@Override
	public void tick() {
		this.y=this.y-150;
		if(this.y<-1000) this.handler.removeobject(this);
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(anh.getImage(), x, y, 60, 150, null);
	}

	@Override
	public Rectangle getbounds() {
		return new Rectangle(x, y, 60, 150);
	}

}
