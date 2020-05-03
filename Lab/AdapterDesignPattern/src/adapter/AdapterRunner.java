package adapter;

import java.awt.*;

/**
 * A AdapterRunner to test the program.
 * Homework Assignment: Adapter
 *
 * @author Yann Probst
 * @version 1.01 05/03/2020
 */
public class AdapterRunner extends RectangleAdapter {

    public static void main(String[] args) {
        Point first = new Point(1, 4);
        Point second = new Point(4, 4);
        Point third = new Point(1, 1);
        Point fourth = new Point(1, 4);

        OldRectangle oldRectangle = new RectangleAdapter(first, second, third, fourth);
        System.out.println(oldRectangle.getArea());
        System.out.println(oldRectangle.getCorners());
        System.out.println(oldRectangle.getDiagonal());
        System.out.println(oldRectangle.getPerimeter());
        System.out.println("Completed");
    }
}
