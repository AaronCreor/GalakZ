import java.awt.Color;
import java.awt.Graphics;
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