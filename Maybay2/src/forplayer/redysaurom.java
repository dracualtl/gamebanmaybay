package forplayer;

import java.awt.Graphics;
import java.awt.Rectangle;

import Center.GameObject;
import Center.Handler;
import Center.ID;

public class redysaurom extends GameObject{
	int time=25;
	saurom a;
	public redysaurom(int x, int y, Handler h) {
		super(x, y, ID.nonobject);
		this.handler= h;
	}

	@Override
	public void tick() {
		time=time-1;
		a = new saurom(x, y, handler);
		this.handler.addobject(a);
		if(time<=0) this.handler.removeobject(a);
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rectangle getbounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
