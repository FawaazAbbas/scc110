import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable{

    static final int GWIDTH = 1000;
    static final int GHEIGHT = (int)(GWIDTH * (0.5555));
    static final Dimension SCREENSIZE = new Dimension(GWIDTH, GHEIGHT);
    static final int BALL_DIAMETER = 40;
    static final int PUCK_DIAMETER = 60;
    Thread gamThread;
    Image image;
    Graphics graphics;
    Random random;
    Puck puck1;
    Puck puck2;
    Ball ball;
    Score score;
    int topedge = GHEIGHT / 3;
    int bottomedge = 2 * GHEIGHT / 3;

    GamePanel(){
        newPucks();
        newBall();
        score = new Score(GWIDTH, GHEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREENSIZE);

        gamThread = new Thread(this);
        gamThread.start();
    }

    public void newBall() {
        ball = new Ball((GWIDTH / 2) - (BALL_DIAMETER/2), (GHEIGHT / 2) - (BALL_DIAMETER / 2), BALL_DIAMETER, BALL_DIAMETER);
    }

    public void newPucks() {
        puck1 = new Puck(30, (GHEIGHT/2)-(PUCK_DIAMETER/2), PUCK_DIAMETER, 1);
        puck2 = new Puck(GWIDTH - PUCK_DIAMETER - 30, (GHEIGHT/2)-(PUCK_DIAMETER/2), PUCK_DIAMETER, 2);

    }

    public void paint(Graphics g) {
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }

    public void draw(Graphics g){
        puck1.draw(g);
        puck2.draw(g);
        ball.draw(g);
        score.draw(g);
    }

    public void move(){
        puck1.move();
        puck2.move();
        ball.move();
    }

    public void checkCollision(){



        // Bounces ball off puck
        if(ball.intersects(puck1)){
            ball.xMomentum = Math.abs(ball.xMomentum);
            ball.xMomentum++;
            if(ball.yMomentum>0){
            } else {
                ball.yMomentum--;
            }
                ball.SXDirection(ball.xMomentum);
                ball.SYDirection(ball.yMomentum);

            }

            if(ball.intersects(puck2)){
                ball.xMomentum = Math.abs(ball.xMomentum);
                ball.xMomentum++;
                if(ball.yMomentum>0){
                } else {
                    ball.yMomentum--;
                }
                    ball.SXDirection(-ball.xMomentum);
                    ball.SYDirection(ball.yMomentum);
    
                } 
        // Bounce ball off top & bottom window edges
        if(ball.y <= 0 ){
            ball.SYDirection(-ball.yMomentum);
            ball.xMomentum--;
        }
   
        if(ball.y >= GHEIGHT - BALL_DIAMETER){
            ball.SYDirection(-ball.yMomentum);
            ball.xMomentum--;


        }

        // Stop pucks at Window edges
        if (puck1.y <= 0) {
            puck1.y = 0;
            
        }
        if (puck1.y >= (GHEIGHT - PUCK_DIAMETER)) {
            puck1.y = GHEIGHT - PUCK_DIAMETER;
        }
        if (puck1.x <= 0) {
            puck1.x = 0;
        }
        if (puck1.x >= (GWIDTH / 2 - PUCK_DIAMETER)) {
            puck1.x = GWIDTH / 2 - PUCK_DIAMETER;
        }
        
        if (puck2.y <= 0) {
            puck2.y = 0;
        }
        if (puck2.y >= (GHEIGHT - PUCK_DIAMETER)) {
            puck2.y = GHEIGHT - PUCK_DIAMETER;
        }
        if (puck2.x <= (GWIDTH / 2)) {
            puck2.x = GWIDTH / 2;
        }
        if (puck2.x >= (GWIDTH - PUCK_DIAMETER)) {
            puck2.x = GWIDTH - PUCK_DIAMETER;
        }
// Give a player 1 point and creates new puck and ball
if (ball.x <= 0) {
    if (ball.y >= topedge && ball.y <= bottomedge) {
        score.player2++;
        newPucks();
        newBall();
    } else {
        // Ball bounces back
        ball.xMomentum = -ball.xMomentum;
    }
}

if (ball.x >= GWIDTH - BALL_DIAMETER) {
    if (ball.y >= topedge && ball.y <= bottomedge) {
        score.player1++;
        newPucks();
        newBall();
    } else {
        // Ball bounces back
        ball.xMomentum = -ball.xMomentum;
    }
}


        }
    

    public void run(){
        // game loop
        long lastTime = System.nanoTime();
        double amountOfTicks =60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while(true){
            long now = System.nanoTime();
            delta += (now - lastTime)/ns;
            lastTime = now;
            if(delta >= 1){
                move();
                checkCollision();
                repaint();
                delta--;

            }
        }
    }

    public class AL extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            puck1.keyPressed(e);
            puck2.keyPressed(e);
        }

        public void keyReleased(KeyEvent e){
            puck1.keyReleased(e);
            puck2.keyReleased(e);
        }
    }
    }
