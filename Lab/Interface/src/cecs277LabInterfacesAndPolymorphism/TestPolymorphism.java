package cecs277LabInterfacesAndPolymorphism;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A class do some test.
 * Homework Assignment: LAB 3
 *
 * @author Yann Probst
 * @version 1.01 02/11/2020
 */
class TestPolymorphism {
    static Person[] persons = new Person[]{
            new Person("Yann", "Probst", 23),
            new Person("Julien", "Delane", 22),
            new Person("Cristiano", "Ronaldo", 35),
            new Person("Yann", "Probst", 23)};

    @Test
    void main() {
    }

    @Test
    @DisplayName(value = "Test Count")
    public void testCount() {
    //Silly test to make sure that the length (number of elements) of
    //our people array is what we expect.
        int expectedCount = 0;
    //Now, staring at 0, add one to the count for each element
    //in the people array.
        for (; expectedCount < persons.length; expectedCount++);
    //See if our little calculation worked.
        assertEquals (expectedCount, persons.length);
    }

    static public boolean testSort(Person[] _persons) {
        Person currentElem = _persons[0];
        boolean sorted = true;

        for (Person elem : _persons) {
            if (currentElem.compareTo(elem) > 0) {
                sorted = false;
            }
        }
        return sorted;
    }

    public Person[] copy() {
        return persons.clone();
    }

    @Test
    public void testSorted() {
        Person[] copy = copy();
        assertEquals(testSort(persons), false);
        Arrays.parallelSort(copy);
        assertEquals(testSort(copy), true);
    }

    @Test
    public void testAverage() {
        double average = 0;

        for (Measurable obj : persons) {
            average = average + obj.getMeasure();
        } // Loop that do the sum of the measure of an array of object

        if (persons.length > 0) {
            average = average / persons.length;
        } /* Condition to avoid dividing by 0 */ else {
            average = 0;
        }

        assertEquals(Data.average(persons), average, 0.01);
    }

    @Test
    public void testGetSmallest() {
        Measurable tmp = Data.getSmallest(persons);
        Measurable min = persons[0];

        for (Person person : persons) {
            if (min.getMeasure() < person.getMeasure()) {
                min = person;
            } // check if the current object is bigger than the max
        }
        assertEquals(tmp, min);
    }
}