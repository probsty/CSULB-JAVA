package com.jetbrains;

/**
 * A class to read a string dependently.
 * Homework Assignment:
 *
 * @author Yann Probst
 * @version 1.01 10/17/2019
 */
public class StringProcessorDependent {
    /** The object that will do the reading for us */
    private final StringReaderImp stringReader;
    /** The object that will do the writing for us */
    private final StringWriterImp stringWriter;

    /**
     * Dependency injecting constructor.
     * @param stringReader	The reader that we'll use.
     * @param stringWriter	The writer that we'll use.
     */
    public StringProcessorDependent(StringReaderImp stringReader, StringWriterImp stringWriter) {
        this.stringReader = stringReader;
        this.stringWriter = stringWriter;
    }

    /**
     * Take a record from the input, and immediately write it to the output.
     */
    public void printString() {
        stringWriter.write(stringReader.getValue());
    }
}
