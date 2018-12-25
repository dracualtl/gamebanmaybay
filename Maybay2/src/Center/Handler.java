/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Center;

import java.awt.Graphics;
import java.util.LinkedList;

/**
 *
 * @author dell
 */
public class Handler {//maintain,update,render  all object in game
    
    LinkedList<GameObject> object=new LinkedList<GameObject>();
    
    public void tick(){
        for(int i=0;i<object.size();i++){
            GameObject tempobject=object.get(i);
            
            tempobject.tick();//ham tick cua gameobject
        }
    }
    
    public void render(Graphics g){
        for(int i=0;i<object.size();i++){
            GameObject tempobject=object.get(i);
            
            tempobject.render(g);//ham render cua gameobject
        }
    }
    
    public void addobject(GameObject object){
        this.object.add(object);//them mot object vao linkedlist
    }
    
    public void removeobject(GameObject object){
        this.object.remove(object);//them mot object vao linkedlist
    }
    public LinkedList<GameObject> getobject(){
		return object;
    }
}
