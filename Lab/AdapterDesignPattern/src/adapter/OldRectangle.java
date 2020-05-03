package adapter;

import java.awt.*;

/**
 * Old interface to do a rectangle.
 * Homework Assignment: Adapter
 *
 * @author Yann Probst
 * @version 1.01 05/03/2020
 */
public interface OldRectangle {
    /**
     * Get area of a rectangle.
     * @return the area size.
     */
    public double getArea();

    /**
     * Get perimeter of a rectangle.
     * @return the perimeter.
     */
    public double getPerimeter();

    /**
     * Get size of the diagonal.
     * @return size of the diagonal.
     */
    public double getDiagonal();

    /**
     * Get first point of the rectangle.
     * @return the upper left point.
     */
    public Point getCorners();
}
