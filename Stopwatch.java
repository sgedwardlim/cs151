import javax.swing.*;
import java.awt.*;

public class Stopwatch extends JPanel {
    private int radius;
    private ClockFace clockFace;
    private StopWatchDial stopWatchDial;
    private ClockHand secondsHand;
    private int secondsElapsed = 0;

    /**
     Constructs a Stopwatch
     @param x the left of the bounding rectangle
     @param y the top of the bounding rectangle
     @param width the width of the bounding rectangle
     */
    public Stopwatch(int x, int y, int width) {
        this.radius = width / 2;
        this.clockFace = new ClockFace(x, y, radius * 2);
        this.stopWatchDial = new StopWatchDial(radius - radius / 2, y, radius);
        this.secondsHand = new ClockHand(Color.BLACK, 10, radius * .8, radius, radius);
        this.setOpaque(false);
        this.setPreferredSize(new Dimension(radius * 2, radius * 2));

        final int DELAY = 100; // 1000ms
        Timer t = new Timer(DELAY, event -> {
            if (shouldIncrementInnerDial()) {
                stopWatchDial.tick();
                secondsElapsed = 0;
            } else {
                secondsElapsed++;
            }
            secondsHand.move(); // expect the algorithm to move clocks by 1/60th to be implemented
            repaint();
        });
        t.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        clockFace.paintComponent(g);
        stopWatchDial.paintComponent(g);
        secondsHand.draw((Graphics2D) g);
    }

    private boolean shouldIncrementInnerDial() {
        return secondsElapsed == 1;
    }
}
