package com.jetbrains;

/**
 * A class to record information about an individual.
 * Homework Assignment:
 *
 * @author Yann Probst
 * @version 1.01 03/11/2020
 */
public class Section {
    /** The name of the course */
    String courseName;
    /** The section number of this particular section */
    int sectionNumber;
    /** The start time name */
    Time startTime;
    /** The end time name */
    Time endTime;
    /** The Building where this section is held */
    String Building;
    /** The room number of this section */
    String Room;
    /** The course instructor's name */
    String courseInstructorName;
    /** Days of the week that the course is offered */
    Date courseDays;
    public Section(String courseName, int sectionNumber, Time startTime, Time endTime, String building,
                   String room, String courseInstructorName, Date courseDays) {
        super();
        this.courseName = courseName;
        this.sectionNumber = sectionNumber;
        this.startTime = startTime;
        this.endTime = endTime;
        this.Building = building;
        this.Room = room;
        this.courseInstructorName = courseInstructorName;
        this.courseDays = courseDays;
    }

    /**
     * Copy constructor.
     * @param	orig	The Section that you want to copy.
     */
    public Section (Section orig) {
        //Use the constructor with discrete arguments to create a copy constructor.
        this(orig.courseName, orig.sectionNumber, orig.startTime, orig.endTime, orig.Building, orig.Room, orig.courseInstructorName, orig.courseDays);
    }

    /**
     * Copy from one Section to another.
     * @param other	The Section instance that we're cloning into ourselves.
     */
    public void setEquals (Section other) {
        this.setCourseName(other.courseName);
        this.setSectionNumber(other.sectionNumber);
        this.setStartTime(other.startTime);
        this.setEndTime(other.endTime);
        this.setBuilding(other.Building);
        this.setRoom(other.Room);
        this.setInstructorName(other.courseInstructorName);
        this.setCourseDays(other.courseDays);
    }
    @Override
    public String toString() {
        return "Section [courseName=" + courseName + ", sectionNumber=" + sectionNumber + ", startTime="
                + startTime + ", endTime=" + endTime + ", Building=" + Building + ", Room=" + Room +
                ", instructorName=" + courseInstructorName + ", courseDays=" + courseDays + "]";
    }
    public void setCourseName(String courseName) {this.courseName = courseName;	}
    public void setSectionNumber(int sectionNumber) {this.sectionNumber = sectionNumber;}
    public void setStartTime(Time startTime) {this.startTime = startTime;}
    public void setEndTime(Time endTime) {this.endTime = endTime;}
    public void setBuilding(String building) {this.Building = building;}
    public void setRoom(String room) {this.Room = room;}
    public void setInstructorName(String instructorName) {this.courseInstructorName = instructorName;}
    public void setCourseDays(Date courseDays) {this.courseDays = courseDays;}

    /**
     * Restore the state of this Section from the given memento.  Remember that the
     * Memento stores the Section's state as a copy of Section.
     * @param	mem		The memento that you're copying from.
     */
    public void getStateFromMemento (Memento mem) {
        this.setEquals(mem.getSection());
    }

    /**
     * Pickle the current state into an instance of Memento and return it.
     * @return	The memento copy of the present state.
     */
    public Memento saveStatetoMemento () {
        return new Memento ();
    }

    /**
     * The Memento is tightly coupled to the Originator, so making the Memento a nested
     * class in the Originator has some appeal to it.
     * @author	David Brown
     * @date	08/24/2019
     */
    public class Memento {
        Section saved;
        public Memento () {
            /**
             * Hold on, this is going to be a bumpy ride.
             * In the nested class Memento, we want to have a copy of the current state of
             * the enclosing class.  It's a copy, and a deep on at that (if we needed such
             * a thing).  So this.saved is a reference to a clone of the enclosing class at
             * this moment.  We get that by using Section's copy constructor and passing it
             * in the current state of Section.  The syntax for that last bit of magic is
             * Section.this.  If we just said "this" we would get the current instance of
             * Memento, which isn't what we really want.
             */
            this.saved = new Section (Section.this);
            // The caretaker just manages references to these Memento instances which are
            // all inside of the Section instance.
        } // End of the default constructor for Memento
        // Getter methods for the memento class
        public Section getSection () {
            return this.saved;
        } // End of the getSection getter
    } // End of the Memento class
}
