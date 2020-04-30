package com.company;

public interface Copyable <U> {
    /**
     * The clone method creates a deep copy of the object, so that they
     * have nothing in common.  This would be best if we could do it as
     * a copy constructor, but this is the best that I know how to do.
     *
     * The Object class has a clone method that does a shallow copy.  We
     * call for a DEEP copy in this case.
     */
    public U copy ();
}
