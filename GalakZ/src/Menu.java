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
import javax.swing.JApplet;
public class Menu{
    boolean isRun = false;
    String title;
    String Z;
    String start;
    int age = 0;//age of object
    public Menu(){   
        title = "GALAK";
        Z = "Z";
        start = "Press (Space) to begin!";
    }
    public void draw(Graphics g){ 
        Font font = new Font("Bank Gothic", Font.BOLD, 20);//declaring the font type
        if(g instanceof Graphics2D){//used for displaying the title with large text
            Graphics2D g2d = (Graphics2D)g;
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2d.setFont(font);
            g.setColor(Color.YELLOW);
            g.drawString(title, 215, 200);
            g.setColor(Color.RED);
            g.drawString(Z, 295, 200);
            g.setColor(Color.YELLOW);
            g.drawString(start, 150, 400);
        }
        age++;
    }
    public boolean spaceKeyPressed(){
        if (isRun == true){//sets menu to stop drawing once the player presses space
            return true;
        }
        else{
            return false;
        }
    }
    public void update(){//updates the title parameters to blank
        title = "";
        Z = "";
        start = "";
    }
}
