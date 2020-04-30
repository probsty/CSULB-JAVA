package decorator;

import javax.sound.sampled.Line;

public class LineColorDecorator extends ShapeDecorator {

    /* Color of this shape */
    private Color m_color;

    public LineColorDecorator(GeometricObject _shape, Color _color) {
        super(_shape);
        this.m_color = _color;
    }

    @Override
    public String toString() {
        return "Fill color: " + this.m_color + " for shape: " + super.getDecoratedShape();
    }

    @Override
    public void draw() {
        System.out.println ("Drawing a shape of color: " + this.m_color);
        super.getDecoratedShape().draw();
    }

    @Override
    public void resize(double percent) {
        System.out.println ("Resizing a shape of line weight: " + this.m_color);
        super.getDecoratedShape().resize(percent);
    }
}
