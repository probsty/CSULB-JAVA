package com.jetbrains;

/**
 * An enum to record information about date's classes.
 * Homework Assignment:
 *
 * @author Yann Probst
 * @version 1.01 1.01 03/11/2020
 */
public enum Date {
    MONDAY_WEDNESDAY,
    TUESDAY_THURSDAY,
    FRIDAY,
    SATURDAY;

    public String to_string() {
        String name = this.name().replace("_", " ");
        name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        return name;
    }
}