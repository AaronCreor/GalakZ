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
public class UserInterface{
    int Health;//Players current displayed health
    int age;//age of instance
    public UserInterface(){
        Health = 5;
    }
    public void drawText(Graphics g){//draws the text based UI elements
        g.setColor(Color.BLUE);
        g.fillRect(0, 600, 1000, 200);
        g.fillRect(0, 0, 1000, 120);
        g.setColor(Color.RED);
        g.drawString("Health", 30, 625);
        g.setColor(Color.YELLOW);
        g.drawString("GALAK", 210, 75);
        g.drawString("Space = Shoot", 300, 625);
        g.drawString("Arrow Keys = Move", 300, 650);
        g.setColor(Color.RED);
        g.drawString("Z", 290, 75); 
    }
    public void draw(Graphics g, int points){
        drawText(g);
        g.setColor(Color.YELLOW);
        g.drawString("Points: "+ points, 300, 675);//draws the point counter
        g.setColor(Color.RED);
        if(Health >= 5){//draws the different levels of health
            g.fillRect(25, 650, 10, 10);
        }
        if(Health >= 4){
            g.fillRect(40, 650, 10, 10);
        }
        if(Health >= 3){
            g.fillRect(55, 650, 10, 10);
        } 
        if(Health >= 2){
            g.fillRect(70, 650, 10, 10);
        }
        if(Health >= 1){
            g.fillRect(85, 650, 10, 10);
        }
        age++;
    }
}