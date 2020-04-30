package com.jetbrains;

import java.io.Serializable;

public class State implements Serializable{
    private String name;
    private double population;

    public State (String name, double population) {
        this.name = name;
        this.population = population;
    }

    public String toString () {
        return "State: " + this.name + " Population: " + this.population + " million";
    }

}