package com.company;
import java.io.Serializable;

public class PersonMemento implements Serializable {
    private int m_heightInches;
    /** The weight of the person in pounds.  Ounces not significant. */
    private int m_weightPounds;
    /** Last Name of the person. */
    private String m_lName;
    /** First Name of the person.*/
    private String m_fName;
    /** The person's hair color */
    private Person.HairColor m_hairColor;

    /**
     * Save the member variable of a Person.
     * @param currentInstance current instance of the Person
     */
    PersonMemento(Person currentInstance) {
        this.m_heightInches = currentInstance.getHeightInches();
        this.m_weightPounds = currentInstance.getWeightPounds();
        this.m_lName = currentInstance.getlName();
        this.m_fName = currentInstance.getfName();
        this.m_hairColor = currentInstance.getHairColor();
    }

    /**
     * Get a new Person with the value of this memento.
     * @return new Person with this memento state
     */
    public Person getSavedPerson() {
        return new Person(m_lName, m_fName, m_hairColor, m_heightInches / Person.inchesPerFoot,
                m_heightInches % Person.inchesPerFoot, m_weightPounds);
    }
}
