package com.jetbrains;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A class to record information about a CoinCollector.
 * Homework Assignment:
 *
 * @author Yann Probst
 * @version 1.01 03/03/2019
 */
public class CoinCollector {
    /** ArrayList of coins. */
    ArrayList<Coin> m_coins;

    CoinCollector() {
        m_coins = new ArrayList<>();
    }

    /**
     * Get the value of a coin by his name
     * @param _name of the coin
     * @return the value of the given name
     */
    public double valueOfCoin(String _name) {
        double value = 0;

        switch (_name) {
            case "dollar":
                value = 1.0;
                break;
            case "half dollar":
                value = 0.5;
                break;
            case "quarter":
                value = 0.25;
                break;
            case "dime":
                value = 0.1;
                break;
            case "nickel":
                value = 0.05;
                break;
            case "penny":
                value = 0.01;
                break;
            default:
                value = 0;
                break;
        }
        return value;
    }

    /**
     * Search the quantity of a specific coin
     * @param _coinNameToSearch of the coin
     * @return the total number of coin of that given coin
     */
    public int specificCoinQuantity(String _coinNameToSearch) {
        int numberOfCoin = 0;

        for (Coin coin : m_coins) {
            if (coin.getName().equals(_coinNameToSearch)) {
                numberOfCoin++;
            }
        }

        return numberOfCoin;
    }

    /**
     * Insert a coin by his name
     * @param _name of the coin
     */
    public void insertCoin(String _name) {
        m_coins.add(new Coin(_name, valueOfCoin(_name)));
    }

    /**
     * Insert a coin
     * @param _coin coin to add
     */
    public void insertCoin(Coin _coin) {
        m_coins.add(new Coin(_coin));
    }

    /**
     * Get a specific coin
     * @param i index of the coin you want
     * @return coin te return
     */
    public Coin getSpecificCoin(int i) {
        return m_coins.get(i);
    }

    /**
     * Remove a specific coin
     * @param i index of the coin we want to remove
     */
    public void removeSpecificCoin(int i) {
        m_coins.remove(i);
    }

    /**
     * Get a specific coin name
     * @param i index of the coin
     * @return name of the specific coin
     */
    public String getSpecificCoinName(int i) {
        return m_coins.get(i).getName();
    }

    /**
     * Get the amount of all the coins
     * @return amount of all the coins
     */
    public double getTotalValueOfCoins() {
        double amount = 0.0;

        for (Coin m_coin : m_coins) {
            amount += m_coin.getValue();
        }
        return amount;
    }

    /**
     * Get the size of the list
     * @return the number of element
     */
    public int getNumberOfCoins() {
        return m_coins.size();
    }

    /**
     * Display coins info
     */
    public void showCoinsInfo() {
        System.out.printf("Penny Value: %.2f Quantity: %d\n", valueOfCoin("penny"), specificCoinQuantity("penny"));
        System.out.printf("Nickel Value: %.2f Quantity: %d\n", valueOfCoin("nickel"), specificCoinQuantity("nickel"));
        System.out.printf("Dime Value: %.2f Quantity: %d\n", valueOfCoin("dime"), specificCoinQuantity("dime"));
        System.out.printf("Quarter Value: %.2f Quantity: %d\n", valueOfCoin("quarter"), specificCoinQuantity("quarter"));
        System.out.printf("Half dollar Value: %.2f Quantity: %d\n", valueOfCoin("half dollar"), specificCoinQuantity("half dollar"));
        System.out.printf("Dollar Value: %.2f Quantity: %d\n", valueOfCoin("dollar"), specificCoinQuantity("dollar"));
    }

    @Override
    public String toString() {
        return "CoinCollector{" +
                "m_coins=" + m_coins +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoinCollector that = (CoinCollector) o;
        return Objects.equals(m_coins, that.m_coins);
    }
}
