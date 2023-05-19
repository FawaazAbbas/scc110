import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Ball extends Rectangle{
    
    Random random;
    int xMomentum;
    int yMomentum;
    int speed = 3;

    Ball(int GWIDTH, int GHEIGHT, int width, int height) {
        super(GWIDTH, GHEIGHT , width, height);
        SXDirection(0);
        SYDirection(0);
    }

    public void SXDirection(int RXDirection) {
        xMomentum = RXDirection;
    }

    public void SYDirection(int randomYDirection) {
        yMomentum = randomYDirection;
    }

    public void move(){
        x += xMomentum;
        y += yMomentum;
    }

    public void draw(Graphics g){
        g.setColor(Color.black);
        g.fillOval(x, y, height, width);

    }
}
