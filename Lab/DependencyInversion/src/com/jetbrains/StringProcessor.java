package com.jetbrains;

import java.util.Scanner;

/**
 * A class to read a string
 * Homework Assignment:
 *
 * @author Yann Probst
 * @version 1.01 10/17/2019
 */
public class StringProcessor implements StringWriter, StringReader {
    /** The object that will do the reading for us */
    private final StringReader stringReader;
    /** The object that will do the writing for us */
    private final StringWriter stringWriter;

    /**
     * Dependency injecting constructor.
     * @param stringReader	The reader that we'll use.
     * @param stringWriter	The writer that we'll use.
     */
    public StringProcessor(StringReader stringReader, StringWriter stringWriter) {
        this.stringReader = stringReader;
        this.stringWriter = stringWriter;
    }

    /**
     * Take a record from the input, and immediately write it to the output.
     */
    public void printString() {
        stringWriter.write(stringReader.getValue());
    }

    /** Get the value of the current line
     * @return string
     * */
    @Override
    public String getValue() {
        return this.stringReader.getValue();
    }

    /** Get the value of the next line if it exist
     * @return true if it has a next line
     * */
    @Override
    public boolean hasNext() {
        return this.stringReader.hasNext();
    }

    /** Write a given value
     * @param value value to be write
     * */
    @Override
    public void write(String value) {
        this.stringWriter.write(value);
    }
}
