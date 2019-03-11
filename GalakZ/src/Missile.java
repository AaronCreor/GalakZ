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
public class Missile{
    int x; //x pos
    int y; //y pos
    int age = 0;//object age
    public Missile(int missilex, int missiley){//gains starting position from player location
        x = missilex;
        y = missiley;
    }
    public void draw(Graphics g){
        g.setColor(Color.YELLOW);
        if(!(y < 125)){ // Make sure missile doesn't overlap UI
            g.fillRect (x, y, 3, 15); //Draws missile
            for(int i = 0; i < 5; i++){
                y--; //Moves missile up screen
            }
        }
        age++;//increments object age
    }  
}