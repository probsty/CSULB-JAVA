package adapter;

import java.awt.*;

/**
 * Adapter to use the new methods of the rectangle class).
 * Homework Assignment: Adapter
 *
 * @author Yann Probst
 * @version 1.01 05/03/2020
 */
public class RectangleAdapter extends NewRectangle implements OldRectangle {
    /**
     * New way to do a rectangle.
     */
    private NewRectangle m_newRectangle;

    public RectangleAdapter(Point first, Point second, Point third, Point fourth) {
        double length = Math.sqrt((second.y - first.y) * (second.y - first.y) + (second.x - first.x) * (second.x - first.x));
        double height = Math.sqrt((third.y - first.y) * (third.y - first.y) + (third.x - first.x) * (third.x - first.x));

        m_newRectangle = new NewRectangle(first, length, height);
    }

    @Override
    public double getArea() {
        return m_newRectangle.getWidth() * m_newRectangle.getLength();
    }

    @Override
    public double getPerimeter() {
        return 2 * (m_newRectangle.getWidth() + m_newRectangle.getLength());
    }

    @Override
    public double getDiagonal() {
        return Math.sqrt(Math.pow(m_newRectangle.getWidth(), 2) + Math.pow(m_newRectangle.getLength(), 2));
    }

    @Override
    public Point getCorners() {
        return m_newRectangle.getUpperLeft();
    }
}
