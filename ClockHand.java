import java.awt.*;
import java.awt.geom.GeneralPath;

public class ClockHand implements MoveableShape {
    private Color color;
    private float thickness;
    private double length;

    private int centerX;
    private int centerY;

    private int deltaX;
    private int deltaY;

    public ClockHand(Color color, float thickness, double length, int centerX, int centerY) {
        this.color = color;
        this.thickness = thickness;
        this.length = length;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    @Override
    public void draw(Graphics2D g2) {
        Stroke handStroke = new BasicStroke(thickness, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1f);
        GeneralPath handsPath = new GeneralPath();
        handsPath.moveTo(centerX, centerY);
        handsPath.lineTo(centerX + deltaX, centerY - length + deltaY);
        g2.setColor(color);
        g2.setStroke(handStroke);
        g2.draw(handsPath);
    }

    @Override
    public void move() {
        deltaX += 10;   // shitty thing that dont work, replace with correct algorith to rotate hand
    }
}
