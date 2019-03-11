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
public class BadMissile{
    int x; //x pos
    int y; //y pos
    int age = 1;//object age
    public BadMissile(int missilex, int missiley){//starting position determines by the enemies starting position
        x = missilex;
        y = missiley;
    }
    public void draw(Graphics g){
        g.setColor(Color.PINK);
        if(y < 550){ // Make sure missile doesn't overlap UI
            g.fillRect (x, y, 3, 15); //Draws missile
            for(int i = 0; i < 2; i++){
                y++; //Moves missile up screen
                age++;//increments the objects age
            }
        }
        else{
            age = 0;
        }
    }
}