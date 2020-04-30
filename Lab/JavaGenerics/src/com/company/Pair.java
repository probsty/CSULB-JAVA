package com.company;

/**
 * The Pair class is somewhat contrived, but not altogether.  It is handy if you want to put two things
 * together into a single class without the overhead of a specific class for that pair of objects.
 * @author	David Brown
 * @date	01/26/2020
 * @param	<U>	The first member of the pair.
 * @param	<V>	The second member of the pair.
 * @Note	Printable and Copyable make sure that we can do a toString on both of these, and create
 * 			deep copies.
 */
public class Pair <U extends Printable & Copyable <U>, V extends Printable & Copyable <V>> implements Printable{
    private U first;
    private V second;

    @Override
    public String print () {
        StringBuffer sb = new StringBuffer("First part of the pair:\n" + this.first.print());
        sb.append("\nSecond part of the pair:\n" + this.second.print());
        return sb.toString();
    }

    public Pair (U first, V second) {
        //Create a copy of the arguments before we store references so that we are not coupled to the client
        this.first = first.copy();
        this.second = second.copy();
    }

}