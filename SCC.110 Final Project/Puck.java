import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Puck extends Rectangle {
    
    int id;
    int yMomentum;
    int xMomentum;
    boolean upPressed, downPressed, leftPressed, rightPressed;
    
    
    Puck(int x, int y, int PUCK_DIAMETER, int id) {
        super(x, y, PUCK_DIAMETER, PUCK_DIAMETER);
        this.id = id;
    }

    public void keyPressed(KeyEvent e) {
        switch (id) {
            case 1:
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    SYDirection(-10);
                    upPressed = true;
                }

                if (e.getKeyCode() == KeyEvent.VK_S) {
                    SYDirection(10);
                    downPressed = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    SXDirection(10);
                    rightPressed = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    SXDirection(-10);
                    leftPressed = true;
                }
                move();
                break;
            case 2:
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    SYDirection(-10);
                    upPressed = true;
                }

                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    SYDirection(10);
                    downPressed = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    SXDirection(10);
                    rightPressed = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    SXDirection(-10);
                    leftPressed = true;
                }
                move();
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (id) {
            case 1:
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    upPressed = false;
                }

                if (e.getKeyCode() == KeyEvent.VK_S) {
                    downPressed = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    rightPressed = false;
                }

                if (e.getKeyCode() == KeyEvent.VK_A) {
                    leftPressed = false;
                }
                if (!upPressed && !downPressed) {
                    SYDirection(0);
                }
                if (!leftPressed && !rightPressed) {
                    SXDirection(0);
                }
                move();
                break;

            case 2:
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    upPressed = false;
                }

                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    downPressed = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    rightPressed = false;
                }

                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    leftPressed = false;
                }
                if (!upPressed && !downPressed) {
                    SYDirection(0);
                }
                if (!leftPressed && !rightPressed) {
                    SXDirection(0);
                }
                move();
                break;
        }
    }    

    public void SYDirection(int yDirection) {
        yMomentum = yDirection;
    }

    public void SXDirection(int xDirection) {
        xMomentum = xDirection;
    }

    public void move() {
        y = y + yMomentum;
        x = x + xMomentum;
    }

    public void draw(Graphics g){
        if(id==1) {
            g.setColor(Color.blue);
            g.fillOval(x, y, width, height);
            
        } else{
        if(id==2){
            g.setColor(Color.blue);
            g.fillOval(x, y, width, height);
        }
    }
    }
}
