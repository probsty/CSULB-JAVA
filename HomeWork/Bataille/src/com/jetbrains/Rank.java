package com.jetbrains;

/**
 * A class to record information about an individual.
 * Homework Assignment:
 *
 * @author Yann Probst
 * @version 1.01 10/17/2019
 */
public enum Rank {
    TWO(2),
    THREE(3),
    FOR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13),
    ACE(14)
    ;

    /** The value of the rank as an int. */
    private int rank;

    private Rank(int _rank) {
        this.rank = _rank;
    }

    /**
     * Get the enum value as an int.
     * @param _rank enum that need to returned.
     * @return the enum value in an integer.
     */
    public int getRankInteger(Rank _rank) {
        return _rank.rank;
    }
}
