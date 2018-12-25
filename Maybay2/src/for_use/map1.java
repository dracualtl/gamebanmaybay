package for_use;

import java.awt.Graphics;
import java.awt.Rectangle;

import Center.Game;
import Center.GameObject;
import Center.Handler;
import Center.ID;
import Interface.plane;
import for_enemy.bossE1;
import for_enemy.enemy1;
import for_enemy.enemy2;
import for_enemy.enemy3;

public class map1 extends GameObject{
	GameObject[] nguoichoi = new GameObject[4];
	enemy1 e1;
	enemy2 e2;
	enemy3 e3;
	bossE1 boss;
	int t=0;
	public map1(Handler h) {
		super(0, 0, ID.nonobject);
		this.handler=h;
	}
	public void themnguoichoi(int i, GameObject xl){
		nguoichoi[i-1]=xl;
		this.handler.addobject(nguoichoi[i-1]);
	}
	@Override
	public void tick() {
		t=t+1;
		System.out.println(t+"\n");
		if(t==150){
			for(int i=1; i<=10; i++){
				e1=new enemy1(0-i*80, 300, ID.enemy1, handler, 5, 0);
				this.handler.addobject(e1);
			}
			for(int i=1; i<=10; i++){
				e1=new enemy1(Game.width+i*80, 100, ID.enemy1, handler, -5, 0);
				this.handler.addobject(e1);
			}
		}
		if(t==800){
			for(int i=1; i<=10; i++){
				e1=new enemy1(0-i*80, 0-i*80, ID.enemy1, handler, 15, 10);
				this.handler.addobject(e1);
			}
			for(int i=1; i<=10; i++){
				e1=new enemy1(Game.width+i*80, 0-i*80, ID.enemy1, handler, -15, 10);
				this.handler.addobject(e1);
			}
		}
	}

	@Override
	public void render(Graphics g) {
		
	}

	@Override
	public Rectangle getbounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
