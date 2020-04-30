package cecs277LabInterfacesAndPolymorphism;

/**
 * A class to record information about a person.
 * Homework Assignment: LAB3
 *
 * @author Yann Probst
 * @version 1.0 09/02/2020
 */
public class Person implements Comparable<Person>, Measurable {
    /** The Person’s firstName. */
    private String m_firstName;

    /** The Person’s lastName. */
    private String m_lastName;

    /** The Person’s age. */
    private int m_age;

    public Person() {}

    public Person(String _firstName, String _lastName, int _age) {
        this.m_firstName = _firstName;
        this.m_lastName = _lastName;
        this.m_age = _age;
    }

    /**
     * Return a String that correspond to the firstName of the person.
     * @return String, firstName of this person.
     */
    public String getFirstName() {
        return m_firstName;
    }

    /**
     * Return a String that correspond to the lastName of the person.
     * @return String, lastName of this person.
     */
    public String getLastName() {
        return m_lastName;
    }

    /**
     * Return an int that correspond to the age of the person.
     * @return int, age of this person.
     */
    public int getAge() {
        return m_age;
    }

    /**
     * Return a String version of the person's age.
     * Note, this is a really bad idea, we should have stored their birthday and
     * calculated the age, but this is simpler for now.
     * @return String version of this person.
     */
    @Override
    public String toString() {
        return "Name: " + m_firstName + " " + m_lastName + " Age: " + m_age;
    }

    /**
     * Compare one instance of Person (the implicit parameter) to another
     * instance of Person (the explicit parameter that we're calling "Other".
     * @param _other The second Person in the comparison.
     * @return < 1 if this person < the other person.
     * = 0 if they are equal
     * > 1 if this person > the other person.
     * Note, we compare by last name first, then the first name.
     * Note, we ignore the case in this particular implementation.
     */
    @Override
    public int compareTo(Person _other) {
        int nameComp = this.getLastName().compareToIgnoreCase(_other.getLastName());
        if (nameComp == 0) {                    //Last names match, so we have to go to the first name.
            nameComp = this.getFirstName().compareToIgnoreCase(_other.getFirstName());
        } // Check if the comparison is successful
        return nameComp;
    }

    /**
     * Return a double that correspond to the age of the person.
     * @return double, age of this person.
     */
    @Override
    public double getMeasure() {
        return this.getAge();
    }
}

