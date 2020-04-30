package com.jetbrains;

/**
 * A class to ask a true or false question.
 * Homework Assignment:
 *
 * @author Yann Probst
 * @version 1.01 10/17/2019
 */
public class TrueFalseQuestion extends Question {
    TrueFalseQuestion() {

    }

    TrueFalseQuestion(String _question, Boolean _response) {
        super.setText(_question);
        if (_response) {
            super.setAnswer("T");
        } else {
            super.setAnswer("F");
        }
    }

    /**
     Override the display function
     */
    @Override
    public void display() {
        System.out.println("True (T) or False (F):");
        super.display();
    }

    /**
     Override the checkAnswer function
     Check if a response is true or false
     */
    @Override
    public boolean checkAnswer(String _response) {
        return super.checkAnswer(_response.toUpperCase());
    }
}
