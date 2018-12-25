package forplayer;
import java.awt.Color;
import java.awt.Graphics;

import Center.Game;

public class MPBar {
	 private int mp;
	 private int maxmp;
	 private int x, y;
	    
	 public MPBar(int mp,int x,int y){
	    this.mp=mp;
	    this.maxmp=mp;
	    this.x=x;
	    this.y=y;
	 }
	    
	 public void tick(){
		if(mp<maxmp) mp=mp+1;
	    Game.clam(mp, 0, 200);
	 }
	    
	 public void render(Graphics g){
	    g.setColor(Color.gray);
	    g.fillRect(x, y, maxmp/20, 10);
	    g.setColor(Color.BLUE);
	    g.fillRect(x, y, mp/20, 10);
	    g.setColor(Color.white);
	    g.drawRect(x, y, maxmp/20, 10);
	 }
	    
	public void setmp(int pre){
	    this.mp=pre;
	}
	public int getmp(){
		return this.mp;
	}
	public void usemp(int use){
		this.mp=this.mp-use;
	}
}
