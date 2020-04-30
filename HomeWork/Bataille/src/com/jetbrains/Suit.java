package com.jetbrains;

/**
 * A enum that old the different suit of a card.
 * Homework Assignment:
 *
 * @author Yann Probst
 * @version 1.01 28/01/2019
 */
public enum Suit {
    CLUBS,
    DIAMONDS,
    HEARTS,
    SPADES;

    /**
     * Format enum to a string in lowercase with the first letter in uppercase.
     * @param _suit enum that need to be convert.
     */
    public String getFormattedSuit(Suit _suit) {
        String output = _suit.toString().toLowerCase();
        output = output.substring(0, 1).toUpperCase() + output.substring(1);
        return output;
    }
}
