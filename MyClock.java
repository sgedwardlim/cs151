import javax.swing.*;
import java.awt.*;

public class MyClock extends JPanel {
    private static final int CLOCK_RADIUS = 500;

    private int x;
    private int y;
    private int width;

    ClockFace clockFace;
    ClockHand secondsHand = new ClockHand(Color.RED, 3, 50, CLOCK_RADIUS / 2, CLOCK_RADIUS / 2);
    ClockHand minutesHand = new ClockHand(Color.BLACK, 6, 40, CLOCK_RADIUS / 2, CLOCK_RADIUS / 2);
    ClockHand hoursHand = new ClockHand(Color.BLACK, 10, 250, CLOCK_RADIUS / 2, CLOCK_RADIUS / 2);

    /**
     Constructs a Clock
     @param x the left of the bounding rectangle
     @param y the top of the bounding rectangle
     @param width the width of the bounding rectangle
     */
    public MyClock(int x, int y, int width)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.clockFace = new ClockFace(x, y, CLOCK_RADIUS);
        this.setOpaque(false);
        this.setPreferredSize(new Dimension(width, width));

        ShapeIcon hoursHandIcon = new ShapeIcon(hoursHand, CLOCK_RADIUS, CLOCK_RADIUS);
        final JLabel label = new JLabel(hoursHandIcon);


        final int DELAY = 100;
        Timer t = new Timer(DELAY, event -> {
            hoursHand.move();
            repaint();
        });
        t.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        clockFace.paintComponent(g);
        hoursHand.draw((Graphics2D) g);
    }
}
