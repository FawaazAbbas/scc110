import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Score extends Rectangle{
    
    static int GWIDTH;
    static int GHEIGHT;
    int player1;
    int player2;
    int topedge = GHEIGHT / 3;
    int bottomedge = 2 * GHEIGHT / 3;

    Score(int GWIDTH, int GHEIGHT){
        Score.GWIDTH = GWIDTH;
        Score.GHEIGHT = GHEIGHT;
    }

    public void draw(Graphics g){
        int circleDiameter = Math.min(GWIDTH, GHEIGHT) / 3;
        g.drawOval((GWIDTH - circleDiameter) / 2, (GHEIGHT - circleDiameter) / 2, circleDiameter, circleDiameter);
        
        g.setColor(Color.black);
        g.setFont(new Font("Consolas", Font.PLAIN, 60));
        g.drawLine(GWIDTH / 2, 0, GWIDTH / 2, GHEIGHT);

        g.drawString(String.valueOf(player1/10)+String.valueOf(player1%10), ((GWIDTH/2) - 85), 50);
        g.drawString(String.valueOf(player2/10)+String.valueOf(player2%10), ((GWIDTH/2) + 20), 50);

        int boxWidth = 5;
        g.fillRect(0, topedge, boxWidth, bottomedge - topedge);
        g.fillRect(GWIDTH - boxWidth, topedge, boxWidth, bottomedge - topedge);
    
        

    }
}
