import javax.swing.*;
import java.awt.*;

public class StopWatchDial extends JPanel {

    private int radius;
    private ClockFace clockFace;
    private ClockHand minutesHand;
    private int xPos;
    private int yPos;

    /**
     Constructs a StopWatchDial
     @param x the left of the bounding rectangle
     @param y the top of the bounding rectangle
     @param width the width of the bounding rectangle
     */
    public StopWatchDial(int x, int y, int width) {
    	this.xPos = x;
    	this.yPos = y;
        this.radius = width / 2;
        this.clockFace = new ClockFace(x, y, radius * 2);
        this.clockFace.incrementBy(ClockFaceIncrementType.FIVES);
        this.minutesHand = new ClockHand(Color.RED, 3, radius, x + radius, y + radius, 0);
        this.setOpaque(false);
        this.setPreferredSize(new Dimension(width, width));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        clockFace.paintComponent(g);
        minutesHand.draw((Graphics2D) g);
    }

    // Informs minutes hand to move in the clock wise direction by 1/60 of a revolution
    public void tick() {
        minutesHand.move();
        repaint();
    }
    
    public void reset(){
        minutesHand = new ClockHand(Color.RED, 3, radius, xPos + radius, yPos + radius, 0);

    }
}
