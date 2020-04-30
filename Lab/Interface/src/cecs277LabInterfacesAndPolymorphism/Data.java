package cecs277LabInterfacesAndPolymorphism;

/**
 * A class to computes measures about data.
 * Homework Assignment: LAB3
 *
 * @author Yann Probst
 * @version 1.0 09/02/2020
 */
public class Data
{
    /**
     Computes the average of the measures of the given objects.
     @param _objects an array of Measurable objects
     @return the average of the measures
     */
    public static double average(Measurable[] _objects)
    {
        double sum = 0;

        for (Measurable obj : _objects) {
            sum = sum + obj.getMeasure();
        } // Loop that do the sum of the measure of an array of object

        if (_objects.length > 0) {
            sum = sum / _objects.length;
        } /* Condition to avoid dividing by 0 */ else {
            sum = 0;
        }
        return sum;
    }

    /**
     Search the smallest object in an array.
     @param _objects an array of Measurable objects
     @return the smallest object
     */
    public static Measurable getSmallest(Measurable[] _objects) {
        Measurable min = _objects[0];

        for (int i = 0; i < _objects.length; i++) {
            if (min.getMeasure() < _objects[i].getMeasure()) {
                min = _objects[i];
            } // check if the current object is bigger than the max
        }
        return min;
    }
}