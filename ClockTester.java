import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClockTester {
    private static final int CLOCK_RADIUS = 300;

    private static JButton clockButton = new JButton("clock");
    private static JButton stopwatchButton = new JButton("stopwatch");

    public static void main(String[] args) {
       JFrame frame = new JFrame();

       MyClock myClock = new MyClock(0, 0, CLOCK_RADIUS * 2);
       Stopwatch stopwatch = new Stopwatch(0, 0, CLOCK_RADIUS * 2);

       JPanel centerPanel = new JPanel();
       centerPanel.setLayout(new OverlayLayout(centerPanel));
       centerPanel.add(myClock);
       centerPanel.add(stopwatch);
       stopwatch.setVisible(false);
       frame.add(centerPanel, BorderLayout.CENTER);

       JPanel topNav = new JPanel(new FlowLayout());
       topNav.add(clockButton);
       topNav.add(stopwatchButton);
       frame.add(topNav, BorderLayout.NORTH);

       clockButton.addActionListener(event -> {
           stopwatch.setVisible(false);
           myClock.setVisible(true);
       });

       stopwatchButton.addActionListener(event -> {
           myClock.setVisible(false);
           stopwatch.setVisible(true);
       });

       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.pack();
       frame.setVisible(true);
   }
}
