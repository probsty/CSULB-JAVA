package com.jetbrains;

/**
 * A class to record information about an individual.
 * Homework Assignment:
 *
 * @author Yann Probst
 * @version 1.01 1.01 03/11/2020
 */
public class MementoRunner {
    public static void main(String[] args) {
        Section CECS277 = new Section("CECS 277", 5, Time.EIGHT, Time.NINE, "VEC", "330", "Test", Date.TUESDAY_THURSDAY);
        System.out.println("CECS277 originally:" + CECS277 + "\n\n");
        CareTaker ct = new CareTaker();
        //saveStatetoMemento is a Section member function that uses the Memento constructor
        //to "pickle" the current state of CECS277 into a memento, which is a nested class
        //within Section, the originator.
        ct.add(CECS277.saveStatetoMemento());				//Save the current state.
        CECS277.setBuilding("ECS");							//Update the state of CECS277
        CECS277.setRoom("414");
        ct.add(CECS277.saveStatetoMemento());				//Save the state again
        CECS277.setStartTime(Time.THREE_THIRTY);			//Update the state of CECS277
        CECS277.setEndTime(Time.FOUR_THIRTY);
        ct.add(CECS277.saveStatetoMemento()); 				//Save the state yet again
        CECS277.setCourseDays(Date.SATURDAY);			//Update the state of CECS277
        ct.add(CECS277.saveStatetoMemento()); 				//Save the state yet again
        CECS277.setInstructorName("David Brown Junior");			//Update the state of CECS277
        ct.add(CECS277.saveStatetoMemento()); 				//Save the state yet again

        System.out.println("Most recent version: " + CECS277 + "\n\n");
        CECS277.getStateFromMemento(ct.get(0));

        System.out.println("Version 1: " + CECS277 + "\n\n");
        CECS277.getStateFromMemento(ct.get(1));

        System.out.println("Version 2: " + CECS277 + "\n\n");
        CECS277.getStateFromMemento(ct.get(2));

        System.out.println("Version 3: " + CECS277 + "\n\n");
        CECS277.getStateFromMemento(ct.get(3));

        System.out.println("Version 4: " + CECS277 + "\n\n");
        CECS277.getStateFromMemento(ct.get(4));
    }
}
