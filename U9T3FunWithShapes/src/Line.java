import java.awt.*;

public class Line extends Shape{

    public Line()
    {super();}

    @Override
    public void draw(Graphics g)
    {
        // set the color
        g.setColor(getColor());

        // draw the rectangle given the top left point and width and height
        g.drawLine(getP1().x, getP1().y, getP2().x, getP2().y); // the getter methods here are INHERITED FROM SHAPE!
    }
}
