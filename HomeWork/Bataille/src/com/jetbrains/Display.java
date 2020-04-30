package com.jetbrains;

import java.util.ArrayList;

/**
 * A class to display information.
 * Homework Assignment: War Game
 *
 * @author Yann Probst
 * @version 1.01 01/28/2019
 */
public class Display {

    public static final int FIRST_CARD_OF_DECK = 0;
    public static final int FACE_CARD = 11;

    Display() {}

    /**
     * Display the card of the current player.
     * @param _player Current player
     */
    public void displayCard(Player _player)
    {
        Card playerCurrentCard = _player.getCards().get(FIRST_CARD_OF_DECK);
        System.out.printf("player %s plays Card is %s of %s value is %d\n", _player.getName(),
                playerCurrentCard.getRank(),
                playerCurrentCard.getSuit().getFormattedSuit(playerCurrentCard.getSuit()),
                playerCurrentCard.getRankInteger());
    }

    /**
     * Display the message of the winner of the round.
     * @param _player Winner
     */
    public void displayRoundWinner(Player _player) {
        System.out.printf("player %s wins the round\n", _player.getName());
    }

    /**
     * Display the message of the winner of the war round.
     * @param _player Winner
     */
    public void displayWarRoundWinner(Player _player) {
        System.out.printf("player %s wins the war round\n", _player.getName());
    }

    /**
     * Display the beginning message of the war.
     */
    public void displayWar() {
        System.out.println("war");
    }

    /**
     * Display the draw message.
     */
    public void displayDrawnGame() {
        System.out.println("Nobody Wins");
    }

    /**
     * Display the end of the game message.
     */
    public void displayGameOver() {
        System.out.println("game over");
    }

    /**
     * Display the winners name of the game.
     * @param _player Current player
     */
    public void displayWinner(Player _player) {
        System.out.printf("player %s wins the game\n", _player.getName());
    }

    /**
     * Display the war hidden card of the current player.
     * @param _player Current player
     */
    public void displayHiddenWarCard(Player _player) {
        System.out.printf("war card for player%s Card is xx\n", _player.getName());
    }

    /**
     * Display the war card of the current player.
     * @param _player Current player
     */
    public void displayWarCard(Player _player) {
        Card playerCurrentCard = _player.getCards().get(FIRST_CARD_OF_DECK);
        System.out.printf("war card player%s Card is %s of %s value is %d\n", _player.getName(),
                playerCurrentCard.getRank(),
                playerCurrentCard.getSuit().getFormattedSuit(playerCurrentCard.getSuit()),
                playerCurrentCard.getRankInteger());
    }

    /**
     * Display the number of cards of both players.
     * @param _player1 Player 1
     * @param _player1 Player 2
     */
    public void displayNumberOfCard(Player _player1, Player _player2) {
        int numberTotalOfCards = _player1.getNumberOfCards() + _player2.getNumberOfCards();
        System.out.printf("Player %s has: %d Player %s has: %d total: %d\n", _player1.getName(),
                _player1.getNumberOfCards(), _player2.getName(), _player2.getNumberOfCards(),
                numberTotalOfCards);
    }

    /**
     * Display the number of rounds.
     * @param _numberOfRound number of rounds
     */
    public void displayNumberOfRound(int _numberOfRound) {
        System.out.printf("Win took %d battles to win.\n", _numberOfRound);
    }

    /**
     * Display not enough card to play the war.
     * @param _winningHand cards in the winning hand deck
     */
    public void displayNotEnoughCardsForWar(ArrayList<Card> _winningHand) {
        System.out.printf("One of the player don't have enough cards to" +
                " play the war: size of the winning hand is %d. Nobody wins the winning hand, the game is over" +
                "\n", _winningHand.size());
    }
}
