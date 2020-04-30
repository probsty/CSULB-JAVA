package com.jetbrains;

import java.util.Objects;
import java.util.Scanner;

/**
 * A class to record information about the Vending machine.
 * Homework Assignment:
 *
 * @author Yann Probst
 * @version 1.01 03/03/2019
 */
public class VendingMachine {
    /** Stock of the vending machine. */
    Stock m_stock;
    /** Money in the till. */
    CoinCollector m_coinTill;
    /** Current money of the user. */
    CoinCollector m_currentCoin;
    /** Scanner to read user's input. */
    Scanner m_sc;
    /** Single Instance of the input error manager. */
    InputError m_inputErrorManager;

    VendingMachine() {
        m_sc = new Scanner(System.in);
        m_inputErrorManager = InputError.getInstance();
        m_coinTill = new CoinCollector();
        m_currentCoin = new CoinCollector();
        m_stock = new Stock();
        m_stock.addProduct("diet pepsi",0);
        m_stock.addProduct("water", 0);
        m_stock.addProduct("mars bar",0);
        m_stock.addProduct("m&ms",0);
        m_stock.addProduct("popcorn",0);
    }

    /**
     * Ask and add a product in the vending machine
     */
    public void addProduct() {
        m_stock.showStockInfo();
        String userResponseName = m_sc.nextLine().toLowerCase();
        if (m_inputErrorManager.checkProduct(userResponseName)) {
            System.out.printf("How many of %s are you adding?-->", userResponseName);
            String userResponseQuantity = m_sc.nextLine();
            if (m_inputErrorManager.checkNumber(userResponseQuantity)) {
                m_stock.addProduct(userResponseName, Integer.parseInt(userResponseQuantity));
            }
        }
    }

    /**
     * Show the product list
     */
    public void showProduct() {
        m_stock.showStockInfo();
    }

    /**
     * Insert coin in the vending machine
     */
    public void insertCoins() {
        m_coinTill.showCoinsInfo();
        String userCoinToAdd = m_sc.nextLine().toLowerCase();
        if (m_inputErrorManager.checkCoin(userCoinToAdd)) {
            m_currentCoin.insertCoin(userCoinToAdd);
            System.out.printf("You have put: %.2f into the machine.\n", m_currentCoin.getTotalValueOfCoins());
        }
    }

    /**
     * Transfer the user coin into the till of the vending machine
     */
    private void transferCurrentCoinIntoTill() {
        for (int i = 0; i < m_currentCoin.getNumberOfCoins(); i++) {
            System.out.printf("Putting a: %s into the till\n", m_currentCoin.getSpecificCoinName(i));
            m_coinTill.insertCoin(m_currentCoin.getSpecificCoin(i));
            m_currentCoin.removeSpecificCoin(i);
        }
    }

    /**
     * Selling process, remove a product and display the selling process
     * @param _userDrinkChoice user's drink choice's
     */
    private void sellingProcess(String _userDrinkChoice) {
        m_stock.removeProduct(_userDrinkChoice);
        System.out.printf("Purchasing a: %s Value: %.2f Quantity: %d\n",
                _userDrinkChoice,
                m_stock.priceOfProduct(_userDrinkChoice),
                m_stock.productQuantity(_userDrinkChoice));
        System.out.printf("Putting a: %s Value: %.2f Quantity: %d\n",
                _userDrinkChoice,
                m_stock.priceOfProduct(_userDrinkChoice),
                m_stock.productQuantity(_userDrinkChoice));
        while (m_currentCoin.getNumberOfCoins() > 0) {
            transferCurrentCoinIntoTill();
        }
    }

    /**
     * Ask and sell a product
     */
    public void sellProduct() {
        m_stock.showStockInfo();
        String userDrinkChoice = m_sc.nextLine().toLowerCase();
        if (m_inputErrorManager.checkProduct(userDrinkChoice)) {
            if (m_stock.productAvailability(userDrinkChoice)) {
                if (m_currentCoin.getTotalValueOfCoins() >= m_stock.priceOfProduct(userDrinkChoice)) {
                    sellingProcess(userDrinkChoice);
                    m_coinTill.showCoinsInfo();
                } else {
                    System.out.println("Please, insert more coins");
                }
            } else {
                System.out.printf("Sorry, we are fresh out of %s Value: %.2f Quantity: %d\n",
                        userDrinkChoice,
                        m_stock.priceOfProduct(userDrinkChoice),
                        m_stock.productQuantity(userDrinkChoice));
            }
        }
    }

    @Override
    public String toString() {
        return "VendingMachine{" +
                "m_stock=" + m_stock +
                ", m_coinTill=" + m_coinTill +
                ", m_currentCoin=" + m_currentCoin +
                ", m_sc=" + m_sc +
                ", m_inputErrorManager=" + m_inputErrorManager +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VendingMachine that = (VendingMachine) o;
        return Objects.equals(m_stock, that.m_stock) &&
                Objects.equals(m_coinTill, that.m_coinTill) &&
                Objects.equals(m_currentCoin, that.m_currentCoin) &&
                Objects.equals(m_sc, that.m_sc) &&
                Objects.equals(m_inputErrorManager, that.m_inputErrorManager);
    }
}
