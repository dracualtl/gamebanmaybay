package for_use;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Center.GameObject;
import Center.Handler;
import Center.ID;

public class Vuno2 extends GameObject{
	int tontai=33;
	int a=1;
	ImageIcon anh = new ImageIcon("data/animation/bum1.png");
	public Vuno2(int x, int y, Handler h) {
		super(x, y, ID.nonobject);
		this.handler =h;
	}

	@Override
	public void tick() {
		tontai=tontai-1;
		this.y= this.y+5;
		if(tontai%3==0) changeanh();
		if(tontai<0) this.handler.removeobject(this);
	}

	private void changeanh() {
		switch(a){
		case 1: anh = new ImageIcon("data/animation/bum2.png"); break;
		case 2: anh = new ImageIcon("data/animation/bum3.png"); break;
		case 3: anh = new ImageIcon("data/animation/bum4.png"); break;
		case 4: anh = new ImageIcon("data/animation/bum5.png"); break;
		case 5: anh = new ImageIcon("data/animation/bum6.png"); break;
		case 6: anh = new ImageIcon("data/animation/bum7.png"); break;
		case 7: anh = new ImageIcon("data/animation/bum8.png"); break;
		case 8: anh = new ImageIcon("data/animation/bum9.png"); break;
		case 9: anh = new ImageIcon("data/animation/bum10.png"); break;
		case 10: anh = new ImageIcon("data/animation/bum11.png"); break;
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
