package com.jetbrains;
import java.util.Scanner;

/**
 * A class to read.
 * Homework Assignment:
 *
 * @author Yann Probst
 * @version 1.01 10/17/2019
 */
public class StringReaderImp implements StringReader {

    //For this simple example, we build our own Scanner object to read in lines of text.
    //This creates a dependency of StringReaderImp on the System.in and Scanner classes,
    //and we could have had them passed in as arguments to the constructor to reduce the
    //dependency.
    Scanner in;
    public StringReaderImp () {
        //squirrel away our input scanner for later.  Ideally, we would use a
        //factory here to make sure that we only have one System.in scanner
        //at a time since multiple System.in Scanners never seems to work right.
        MyScanner temp = new MyScanner();
        this.in = temp.getScanner();
    }

    /** Get the value of the current line
     * @return string
     * */
    @Override
    public String getValue() {
        String line;
        line = this.in.nextLine();
        return line;
    }

    /** Get the value of the next line if it exist
     * @return true if it has a next line
     * */
    @Override
    public boolean hasNext() {
        return this.in.hasNextLine();
    }
}