import java.awt.Color;
import java.awt.Graphics;
import java.awt.*;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
public class GameOver{
    int age; //object age
    public GameOver(){ 
    }
    public void draw(Graphics g, int points){
        Font font = new Font("Bank Gothic", Font.BOLD, 50);//declaring the font type
        if(g instanceof Graphics2D){//used for displaying the title with large text
            Graphics2D g2d = (Graphics2D)g;
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2d.setFont(font);
            g.setColor(Color.RED);
            g.drawString("GAME OVER", 95, 200);//draws gameover
            g.setColor(Color.YELLOW);
            g.drawString("POINTS: "+points, 125, 400);//draws points
        }
        age++;
    }
}