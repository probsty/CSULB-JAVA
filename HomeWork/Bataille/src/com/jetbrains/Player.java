package com.jetbrains;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A class to record information about a player.
 * Homework Assignment: War Game
 *
 * @author Yann Probst
 * @version 1.01 01/28/2019
 */
public class Player {
    /** The person's name. */
    private String m_name;

    /** The person's current status. */
    private boolean m_isAlive;
    /** The person's cards. */
    private ArrayList<Card> m_myCards;

    Player() {
        m_name = "";
        m_isAlive = true;
        m_myCards = new ArrayList<Card>();
    }

    Player(String _name) {
        m_name = _name;
        m_isAlive = true;
        m_myCards = new ArrayList<Card>();
    }

    /**
     * Get the number of cards of the player.
     * @return the number of cards.
     */
    public int getNumberOfCards() {
        return m_myCards.size();
    }

    /**
     * Add a specific card at the last position in the player desk.
     * @param _card Card that need to be added in the desk.
     */
    public void addCard(Card _card) {
        m_myCards.add(_card);
    }

    /**
     * Check if a player have enough card to played the war round.
     * @param _nb Number of cards that need to be checked.
     * @return Return true if the player can play the war round.
     */
    public boolean enoughCardsToPlay(int _nb) {
        return m_myCards.size() > _nb;
    }

    /**
     * Check if a player can play.
     * @return Return true if the player can play the round.
     */
    public boolean getIsAlive()
    {
        return m_isAlive;
    }

    /**
     * Get the cards of the player.
     * @return Return players card.
     */
    public ArrayList<Card> getCards() {
        return m_myCards;
    }

    /**
     * Get the name of the player.
     * @return Return players name.
     */
    public String getName(){
        return m_name;
    }

    /**
     * Set the players status.
     * @param _isAlive set true if the player can play.
     */
    public void setIsAlive(boolean _isAlive) {
        m_isAlive = _isAlive;
    }

    @Override
    public String toString() {
        return "Player{" +
                "m_name='" + m_name + '\'' +
                ", m_isAlive=" + m_isAlive +
                ", m_myCards=" + m_myCards +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return m_isAlive == player.m_isAlive &&
                Objects.equals(m_name, player.m_name) &&
                Objects.equals(m_myCards, player.m_myCards);
    }
}
