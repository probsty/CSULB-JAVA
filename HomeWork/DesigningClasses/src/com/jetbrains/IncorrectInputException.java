package com.jetbrains;

/**
 * A class to manage exception.
 * Homework Assignment:
 *
 * @author Yann Probst
 * @version 1.01 03/03/2019
 */
public class IncorrectInputException extends RuntimeException {
    public IncorrectInputException(String errorMessage) {
        super(errorMessage);
    }
}
