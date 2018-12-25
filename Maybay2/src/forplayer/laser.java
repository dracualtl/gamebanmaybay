package forplayer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Center.Game;
import Center.GameObject;
import Center.Handler;
import Center.ID;

public class laser extends GameObject{
	int hien=5;
	ImageIcon anh = new ImageIcon("data/anh/dancx.png");
	public laser(int x, int y, Handler h) {
		super(x, y, ID.laser);
		this.handler = h;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		if(hien>0) hien=hien-1;
		if(hien==0) handler.removeobject(this);
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(anh.getImage(), x, y - Game.height, anh.getIconWidth(), Game.height, null);
	}

	@Override
	public Rectangle getbounds() {
		return new Rectangle(x, y - Game.height, anh.getIconWidth(), Game.height);
	}

}
