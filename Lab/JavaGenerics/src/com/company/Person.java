package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A somewhat contrived Person object that just has a first name, last name, and date of birth.
 * Note that, by saying Copyable <Person> we establish that our implementation of Copyable
 * only applies to objects of type Person.  Since we are making a copy of ourselves, that would
 * seem axiomatic, but not to the compiler since it has no idea what Copyable actually does.
 * @author	David Brown
 * @date	01/26/2020
 */
public class Person implements Copyable <Person>, Printable {

    /** Last name */
    private String lname;
    /** First name */
    private String fName;
    /** Date of Birth.  Actually we would hesitate to do this since this is PII data, but humor me. */
    private Date DOB;

    public Person (String lName, String fName, Date DOB) {
        this.lname = lName;
        this.fName = fName;
        if (DOB.compareTo(new Date()) > 0) {
            throw new IllegalArgumentException ("Error, date of birth is after today!");
        }
        this.DOB = DOB;
    }

    @Override
    public String print () {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        return this.lname + ", " + this.fName + " born on: " + format.format(this.DOB);
    }

    @Override
    public Person copy () {
        return new Person (this.lname, this.fName, this.DOB);
    }
}