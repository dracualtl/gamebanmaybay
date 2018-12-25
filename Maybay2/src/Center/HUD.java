/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Center;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author dell
 */
public class HUD {
    
    //public static int hp=100;
    
    private int hp, maxhp;
    private int x, y;
    
    public HUD(int hp,int x,int y){
        this.hp=hp;
        this.maxhp=hp;
        this.x=x;
        this.y=y;
    }
    
    public void tick(){
        //hp--;
        //hp-=damage;
        
        Game.clam(hp, 0, 100);
    }
    
    public void render(Graphics g){
        g.setColor(Color.gray);
        g.fillRect(x, y, maxhp, 10);
        g.setColor(Color.green);
        g.fillRect(x, y, hp, 10);
        g.setColor(Color.white);
        g.drawRect(x, y, maxhp, 10);
    }
    
    public int gethp(){
    	return hp;
    }
    public void damage(int k){
        hp-=k;
    }
    public void sethp(int h){
    	this.hp=h;
    }
}
