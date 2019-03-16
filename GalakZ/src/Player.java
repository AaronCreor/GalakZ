import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
public class Player{
    int Health; //Player health
    int xpoints[] = {240, 250, 260}; //Dimensions for player model
    int ypoints[] = {525, 500, 525};
    int npoints = 3;
    public ArrayList <Missile> missile;
    int age = 0;
    public Player(){
        Health = 5;//player health
        missile = new ArrayList<Missile>();
    }
    public void draw(Graphics g){//draws player
        g.setColor(Color.green);
        g.fillPolygon(xpoints, ypoints, npoints);
        for(int i=0; i < missile.size(); i++){
            missile.get(i).draw(g);//draws friendly missiles
        }
        age++;//increments object age
        destroyer();//removes old missiles
    }
    public void destroyer(){ //Removes old missiles
        for(int i=0; i < missile.size(); i++){
            if(missile.get(i).y < 125){
                missile.remove(i);
            }
        }
    }
    public void leftKeyPressed(){//moves player left
        if(xpoints[0] >= 25){//prevents movement off screen
            xpoints[0] = xpoints[0] -10;
            xpoints[1] = xpoints[1] -10;
            xpoints[2] = xpoints[2] -10;
        }
    }
    public void rightKeyPressed(){//moves player right
        if(xpoints[0] <= 450){//prevents movement off screen
            xpoints[0] = xpoints[0] +10;
            xpoints[1] = xpoints[1] +10;
            xpoints[2] = xpoints[2] +10;
        }
    }
    public void spaceKeyPressed() {//fires missile
        Missile temp;
        temp = new Missile(xpoints[1], ypoints[1]);
        missile.add(temp);
    }     
}