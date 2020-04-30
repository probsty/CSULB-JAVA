package com.jetbrains;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A class to record information about an individual.
 * Homework Assignment:
 *
 * @author Yann Probst
 * @version 1.01 10/17/2019
 */
public class Dealer implements DealerTasks{

    public static final int NUMBER_OF_SUIT = 4;
    public static final int MINIMUM_CARD_VALUE = 0;
    public static final int MAXIMUM_CARD_VALUE = 12;

    Dealer() {

    }

    /**
     * Do the dealer tasks before the game begin.
     */
    public void doDealerTasks(Player _player1, Player _player2) {
        ArrayList<Card> _deckOfCards = generateCards();
        shuffleCards(_deckOfCards);
        dealCards(_player1, _player2, _deckOfCards);
    }

    @Override
    public void shuffleCards(ArrayList<Card> _deckOfCards) {
        Collections.shuffle(_deckOfCards);
    }

    @Override
    public void dealCards(Player _player1, Player _player2, ArrayList<Card> _deckOfCards) {
        for (int i = 0; i < _deckOfCards.size(); i++) {
            if (i % 2 == 0) {
                _player1.addCard(_deckOfCards.get(i));
            } else {
                _player2.addCard(_deckOfCards.get(i));
            }
        }
    }

    @Override
    public void distributionOfEarnings(Player _winner, ArrayList<Card> _winningHand) {
        for (Card currentCard : _winningHand) {
            _winner.addCard(currentCard);
        }
    }

    @Override
    public ArrayList<Card> generateCards() {
        ArrayList<Card> deckOfCards = new ArrayList<Card>();
        for (int i = 0; i < NUMBER_OF_SUIT; i++) {
            for (int valueOfCard = MINIMUM_CARD_VALUE; valueOfCard <= MAXIMUM_CARD_VALUE; valueOfCard++) {
                deckOfCards.add(new Card(Rank.values()[valueOfCard], Suit.values()[i]));
                //System.out.println(Rank.values()[valueOfCard]);
            }
        }
        return deckOfCards;
    }
}
