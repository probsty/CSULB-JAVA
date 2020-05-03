package adapter;

import java.awt.*;

/**
 * A class to create a rectangle (new way to do it).
 * Homework Assignment: Adapter
 *
 * @author Yann Probst
 * @version 1.01 05/03/2020
 */
public class NewRectangle {
    /**
     * Upper Left point
     */
    Point m_upperLeft;

    /**
     * Width size
     */
    double m_width;
    /**
     * Length size
     */
    double m_length;

    public NewRectangle(Point _start, double _width, double _length) {
        m_upperLeft = _start;
        m_width = _width;
        m_length = _length;
    }

    public Point getUpperLeft() {
        return m_upperLeft;
    }

    public double getWidth() {
        return m_width;
    }

    public double getLength() {
        return m_length;
    }
}
