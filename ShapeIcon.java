import javax.swing.*;
import java.awt.*;

public class ShapeIcon implements Icon {
    private MoveableShape shape;
    private int width;
    private int height;

    public ShapeIcon(MoveableShape shape, int width, int height) {
        this.shape = shape;
        this.width = width;
        this.height = height;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g;
        shape.draw(g2);
    }

    @Override
    public int getIconWidth() {
        return width;
    }

    @Override
    public int getIconHeight() {
        return height;
    }
}