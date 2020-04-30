package com.jetbrains;

import java.util.Objects;

/**
 * A class to record information about a Product.
 * Homework Assignment:
 *
 * @author Yann Probst
 * @version 1.01 03/03/2019
 */
public class Product {
    /** Product's name */
    String m_name;
    /** Product's price */
    double m_price;

    Product() {}

    Product(String _name, double _price) {
        m_name = _name;
        m_price = _price;
    }

    /**
     * Get the price of a product
     * @return the price of a product as a double
     */
    public double getPrice() {
        return m_price;
    }

    /**
     * Get the name of a product
     * @return the name of a product as a string
     */
    public String getName() {
        return m_name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "m_name='" + m_name + '\'' +
                ", m_price=" + m_price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.m_price, m_price) == 0 &&
                Objects.equals(m_name, product.m_name);
    }
}
