package com.jetbrains;

import java.util.Objects;

/**
 * A class to record information about a coin.
 * Homework Assignment:
 *
 * @author Yann Probst
 * @version 1.01 03/03/2019
 */
public class Coin {
    /** The Coin’s name. */
    String m_name;
    /** The Coin’s value. */
    double m_value;

    Coin() {}

    Coin(String _name, double _value) {
        m_name = _name;
        m_value = _value;
    }

    Coin(Coin _coin) {
        m_name = _coin.getName();
        m_value = _coin.getValue();
    }

    /**
     * Get the value of a coin
     * @return the value of a coin in double
     */
    public double getValue() {
        return m_value;
    }

    /**
     * Get the name of a coin
     * @return the name of a coin as a String
     */
    public String getName() {
        return m_name;
    }

    @Override
    public String toString() {
        return "Coin{" +
                "m_name='" + m_name + '\'' +
                ", m_value=" + m_value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coin coin = (Coin) o;
        return Double.compare(coin.m_value, m_value) == 0 &&
                Objects.equals(m_name, coin.m_name);
    }
}
