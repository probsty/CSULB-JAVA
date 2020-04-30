package com.jetbrains;

import static com.jetbrains.Suit.*;
import static com.jetbrains.Rank.*;

/**
 * A class to record information about a Card.
 * Homework Assignment: War Game
 *
 * @author Yann Probst
 * @version 1.01 01/28/2019
 */

public class Card {
    /** Rank of the card. */
    private Rank m_rank;
    /** Suit of the card. */
    private Suit m_suit;

    Card() {
        System.out.println("Default argument of the card is 2 of Hearts");
        m_rank = TWO;
        m_suit = CLUBS;
    }

    Card(Rank _rank, Suit _suit) {
        m_rank = _rank;
        m_suit = _suit;
    }

    /**
     * Give the rank of the card
     * @return the rank of the card
     */
    public int getRankInteger() {
        return m_rank.getRankInteger(m_rank);
    }

    /**
     * Give the rank of the card
     * @return the rank of the card
     */
    public String getRank() {
        String output = m_rank.toString().toLowerCase();
        output = output.substring(0, 1).toUpperCase() + output.substring(1);
        return output;
    }

    /**
     * Give the suit of the card
     * @return the suit of the card
     */
    public Suit getSuit() {
        return m_suit;
    }

    @Override
    public String toString() {
        return "Card{" +
                "m_rank=" + m_rank +
                ", m_suit=" + m_suit.getFormattedSuit(m_suit) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return m_rank == card.m_rank &&
                m_suit == card.m_suit;
    }
}
