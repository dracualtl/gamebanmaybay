package for_enemy;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import Center.*;

public class dantuychinhenemy extends GameObject{
	int speed;
	ImageIcon anh = new ImageIcon("data/anh/dantce.png");
	public dantuychinhenemy(int x, int y, Handler h, int vx, int vy){
		super(x, y, ID.dan_enemy1);
		this.handler = h;
		this.velx=vx;
		this.vely=vy;
	}
	public Rectangle getbounds(){
        return new Rectangle(x,y,anh.getIconWidth(), anh.getIconHeight());
    }
	@Override
	public void tick() {
		y=y+vely;
		x=x+velx;
		if(y<=0||y>=Game.height-38) handler.removeobject(this);
	}
	@Override
	public void render(Graphics g) {
		g.drawImage(anh.getImage(), x, y, null);
	}
	
}
