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
public class PromptForFile {

    public static void askUser() {
        System.out.println("Please enter the name of a file");
        Scanner in = new Scanner(System.in);
        String fileName = in.nextLine();
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File dont exist");
            askUser();
        }
    }

    public static void main(String[] args) {
        askUser();
    }
}