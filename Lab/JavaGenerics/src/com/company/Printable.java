package com.company;

public interface Printable {
    /**
     * This is really just a juiced up toString.  The thing is, toString has an implementation in
     * Object, and that default implementation is often less than useful.  So, by requiring that
     * the classes implementing this interface have a print method, that requires that the user
     * be more deliberate about just what goes into that print method.  It could just delegate
     * the execution to the toString method without any harm, as long as the toString method
     * produces useful output.
     * @return	A printable version of the object.
     */
    public String print();
}
