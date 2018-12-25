package for_enemy;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Center.GameObject;
import Center.Handler;
import Center.ID;

public class tudiem extends GameObject{
	ImageIcon anh = new ImageIcon("data/anh/hinhtron.png");
	boolean het=false;
	int wi=anh.getIconWidth();
	public tudiem(int x, int y, Handler h) {
		super(x, y, ID.nonobject);
		this.handler=h;
	}

	@Override
	public void tick() {
		if(het==true){
			wi=wi-2;
			x=x+1;
			y=y+1;
		}
		if(wi<=2) this.handler.removeobject(this);
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(anh.getImage(), x, y,wi, wi, null);
	}

	@Override
	public Rectangle getbounds() {
		// TODO Auto-generated method stub
		return null;
	}
	public void tuhuy(){
		het=true;
	}
}
