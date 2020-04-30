package com.jetbrains;
import java.lang.reflect.Array;
import java.util.Scanner;

/**
 A class to test the programme
 Lab Assignment: Inheritance
 @author Yann Probst
 @version 1.01 02/04/2020
 */

public class QuestionDemo2
{
    /** Number of questions */
    public static final int NUMBER_OF_QUESTION = 3;

    public static void main(String[] args)
    {
        Question[] questions = new Question[NUMBER_OF_QUESTION + 1];
        ChoiceQuestion first = new ChoiceQuestion();
        ChoiceQuestion second = new ChoiceQuestion();
        TrueFalseQuestion third = new TrueFalseQuestion("It is possible to override every single method that you inherit from a supertype", false);
        questions[0] = first;
        questions[1] = second;
        questions[2] = third;
        first.setText("What was the original name of the Java language?");
        first.addChoice("*7", false);
        first.addChoice("Duke", false);
        first.addChoice("Oak", true);
        first.addChoice("Gosling", false);

        second.setText("In which country was the inventor of Java born?");
        second.addChoice("Australia", false);
        second.addChoice("Canada", true);
        second.addChoice("Denmark", false);
        second.addChoice("United States", false);

        for (int i = 0; i < NUMBER_OF_QUESTION; i++) {
            presentQuestion(questions[i]);
        }
        System.out.println("Completed Satisfactorily");
    }

    /**
     Presents a question to the user and checks the response.
     * @param _q the question
     */
    public static void presentQuestion(Question _q) {
        _q.display();
        System.out.print("Your answer: ");
        Scanner in = new Scanner(System.in);
        String response = in.nextLine();
        System.out.println(_q.checkAnswer(response));
    }
}