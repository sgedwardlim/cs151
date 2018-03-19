import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MyClock extends JPanel {
    private int radius;

    private ClockFace clockFace;
    private ClockHand secondsHand;
    private ClockHand minutesHand;
    private ClockHand hoursHand;
    
    Date date;
    Calendar calendar;

    /**
     Constructs a Clock
     @param x the left of the bounding rectangle
     @param y the top of the bounding rectangle
     @param width the width of the bounding rectangle
     */
    public MyClock(int x, int y, int width) {
        radius = width / 2;
        clockFace = new ClockFace(x, y, width);
        
        date = new Date();   // given date
        calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
        calendar.setTime(date);
        
        int secondsTick = calendar.get(Calendar.SECOND);
        int minutesTick = calendar.get(Calendar.MINUTE);
        int hours = calendar.get(Calendar.HOUR) * 5;
        int hoursTick = hours + minutesTick / 12;
        
        secondsHand = new ClockHand(Color.RED, 3, radius * .8, radius, radius, secondsTick);
        minutesHand = new ClockHand(Color.BLACK, 6, radius * .7, radius, radius, minutesTick);
        hoursHand = new ClockHand(Color.BLACK, 10, radius * .5, radius, radius, hoursTick);
        setOpaque(false);
        setPreferredSize(new Dimension(width, width));
        
        //seconds hand
        final int DELAY = 1000;
        Timer t = new Timer(DELAY, event -> {
            secondsHand.move();
            repaint();
            if (secondsHand.getTick() == 0){
            	minutesHand.move();
            	if (minutesHand.getTick() % 12 == 0){
            		hoursHand.move();
            	}
            }
            
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
