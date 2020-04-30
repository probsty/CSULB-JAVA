package decorator;

public class Square extends GeometricObject {

    /** x coordinate of the square upper left corner */
    double m_x;
    /** y coordinate of the square upper left corner */
    double m_y;
    /** Length side of the square */
    private double m_lengthOneSide;

    /**
     * Create a new square.
     * @param _x			x coordinate of the upper left hand corner.
     * @param _y			y coordinate of the upper left hand corner.
     * @param _length	Length of the square.
     */
    public Square (double _x, double _y, double _length) {
        this.m_x = _x;
        this.m_y = _y;
        this.m_lengthOneSide = _length;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a square.");
    }

    @Override
    public void resize(double _percent) {
        this.m_lengthOneSide = this.m_lengthOneSide * _percent;
    }

    @Override
    public String toString() {
        return "Square- Upper left at: " + this.m_x + ", " + this.m_y + " length of each side: " +
                this.m_lengthOneSide;
    }
}
