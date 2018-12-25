package for_enemy;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Center.GameObject;
import Center.Handler;
import Center.ID;

public class enemylazer_redy extends  GameObject {
	ImageIcon anh = new ImageIcon("data/anh/vongtron.png");
	int duongkinh = anh.getIconHeight();
	enemylaser laz;
	public enemylazer_redy(int x, int y, ID id, Handler h) {
		super(x, y, ID.nonobject);
		this.handler=h;
	}

	@Override
	public void tick() {
		duongkinh=duongkinh-2;
		x=x+1;
		y=y+1;
		if(duongkinh<=0){
			laz = new enemylaser(this.x-50, this.y-20, ID.superlazer, this.handler);
			this.handler.addobject(laz);
			this.handler.removeobject(this);
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(anh.getImage(), x, y, duongkinh, duongkinh, null);
	}

	@Override
	public Rectangle getbounds() {
		return null;
	}

}
