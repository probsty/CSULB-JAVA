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
public class CountMixed {

    public static void main(String[] args) {
        int count = 0;
        int lower = 0;
        int upper = 0;
        File file = new File("Mixed.txt");

        try (Scanner in = new Scanner(file)) {
            while (in.hasNext()) {
                Scanner readLine = new Scanner(in.next());
                String line = readLine.next();
                lower = 0;
                upper = 0;
                for (int i = 0; i < line.length(); i++) {
                    if (Character.isLowerCase(line.charAt(i))) {
                        lower++;
                    } else if (Character.isUpperCase(line.charAt(i))) {
                        upper++;
                    }
                }
                if (upper > 0 && lower > 0) {
                    count++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Lines: " + count);
    }
}