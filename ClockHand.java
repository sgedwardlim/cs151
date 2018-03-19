import java.awt.*;
import java.awt.geom.GeneralPath;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ClockHand implements MoveableShape {
    private Color color;
    private float thickness;
    private double length;

    private int centerX;
    private int centerY;

    private double deltaX;
    private double deltaY;
    
    private double tick;
 
    public ClockHand(Color color, float thickness, double length, int centerX, int centerY, double tick) {
        this.color = color;
        this.thickness = thickness;
        this.length = length;
        this.centerX = centerX;
        this.centerY = centerY;
        
        this.tick = tick;
    }

    @Override
    public void draw(Graphics2D g2) {
        Stroke handStroke = new BasicStroke(thickness, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1f);
        GeneralPath handsPath = new GeneralPath();
        handsPath.moveTo(centerX, centerY);
       
        double angleFrom12 = tick/60.0*2.0*Math.PI;
        double angleFrom3 = Math.PI*1.5+angleFrom12;
        deltaX = Math.cos(angleFrom3)*length;
        deltaY = Math.sin(angleFrom3)*length;
        
        handsPath.lineTo(centerX + deltaX, centerY + deltaY);
        g2.setColor(color);
        g2.setStroke(handStroke);
        g2.draw(handsPath);
    }

    @Override
    public void move() {
    	
    	tick++;
        double angleFrom12 = tick/60.0*2.0*Math.PI;
        double angleFrom3 = Math.PI*1.5+angleFrom12;
        deltaX = Math.cos(angleFrom3)*length;
        deltaY = Math.sin(angleFrom3)*length;
        
        if (tick == 60){
        	tick = 0;
        }
    }

    public void reset() {
        tick = 0;
    }
    
    public double getTick(){
    	return tick;
    }
}
