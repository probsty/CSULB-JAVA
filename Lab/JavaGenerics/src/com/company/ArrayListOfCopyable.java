package com.company;

import java.util.ArrayList;

/**
 * Somewhat contrived class that basically serves as a wrapper to an ArrayList of String.  This
 * wrapper then implements the Copyable and Printable interfaces.
 * @author	David Brown
 * @date	01/26/2020
 */
public class ArrayListOfCopyable <S extends Copyable<S>> implements Copyable<ArrayListOfCopyable<S>>, Printable{

    private ArrayList <S> flavors;

    public String print () {
        StringBuffer sb = new StringBuffer ("Favorite flavors:");
        for (S next: this.flavors) {
            sb.append("\n" + next);
        }
        return sb.toString ();
    }

    public void addElement (S newFlavor) {
        S elem = newFlavor.copy();
        this.flavors.add(elem);
    }

    public void addFlavor (S newFlavor) {
        this.flavors.add(newFlavor);
    }

    public ArrayListOfCopyable () {
        this.flavors = new ArrayList <>();
    }

    @Override
    public ArrayListOfCopyable copy () {
        ArrayListOfCopyable newFavorites = new ArrayListOfCopyable ();
        //Note that strings are immutable, so even though our copy of the ArrayList of favorite flavors
        //points to the same set of String objects that the original object did, there is no harm in
        //that because there is no way for either of us to change those original strings.  Other
        //objects, that are mutable, would need to be cloned in this copy process.
        for (S next: this.flavors) {
            newFavorites.addFlavor(next);
        }
        return newFavorites;
    }

}
