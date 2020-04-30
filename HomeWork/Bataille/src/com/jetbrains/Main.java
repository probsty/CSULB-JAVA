package com.jetbrains;

/**
 * A class to record information about an individual.
 * Homework Assignment: War Game
 *
 * @author Yann Probst
 * @version 1.01 01/28/2019
 */
public class Main extends Game {
    public static void main(String[] args) {
        Game game = new Game("1", "2");
        game.play();
        System.out.println("Completed Satisfactorily");
    }
}
