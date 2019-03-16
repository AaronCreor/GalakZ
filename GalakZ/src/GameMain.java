import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.*;
import java.awt.event.*;
/*
 * AUTHOR: Aaron
 * 
 * CONTACT INFORMATION: aaronmacleod123@gmail.com
 *
 * CREATION DATE: March 1, 2018
 *
 * PROBLEM STATEMENT: Simple collision based arcade game implemented object oriented design.
 *
 * PROGRAM DESCRIPTION: Space shooter game in which the player is tasked with killing
 *                      as many enemies as possible without losing all of their health,
 *                      enemies will fire back and move towards the player.
 *
 * RUN INSTRUCTIONS: The menu will open when you first run the program, press space to begin the game
 *                   Move to the left or right of the screen using the arrow keys
 *                   Fire at the enemies using the spacebar key
 *                   If an enemies missile hits you, you will lose 1 health points
 *                   If you reach 0 health points the game will end
 *                   If the enemy makes it to the bottom of the screen the game will end
 */
public class GameMain
extends Frame
implements KeyListener{
    Menu menu;//declares the opening menu
    public LoadGame instance; //declares the instance of the game
    int framecount;//frame count
    private int bufferWidth;
    private int bufferHeight;
    private Image bufferImage;
    private Graphics bufferGraphics;
    boolean toggle = false;
    public GameMain(){
        setSize(500, 700);//screen size
        addWindowListener(new WindowAdapter() 
        {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        }
        );
        menu = new Menu();
        instance = new LoadGame();
        addKeyListener(this);
        setBackground(Color.BLACK);//sets background colour
        setResizable(false);//Makes game not resizable
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//Gets the users screen size
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
    public void paint(Graphics g) {
        if(bufferWidth!=getSize().width ||
            bufferHeight!=getSize().height ||
            bufferImage==null || bufferGraphics==null)
            resetBuffer();
        if(bufferGraphics!=null){
            //this clears the offscreen image, not the onscreen one
            bufferGraphics.clearRect(0,0,bufferWidth,bufferHeight);
            paintBuffer(bufferGraphics);
            g.drawImage(bufferImage,0,0,this);
            } 
    }
    public void paintBuffer(Graphics g){//double buffer prevents most flashing
        menu.draw(g);//draws menu
        if(menu.isRun == true){//prevents game from progressing without menu being cleared.
            instance.draw(g);
        }
        framecount++;//progresses frame count
    }
    private void resetBuffer(){//clears the double buffer for new buffer to be drawn
        bufferWidth=getSize().width;
        bufferHeight=getSize().height;
        if(bufferGraphics!=null){
            bufferGraphics.dispose();
            bufferGraphics=null;
        }
        if(bufferImage!=null){
            bufferImage.flush();
            bufferImage=null;
        }
        System.gc();
        bufferImage=createImage(bufferWidth,bufferHeight);
        bufferGraphics=bufferImage.getGraphics();
    }
    public void paintComponent(Graphics g) {        
    }
    public void updateFrame(){
        instance.updateFrame();//updates instance
    }
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 32){ //spacekey
            if (menu.isRun == true){ //Checks if menu is active or not
                if (framecount > 10){ //Prevents too many missiles
                    instance.player.spaceKeyPressed();
                    framecount = 0;
                }
            }
            menu.isRun = true; //sets menu to inactive
            if (toggle != true){//prevents reopening game after a game over
                if (menu.spaceKeyPressed()){
                    instance.CanRun = true; //loads game
                    toggle = true;
                    menu.update();//updates menu
                }
            }
        }
        if (e.getKeyCode() == 39) instance.player.rightKeyPressed();//right key moves player right
        if (e.getKeyCode() == 37) instance.player.leftKeyPressed(); //left key moves player left
    }
    public void keyReleased(KeyEvent e) {
    }
    public void keyTyped(KeyEvent e) {
    }
    public static void main(String[] args) throws InterruptedException {
        GameMain win = new GameMain();
        win.setVisible(true);
        // make the main loop for framing the animation
        win.setIgnoreRepaint(true);
        //Stops flickering
        while (true) {
            // 1: show my frame
            win.repaint();
            // 2: delay of 50 msec
            Thread.sleep(20);
            // 3: update the frame
            win.updateFrame();   
        }
    }
}
