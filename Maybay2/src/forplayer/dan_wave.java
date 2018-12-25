package forplayer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import Center.*;

public class dan_wave extends GameObject{
	ImageIcon anh = new ImageIcon("data/anh/lua.png");
	int w, maxw, tt;
	public dan_wave(int x, int y, Handler h){
		super(x, y, ID.dan_wave);
		this.handler = h;
		tt=75;
		maxw=300;
		w=0;
	}
	public Rectangle getbounds(){
        return new Rectangle(x, y, w, anh.getIconHeight());
    }
	@Override
	public void tick() {
		y=y-5;
		if(w<maxw) {w=w+4; x=x-2;}
		tt=tt-1;
		if(tt<0) handler.removeobject(this);
	}
	@Override
	public void render(Graphics g) {
		g.drawImage(anh.getImage(), x, y, w, anh.getIconHeight(), null);
	}
}
