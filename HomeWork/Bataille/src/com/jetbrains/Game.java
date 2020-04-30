package com.jetbrains;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A class to play the game.
 * Homework Assignment: War Game
 *
 * @author Yann Probst
 * @version 1.01 01/28/2019
 */
public class Game {
    /** Value if the round parameter is empty. */
    public static final int NO_ROUND = -1;

    /** Number of cards that need to be hidden in case of a war. */
    public static final int HIDDEN_CARDS = 3;

    /** The initial deck of cards. */
    private ArrayList<Card> m_deckOfCards;

    /** Player 1. */
    private Player m_player1;

    /** Player 2. */
    private Player m_player2;

    /** Dealer. */
    private Dealer m_dealer;

    /** Object that deals with the display of information. */
    private Display m_display;

    /** The winning hand. */
    private ArrayList<Card> m_winningHand;

    /** The number of turn to be played. */
    private int m_numberOfRound;

    Game() {

    }

    Game(String _namePlayer1, String _namePlayer2) {
        m_numberOfRound = NO_ROUND;
        initGame(_namePlayer1, _namePlayer2);
    }

    Game(String _namePlayer1, String _namePlayer2, int _numberOfRound) {
        m_numberOfRound = _numberOfRound;
        initGame(_namePlayer1, _namePlayer2);
    }

    /**
     * Main Loop to play a round.
     */
    public void play() {
        boolean game = true;
        int currentRound = 0;

        while (gameIsOver(game, currentRound)) {
            if (m_player1.enoughCardsToPlay(1) && m_player2.enoughCardsToPlay(1)
                    && m_player1.getIsAlive() && m_player2.getIsAlive()) {
                m_winningHand.removeAll(m_winningHand);
                round(); // play a new (round) card
                m_display.displayNumberOfCard(m_player1, m_player2);
            } else {
                game = false;
            }
            currentRound++;
        }
        displayWinner();
        m_display.displayNumberOfRound(currentRound);
    }

    /**
     * Initialize the game and give the cards to the player.
     */
    private void initGame(String _namePlayer1, String _namePlayer2) {
        m_player1 = new Player(_namePlayer1);
        m_player2 = new Player(_namePlayer2);
        m_display = new Display();
        m_winningHand = new ArrayList<>();
        m_deckOfCards = new ArrayList<>();
        m_dealer = new Dealer();
        m_dealer.doDealerTasks(m_player1, m_player2);
    }

    /**
     * Check if the game is set by a number of round or by a winning game.
     * @param _game value is set to true if the game is stopped only by a winner.
     * @param _currentRound number of round that the player is allowed to play
     * @return true if the game is over
     */
    private boolean gameIsOver(boolean _game, int _currentRound) {
        if (m_numberOfRound == NO_ROUND) {
            return _game;
        } else {
            if (_game && _currentRound < m_numberOfRound) {
                return true;
            }
        }
        return false;
    }

    /**
     * Play the visible card of the warRound.
     */
    private void warRound() {
        m_display.displayWarCard(m_player1);
        m_display.displayWarCard(m_player2);
        firstRound();
        if (m_player1.getCards().get(0).getRankInteger() < m_player2.getCards().get(0).getRankInteger()) {
            m_display.displayWarRoundWinner(m_player2);
            m_dealer.distributionOfEarnings(m_player2, m_winningHand);
        } else if (m_player1.getCards().get(0).getRankInteger() > m_player2.getCards().get(0).getRankInteger()) {
            m_display.displayWarRoundWinner(m_player1);
            m_dealer.distributionOfEarnings(m_player1, m_winningHand);
        } else {
            m_display.displayWar();
            hiddenWar();
        }
    }

    /**
     * Put the three hidden card on the table.
     */
    private void hiddenWar() {
        if (m_player1.enoughCardsToPlay(HIDDEN_CARDS + 1) && m_player2.enoughCardsToPlay(HIDDEN_CARDS + 1)) {
            for (int i = 0; i < HIDDEN_CARDS; i++) {
                m_display.displayHiddenWarCard(m_player1);
                m_display.displayHiddenWarCard(m_player2);
                m_winningHand.add(m_player1.getCards().get(i));
                m_winningHand.add(m_player2.getCards().get(i));
                m_player1.getCards().remove(0);
                m_player2.getCards().remove(0);
            }
            warRound();
        } else {
            m_display.displayNotEnoughCardsForWar(m_winningHand);
            checkWinnerPlayer();
        }
    }

    /**
     * Remove card of the players desk and add them to the winningHand.
     */
    private void firstRound() {
        m_winningHand.add(m_player1.getCards().get(0));
        m_winningHand.add(m_player2.getCards().get(0));
        m_player1.getCards().remove(0);
        m_player2.getCards().remove(0);
    }

    /**
     * Play a round of the game.
     */
    private void round() {
        m_display.displayCard(m_player1);
        m_display.displayCard(m_player2);
        if (m_player1.getCards().get(0).getRankInteger() < m_player2.getCards().get(0).getRankInteger()) {
            firstRound();
            m_display.displayRoundWinner(m_player2);
            m_dealer.distributionOfEarnings(m_player2, m_winningHand);
        } else if (m_player1.getCards().get(0).getRankInteger() > m_player2.getCards().get(0).getRankInteger()) {
            firstRound();
            m_display.displayRoundWinner(m_player1);
            m_dealer.distributionOfEarnings(m_player1, m_winningHand);
        } else {
            firstRound();
            m_display.displayWar();
            hiddenWar();
        }
    }

    /**
     * Display information at the end of the game.
     */
    private void displayWinner() {
        if (!(m_player1.getIsAlive()) && !(m_player2.getIsAlive())) {
            if (m_player1.getCards().size() > m_player2.getCards().size()) {
                m_display.displayGameOver();
                m_display.displayWinner(m_player1);
            } else if (m_player1.getCards().size() < m_player2.getCards().size()) {
                m_display.displayGameOver();
                m_display.displayWinner(m_player2);
            } else {
                m_display.displayDrawnGame();
            }
        } else if (m_player1.getIsAlive()) {
            m_display.displayGameOver();
            m_display.displayWinner(m_player1);
        } else {
            m_display.displayGameOver();
            m_display.displayWinner(m_player2);
        }
    }

    /**
     * Check which player won
     */
    private void checkWinnerPlayer() {
        if (!(m_player1.enoughCardsToPlay(HIDDEN_CARDS + 1)) && !(m_player2.enoughCardsToPlay(HIDDEN_CARDS + 1))) {
            m_player1.setIsAlive(false);
            m_player2.setIsAlive(false);
        } else if (m_player1.enoughCardsToPlay(HIDDEN_CARDS + 1)) {
            m_player2.setIsAlive(false);
        } else {
            m_player1.setIsAlive(false);
        }
    }

    @Override
    public String toString() {
        return "Game{" +
                "m_deckOfCards=" + m_deckOfCards +
                ", m_player1=" + m_player1 +
                ", m_player2=" + m_player2 +
                ", m_display=" + m_display +
                ", m_winningHand=" + m_winningHand +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return m_numberOfRound == game.m_numberOfRound &&
                Objects.equals(m_deckOfCards, game.m_deckOfCards) &&
                Objects.equals(m_player1, game.m_player1) &&
                Objects.equals(m_player2, game.m_player2) &&
                Objects.equals(m_display, game.m_display) &&
                Objects.equals(m_winningHand, game.m_winningHand);
    }
}
