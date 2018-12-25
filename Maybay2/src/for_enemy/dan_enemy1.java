package for_enemy;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import Center.*;

public class dan_enemy1 extends GameObject{
	int speed;
	ImageIcon anh = new ImageIcon("data/anh/dan2.png");
	public dan_enemy1(int x, int y, Handler h){
		super(x, y, ID.dan_enemy1);
		this.handler = h;
		this.x=x;
		this.y=y;
		this.speed = 10;
	}
	public Rectangle getbounds(){
        return new Rectangle(x,y,anh.getIconWidth(), anh.getIconHeight());
    }
	@Override
	public void tick() {
		y=y+speed;
		if(y<=0||y>=Game.height-38) handler.removeobject(this);
	}
	@Override
	public void render(Graphics g) {
		g.drawImage(anh.getImage(), x, y, null);
	}
	
}
