import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.io.PrintStream;
import java.util.Scanner;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.util.Random;
public class BadGuy{
    boolean alive;
    int variance = random();
    int xpoints[] = {240+variance, 250+variance, 260+variance}; //Dimensions for enemy model
    int ypoints[] = {150, 175, 150};
    int npoints = 3;
    int framecount = 0;//checks frame since last moves down
    int shootcount = 0;//time since last shot
    int age = 1;//age
    boolean position; //determines direction
    public ArrayList <BadMissile> badmissile;
    boolean islose = false;//checks if player should lose
    public BadGuy(){
        alive = true;
        badmissile = new ArrayList<BadMissile>();
    }
    public void draw(Graphics g){
        if(alive == true){//draws enemy, only if alive
            g.setColor(Color.red);  
            g.fillPolygon(xpoints, ypoints, npoints); //draws the enemy
            shoot();//calls shoot function
        }
        for(int i=0; i < badmissile.size(); i++){//draws the missiles that the enemy shoots
            badmissile.get(i).draw(g);
        }
        shootcount++;//used to determine when the enemy should shoot
    }
    public void shoot(){//checks if should shoot
        if(shootcount > 50){
            BadMissile temp;
            temp = new BadMissile(xpoints[1], ypoints[1]);
            badmissile.add(temp);
            destroyer();//removes old missiles
            shootcount = 0;
        }
    }
    public void destroyer(){ //Removes old missiles
        for(int i=0; i < badmissile.size(); i++){
            if(badmissile.get(i).age == 0){
                badmissile.remove(i);    
            }
        }
    }
    public int random(){//gets a random number so the enemy spawns at a random x cord
        Random rand = new Random();
        int temp;
        temp = rand.nextInt(400)+(rand.nextInt(200)*-2);
        return temp;
    }
    public void updateFrame(){
        age++;//object age
        framecount++;//used to determine when the enemy should move down the y axis
        if(alive == false){//exits if enemy is dead
            return;
        }
        if(framecount >= 120){//moves the enemy down towards the player on the y axis
            if(ypoints[0] < 475){//prevents enemy from moving into ui, also ends game
                framecount = 0;
                ypoints[0] = ypoints[0] + 30;
                ypoints[1] = ypoints[1] + 30;
                ypoints[2] = ypoints[2] + 30;
            }
            else{
                alive = false;//flags enemy for deletion
                islose = true;
            }
        }
        if(xpoints[0] <= 10){//determines direction
            position = true;
            xpoints[0] = xpoints[0] +5;
            xpoints[1] = xpoints[1] +5;
            xpoints[2] = xpoints[2] +5;
            return;
        }
        if(xpoints[0] >= 475){//determines direction
            position = false;
            xpoints[0] = xpoints[0] -5;
            xpoints[1] = xpoints[1] -5;
            xpoints[2] = xpoints[2] -5;
            return;
        }
        if(position == true){//moves enemy
            xpoints[0] = xpoints[0] +5;
            xpoints[1] = xpoints[1] +5;
            xpoints[2] = xpoints[2] +5;
            return;
        }
        if(position == false){//moves enemy
            xpoints[0] = xpoints[0] -5;
            xpoints[1] = xpoints[1] -5;
            xpoints[2] = xpoints[2] -5;
            return;
        }
    }
}