package forplayer;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Center.GameObject;
import Center.Handler;
import Center.ID;

public class Giap extends GameObject{
	int hien=1;
	ImageIcon anh = new ImageIcon("data/anh/Giap1.png");
	public Giap(int x, int y, ID id, Handler h) {
		super(x, y, id);
		this.handler = h;
	}

	@Override
	public void tick() {
		if(hien>0) hien=hien-1;
		else handler.removeobject(this);
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(anh.getImage(), x-20, y-20,125, 125, null);
	}

	@Override
	public Rectangle getbounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x-20, y-20, 125, 125);
	}

}
