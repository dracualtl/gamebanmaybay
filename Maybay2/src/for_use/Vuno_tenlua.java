package for_use;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Center.GameObject;
import Center.Handler;
import Center.ID;

public class Vuno_tenlua extends GameObject{
	int tontai=45;
	int a=1;
	int b=0;
	String c;
	ImageIcon anh = new ImageIcon("data/animation/tlno/tln-3.png");
	public Vuno_tenlua(int x, int y, Handler h) {
		super(x-15, y-25, ID.hieuungno);
		this.handler =h;
		b= ((int) ((Math.random()*99)))/25 +1;
		switch(b){
		case 1: c="a"; break;
		case 2: c="b"; break;
		case 3: c="c"; break;
		case 4: c="d"; break;
		}
	}

	@Override
	public void tick() {
		tontai=tontai-1;
		if(tontai%3==0) changeanh();
		if(tontai<0) this.handler.removeobject(this);
	}

	private void changeanh() {
		switch(a){
		case 1: anh = new ImageIcon("data/animation/tlno/tln-3.png"); break;
		case 2: anh = new ImageIcon("data/animation/tlno/tln-2.png"); break;
		case 3: anh = new ImageIcon("data/animation/tlno/tln-1.png"); break;
		case 4: anh = new ImageIcon("data/animation/tlno/tln0.png"); break;
		case 5: anh = new ImageIcon("data/animation/tlno/tln1.png"); break;
		case 6: anh = new ImageIcon("data/animation/tlno/tln2" + c + ".png"); break;
		case 7: anh = new ImageIcon("data/animation/tlno/tln3" + c + ".png"); break;
		case 8: anh = new ImageIcon("data/animation/tlno/tln4" + c + ".png"); break;
		case 9: anh = new ImageIcon("data/animation/tlno/tln5" + c + ".png"); break;
		case 10: anh = new ImageIcon("data/animation/tlno/tln6" + c + ".png"); break;
		case 11: anh = new ImageIcon("data/animation/tlno/tln7" + c + ".png"); break;
		case 12: anh = new ImageIcon("data/animation/tlno/tln8" + c + ".png"); break;
		case 13: anh = new ImageIcon("data/animation/tlno/tln9" + c + ".png"); break;
		case 14: anh = new ImageIcon("data/animation/tlno/tln10.png"); break;
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
		return new Rectangle(x, y, anh.getIconWidth(), anh.getIconHeight());
	}

}
