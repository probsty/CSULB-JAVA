package com.jetbrains;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Manage user choice.
 * Midterm Assignment:
 *
 * @author Yann Probst
 * @version 1.01 03/26/2020
 */
public class AddDoubles {

    public static void main(String[] args) {
        double tally = 0D;
        File file = new File("Doubles.txt");

        try (Scanner in = new Scanner(file)) {
            in.useDelimiter("[^0-9,]+");
            while (in.hasNextDouble()) {
                tally += in.nextDouble();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Tally: " + tally);
    }
}