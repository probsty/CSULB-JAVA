package com.jetbrains;
import java.util.ArrayList;

/**
 A class to record information about the choice of a question.
 Lab Assignment: Inheritance
 @author Yann Probsy
 @version 1.01 02/04/2020
 */

public class ChoiceQuestion extends Question
{
    /** ArrayList of choices of a question. */
    private ArrayList<String> m_choices;

    /**
     Constructs a choice question with no choices.
     */
    public ChoiceQuestion() {
        m_choices = new ArrayList<>();
    }

    /**
     Adds an answer choice to this question.
     @param _choice the choice to add
     @param _correct true if this is the correct choice, false otherwise
     */
    public void addChoice(String _choice, boolean _correct)
    {
        m_choices.add(_choice);
        if (_correct) {
            // Convert choices.size() to string
            String choiceString = "" + m_choices.size();
            setAnswer(choiceString);
        }
    }

    /**
     Display the question and the answer choices
     */
    @Override
    public void display()
    {
        // Display the question text
        super.display();
        int choiceNumber = 0;
        // Display the answer choices
        for (int i = 0; i < m_choices.size(); i++) {
            choiceNumber = i + 1;
            System.out.println(choiceNumber + ": " + m_choices.get(i));
        }
    }
}