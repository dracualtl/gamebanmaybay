package forplayer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import Center.*;

public class dan_sm extends GameObject{
	int speed;
	ImageIcon anh = new ImageIcon("data/anh/dan.png");
	public dan_sm(int x, int y, Handler h){
		super(x, y, ID.dan_sm);
		this.handler = h;
		this.speed = 15;
	}
	public Rectangle getbounds(){
        return new Rectangle(x,y,anh.getIconWidth(), anh.getIconHeight());
    }
	@Override
	public void tick() {
		y=y-speed;
		if(y<=0||y>=Game.height-38) handler.removeobject(this);
	}
	@Override
	public void render(Graphics g) {
		g.drawImage(anh.getImage(), x, y, null);
	}
	
}
