/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Center;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

import javax.swing.ImageIcon;

import for_enemy.enemy1;
import for_use.map1;
import for_enemy.*;
import forplayer.*;
/**
 *
 * @author dell
 */
public class Game extends Canvas implements Runnable {
    
    public static final int width=920,height=width/12*9;
    
    private Thread thread;
    private boolean running=false;
    private Random r;
    private Handler handler;
    map1 map;
    private ImageIcon anh = new ImageIcon("data/anh/Sky.png");
    public Game(){
        r=new Random();
        handler=new Handler();
        //hud2= new HUD(100, 2,400,15);
        this.addKeyListener(new KeyInput(handler));
        //this.addKeyListener(new KeyInput(handler));//them keyinput // goi ham xay dung cua keyinput
        
        new window(width,height,"mau",this);//this=the hien o ham main
        map=new map1(handler);
        map.themnguoichoi(1, new player2(400, 500, ID.player, handler, 2, 1));
        map.themnguoichoi(1, new player2(400, 500, ID.player2, handler, 4, 2));
        handler.addobject(map);
        /*handler.addobject(new player2(400,250,ID.player,handler, 3, 1));
        handler.addobject(new enemy1(400, 100, ID.enemy1, handler, 5, 0));
        handler.addobject(new bossE1(400, 0, ID.enemy2, handler, 100));*/
    }

    public synchronized void start(){
        thread=new Thread(this);
        thread.start();
        running=true;
    }
    
    public synchronized void stop(){
        try{
            thread.join();//kill thread
            running=false;
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    // start method CALL run method??
    public void run(){//some kind of game load??
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running)
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >=1)
            {
                tick();
                delta--;
            }
            if(running)
                render();
            frames++;
                            
            if(System.currentTimeMillis() - timer > 1000)
            {
                timer += 1000;
                //System.out.println("FPS: "+ frames);
                frames = 0;
            }
        }
        stop();
    }
        
    private void tick(){
        handler.tick();//tick cua Handler
        //hud2.tick();
    }
    
    private void render(){
        BufferStrategy bs=this.getBufferStrategy();//lay so buffer dang co??
        if(bs == null){
            this.createBufferStrategy(3);//tao 3 buffer
            return;
        }
        Graphics g=bs.getDrawGraphics(); //create graphics context for drawing buffer
        //g.setColor(Color.black);
        g.drawImage(anh.getImage(), 0, 0, width, height, null);
        
        handler.render(g);
        //hud2.render(g);
        
        g.dispose();
        bs.show();//make the next available
    }
    
    public static int clam(int var,int min,int max){ //set bound cho object
        if(var>=max) return var=max;
        else if(var<=min) return var=min;
        else return var;
    }
    
    public static void main(String[] args) {
        new Game();//tao mot the hien
    }
    
}
