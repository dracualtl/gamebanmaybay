package for_use;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Center.GameObject;
import Center.Handler;
import Center.ID;

public class duoilua extends GameObject{
	int tontai=6;
	int a=1;
	ImageIcon anh = new ImageIcon("data/animation/d3.png");
	public duoilua(int x, int y, Handler h) {
		super(x, y, ID.nonobject);
		this.handler =h;
	}

	@Override
	public void tick() {
		tontai=tontai-1;
		if(tontai%2==0) changeanh();
		if(tontai<0) this.handler.removeobject(this);
	}

	private void changeanh() {
		switch(a){
		case 1: anh = new ImageIcon("data/animation/d1-a.png");break;
		case 2: anh = new ImageIcon("data/animation/d1-b.png");break;
		}
		a=a+1;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(anh.getImage(), x, y, null);
	}

	@Override
	public Rectangle getbounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
