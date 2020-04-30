package cecs277LabInterfacesAndPolymorphism;

import java.util.Arrays;

/**
 * A class to try to use the interface and polymorphism.
 * Homework Assignment: LAB3
 *
 * @author Yann Probst
 * @version 1.0 09/02/2020
 */
public class InterfaceAndPolymorphismRunner extends Data {
    public static void main(String[] args) {
        Person[] persons =  new Person[4];
        persons[0] = new Person("Yann", "Probst", 23);
        persons[1] = new Person("Julien", "Delane", 22);
        persons[2] = new Person("Cristiano", "Ronaldo", 35);
        persons[3] = new Person("Chuck", "Norris", 135);

        System.out.println("Before parallel sort");
        for (Person elem : persons) {
            System.out.println(elem);
        } // Loop that display the content of an array of person

        Arrays.parallelSort(persons);
        System.out.println("After parallel sort");
        for (Person elem : persons) {
            System.out.println(elem);
        } // Loop that display the content of an array of person

        double average = average(persons);
        System.out.println(average);
        System.out.println("Completed Satisfactorily");
    }
}
