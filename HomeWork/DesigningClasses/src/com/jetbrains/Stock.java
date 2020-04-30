package com.jetbrains;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * A class to record information the Stock of the vending machine.
 * Homework Assignment:
 *
 * @author Yann Probst
 * @version 1.01 03/03/2019
 */
public class Stock {
    /** ArrayList of product. */
    ArrayList<Product> m_inventory;

    Stock() {
        m_inventory = new ArrayList<>();
    }

    /**
     * Get the value of a product by his name
     * @param _name of the product
     * @return the value of the given name
     */
    public double priceOfProduct(String _name) {
        double price = 0;

        switch (_name) {
            case "diet pepsi":
                price = 1.25;
                break;
            case "water":
                price = 1.0;
                break;
            case "mars bar":
                price = 0.65;
                break;
            case "m&ms":
                price = 0.65;
                break;
            case "popcorn":
                price = 1.5;
                break;
            default:
                price = 0;
                break;
        }
        return price;
    }

    /**
     * Insert a product by his name and with a quantity
     * @param _name of the product
     * @param _quantity of the product
     */
    public void addProduct(String _name, int _quantity) {
        for (int i = 0; i < _quantity; i++) {
            m_inventory.add(new Product(_name, priceOfProduct(_name)));
        }
    }

    /**
     * Verify the product availability
     * @param _productNameToSearch of the product
     * @return true if the product is in stock
     */
    public boolean productAvailability(String _productNameToSearch) {
        boolean available = false;

        for (Product product : m_inventory) {
            if (product.getName().equals(_productNameToSearch)) {
                available = true;
            }
        }
        return available;
    }

    /**
     * Give the price of a given product if it is in stock
     * @param _productNameToSearch of the product
     * @return the price of the product
     */
    public double productPrice(String _productNameToSearch) {
        double price = 0.0;

        for (Product product : m_inventory) {
            if (product.getName().equals(_productNameToSearch)) {
                price = product.getPrice();
            }
        }
        return price;
    }

    /**
     * Give the quantity of a given product if it is in stock
     * @param _productNameToSearch of the product
     * @return the quantity of the product
     */
    public int productQuantity(String _productNameToSearch) {
        int numberOfProduct = 0;

        for (Product product : m_inventory) {
            if (product.getName().equals(_productNameToSearch)) {
                numberOfProduct++;
            }
        }

        return numberOfProduct;
    }

    /**
     * Remove a given product
     * @param _productNameToRemove of the product
     */
    public void removeProduct(String _productNameToRemove) {
        boolean removeOneProduct = false;

        for (int i = 0; i < m_inventory.size(); i++) {
            if (m_inventory.get(i).getName().equals(_productNameToRemove) && !removeOneProduct) {
                m_inventory.remove(i);
                removeOneProduct = true;
            }
        }
    }

    /**
     * Send a product list of the available product in the vending machine
     * @return product list
     */
    private List<String> productList() {
        List<String> productName = new ArrayList<>();

        for (Product product : m_inventory) {
            productName.add(product.getName());
        }

        List<String> newList = productName.stream().distinct().collect(Collectors.toList());

        return newList;
    }

    /**
     * Display the information's stock
     */
    public void showStockInfo() {
        /*List<String> productName = productList();

        for (String s : productName) {
            System.out.printf("%s Value: %.2f Quantity: %d\n", s, productPrice(s), productQuantity(s));
        }*/
        System.out.printf("Diet pepsi Value: %.2f Quantity: %d\n", priceOfProduct("diet pepsi"), productQuantity("diet pepsi"));
        System.out.printf("Water Value: %.2f Quantity: %d\n", priceOfProduct("water"), productQuantity("water"));
        System.out.printf("Mars bar Value: %.2f Quantity: %d\n", priceOfProduct("mars bar"), productQuantity("mars bar"));
        System.out.printf("M&ms Value: %.2f Quantity: %d\n", priceOfProduct("m&ms"), productQuantity("m&ms"));
        System.out.printf("Popcorn Value: %.2f Quantity: %d\n", priceOfProduct("popcorn"), productQuantity("popcorn"));
    }

    @Override
    public String toString() {
        return "Stock{" +
                "m_inventory=" + m_inventory +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return Objects.equals(m_inventory, stock.m_inventory);
    }
}
