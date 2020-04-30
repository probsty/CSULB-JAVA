package com.jetbrains;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to record information about an individual.
 * Homework Assignment:
 *
 * @author Yann Probst
 * @version 1.01 1.01 03/11/2020
 */
public class CareTaker {
    private List<Section.Memento> mlist = new ArrayList<>();

    public void add(Section.Memento m) {
        mlist.add(m);
    }

    /**
     * Retrieve a particular memento from the list of mementos that we have.
     * @param	index	The memento that you want.  The numbering starts at 0.
     * 					If you run off the end of the ArrayList, you will throw
     * 					an exception.
     * @return			The Section instance requirested.
     */
    public Section.Memento get(int index) {
        return mlist.get(index);
    }
}
