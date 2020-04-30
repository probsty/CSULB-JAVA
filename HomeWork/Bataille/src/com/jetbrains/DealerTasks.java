package com.jetbrains;

import java.util.ArrayList;

/**
 * A class to record information about an individual.
 * Homework Assignment: War Game
 *
 * @author Yann Probst
 * @version 1.01 01/28/2019
 */
public interface DealerTasks {
    /**
     * Shuffle a given deck of card.
     * @param _deckOfCards cards that need to be shuffle.
     */
    void shuffleCards(ArrayList<Card> _deckOfCards);
    /**
     * Deal a given deck of card.
     * @param _player1 player number one.
     * @param _player2 player number two.
     * @param _deckOfCards cards that need to be deal.
     */
    void dealCards(Player _player1, Player _player2, ArrayList<Card> _deckOfCards);
    /**
     * Distribution of earnings.
     * @param _winner player who won the round.
     * @param _winningCards cards that the player wins.
     */
    void distributionOfEarnings(Player _winner, ArrayList<Card> _winningCards);
    /**
     * Generate a deck of card.
     * @return deck of cards
     */
    ArrayList<Card> generateCards();
}
