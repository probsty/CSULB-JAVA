package com.jetbrains;

/**
 * main cl.ass
 * Homework Assignment:
 *
 * @author Yann Probst
 * @version 1.01 10/17/2019
 */
public class DependencyInversionDependentRunner {

    public static void main(String[] args) {
        StringReaderImp sr = new StringReaderImp ();
        StringWriterImp sw = new StringWriterImp ();
        StringProcessorDependent SPD = new StringProcessorDependent (sr, sw);
        while (sr.hasNext()) {
            SPD.printString();
        }
        sw.write("Completed successfully");
    }
}
