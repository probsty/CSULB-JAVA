package com.jetbrains;

/**
 * A class to write.
 * Homework Assignment:
 *
 * @author Yann Probst
 * @version 1.01 10/17/2019
 */
public class StringWriterImp implements StringWriter {
    /** Write a given value
     * @param value value to be write
     * */
    @Override
    public void write(String value) {
            System.out.println(value);
    }
}
