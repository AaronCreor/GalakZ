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
public class LoadGame{
    boolean CanRun;//So instance only runs once menu is closed
    UserInterface ui;
    Player player;
    public ArrayList <BadGuy> enemy;
    int enemycheck = 99; //Checks if enemy should be drawn
    int points = 0; //Players amount of points
    int age = 0; //Age of object
    GameOver losestate;//Instance of GameOver
    boolean havelost = false;
    int difficulty = 0;
    boolean firstrun = true;//used to spawn extra enemies at start
    public LoadGame(){
        ui = new UserInterface();
        player = new Player();
        enemy = new ArrayList<BadGuy>();
        losestate = new GameOver();
    }
    public void draw(Graphics g){
        if(havelost == true){
            losestate.draw(g, points);
            return;
        }
        if(CanRun == true){//checks if menu was closed
            ui.draw(g, points);//draws the user interface
            player.draw(g);//draws the player model
            for(int i = 0; i < enemy.size(); i++){//draws the enemies
                enemy.get(i).draw(g);
            }
        }
        enemycheck++;//determines when a new enemy should be spawned (100 frames in this case)
        if(enemycheck > 100-difficulty){
            BadGuy temp;
            temp = new BadGuy();
            enemy.add(temp);
            enemycheck = 0;//resets the enemy counter
            checkDifficulty();
            if(firstrun == true){//spawns 2 enemies at the very start
                temp = new BadGuy();
                enemy.add(temp);   
                firstrun = false;
            }
        }
        isLose(g);//checks if you've lost
        destroyer();//destorys old objects
    }
    public void checkDifficulty(){//increases difficulty as game goes on
        if(difficulty < 50){
            difficulty=difficulty+5;
        }
    }
    public void isLose(Graphics g){//checks if you've lost
        for(int i = 0; i <enemy.size(); i++){
            if(enemy.get(i).islose == true){//checks if enemy made it to the end zone
                CanRun = false;
                havelost = true;
            }
        }
    }
    public void updateFrame(){
        age++;//progresses age of object
        for(int i = 0; i<enemy.size(); i++){
            enemy.get(i).updateFrame();//updates the frame of each individual enemy
        }
        isHit();//calls in isHit function 
        isPlayerHit();
    }
    public void isHit(){
        for(int i= 0; i<player.missile.size(); i++){//determines if enemy was hit
            for(int z = 0; z<enemy.size(); z++){
                if((player.missile.get(i).y < enemy.get(z).ypoints[1]+10 && player.missile.get(i).y > enemy.get(z).ypoints[1]-10) &&
                (player.missile.get(i).x < enemy.get(z).xpoints[1]+20 && player.missile.get(i).x > enemy.get(z).xpoints[1]-20) ){
                    if(enemy.get(z).alive != false){
                        enemy.get(z).alive = false;//changes enemy status to not alive if hit
                        player.missile.remove(i);//removes missile once it has hit
                        points++;//gives player a point
                        return;
                    }
                }
            }
        }   
    }
    public void isPlayerHit(){
        for(int z = 0; z<enemy.size(); z++){//determines if player was hit
            for(int i = 0; i<enemy.get(z).badmissile.size(); i++){
                if((enemy.get(z).badmissile.get(i).y < player.ypoints[1]+5 && enemy.get(z).badmissile.get(i).y > player.ypoints[1]-5) &&
                (enemy.get(z).badmissile.get(i).x < player.xpoints[1]+10 && enemy.get(z).badmissile.get(i).x >player.xpoints[1]-10) ){
                    enemy.get(z).badmissile.remove(i);//removes missile that struck player
                    ui.Health--;
                    if(ui.Health <= 0){//Brings up game over if you lose
                        CanRun = false;
                        havelost = true;
                    }
                }
            }
        }    
    }
    public void destroyer(){//demoves old enemies
        for(int i = 0; i<enemy.size(); i++){
            if(enemy.get(i).alive == false){
                enemy.remove(i);
            }
        }
    }
}