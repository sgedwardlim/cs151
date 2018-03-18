import javax.swing.*;
import java.awt.*;

public class MyClock extends JPanel {
    private int radius;

    private ClockFace clockFace;
    private ClockHand secondsHand;
    private ClockHand minutesHand;
    private ClockHand hoursHand;

    /**
     Constructs a Clock
     @param x the left of the bounding rectangle
     @param y the top of the bounding rectangle
     @param width the width of the bounding rectangle
     */
    public MyClock(int x, int y, int width) {
        radius = width / 2;
        clockFace = new ClockFace(x, y, width);
        secondsHand = new ClockHand(Color.RED, 3, radius * .8, radius, radius);
        minutesHand = new ClockHand(Color.BLACK, 6, radius * .6, radius, radius);
        hoursHand = new ClockHand(Color.BLACK, 10, radius * .4, radius, radius);
        setOpaque(false);
        setPreferredSize(new Dimension(width, width));

        final int DELAY = 100;
        Timer t = new Timer(DELAY, event -> {
            secondsHand.move();
            repaint();
        });
        t.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        clockFace.paintComponent(g);
        hoursHand.draw((Graphics2D) g);
        minutesHand.draw((Graphics2D) g);
        secondsHand.draw((Graphics2D) g);
    }
}
