package com.jetbrains;

/**
 A class to record information about question.
 Lab Assignment: Inheritance
 @author Yann Probst
 @version 1.01 02/04/2020
 */

public class Question
{
    /** Question text. */
    private String m_text;

    /** Answer text. */
    private String m_answer;

    /** Constructs a question with empty question and answer. */
    public Question() {
        m_text = "";
        m_answer = "";
    }

    /**
     Sets the question text.
     @param _questionText the text of this question
     */
    public void setText(String _questionText) {
        m_text = _questionText;
    }

    /**
     Sets the answer for this question.
     @param _correctResponse the answer
     */
    public void setAnswer(String _correctResponse) {
        m_answer = _correctResponse;
    }

    /**
     Checks a given response for correctness.
     @param _response the response to check
     @return true if the response was correct, false otherwise
     */
    public boolean checkAnswer(String _response) {
        return _response.equals(m_answer);
    }

    /**
     Displays this question.
     */
    public void display() {
        System.out.println(m_text);
    }
}