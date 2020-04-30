package com.jetbrains;

/**
 * Main class.
 * Homework Assignment:
 *
 * @author Yann Probst
 * @version 1.01 10/17/2019
 */
public class DependencyInversionRunner {
    public static void main(String[] args) {
        // cree instance en disant que ca appartient a stringreaderimp
        // pareil pour writer
        StringReader sr = new StringReaderImp();
        StringWriter sw = new StringWriterImp();
        StringProcessor SPD = new StringProcessor(sr, sw);
        while (SPD.hasNext()) {
            SPD.printString();
        }
        SPD.write("Completed successfully");
    }
}
