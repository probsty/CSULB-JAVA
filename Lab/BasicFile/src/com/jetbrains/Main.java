package com.jetbrains;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static String fileToRead(JFileChooser _fileChooser){
        String fileWhereIRead = null;

        _fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int returnVal = _fileChooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            fileWhereIRead = _fileChooser.getSelectedFile().getAbsolutePath();
        }
        return fileWhereIRead;
    }

    public static String fileToWrite(JFileChooser _fileChooser){
        String fileWhereIWrite = null;

        _fileChooser.setDialogTitle("Please select an output file");
        _fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int returnVal = _fileChooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            fileWhereIWrite = _fileChooser.getSelectedFile().getAbsolutePath();
        }

        return fileWhereIWrite;
    }

    public static void writingReadingFile(File fileToRead, File fileToWrite) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(fileToWrite, true));
        writer.printf("Where i read my file: %s\n", fileToRead);
        writer.printf("Where i write my file: %s\n", fileToWrite);
        writer.close();
    }

    public static void countRecords(File fileToRead, File fileToWrite) throws IOException {
        Scanner sc = new Scanner(fileToRead);
        PrintWriter writer = new PrintWriter(new FileWriter(fileToWrite, true));
        int count = 0;

        while (sc.hasNextLine()) {
            count++;
            sc.nextLine();
        }
        writer.printf("Number of recors/lines: %d\n", count);
        sc.close();
        writer.close();
    }

    public static void countWords(File fileToRead, File fileToWrite) throws IOException {
        Scanner sc = new Scanner(fileToRead);
        PrintWriter writer = new PrintWriter(new FileWriter(fileToWrite, true));
        int count = 0;

        while (sc.hasNext()) {
            count++;
            sc.next();
        }
        writer.printf("Number of words: %d\n", count);
        sc.close();
        writer.close();
    }

    public static void countUpperCase(File fileToRead, File fileToWrite) throws IOException {
        Scanner sc = new Scanner(fileToRead);
        PrintWriter writer = new PrintWriter(new FileWriter(fileToWrite, true));
        int count = 0;

        while (sc.hasNext()) {
            Scanner readLine = new Scanner(sc.next());
            String line = readLine.next();
            for (int i = 0; i < line.length(); i++) {
               if (Character.isUpperCase(line.charAt(i))) {
                    count++;
               }
            }
            readLine.close();
        }
        writer.printf("Number of upper case: %d\n", count);
        sc.close();
        writer.close();
    }

    public static void countLowerCase(File fileToRead, File fileToWrite) throws IOException {
        Scanner sc = new Scanner(fileToRead);
        PrintWriter writer = new PrintWriter(new FileWriter(fileToWrite, true));
        int count = 0;

        while (sc.hasNext()) {
            Scanner readLine = new Scanner(sc.next());
            String line = readLine.next();
            for (int i = 0; i < line.length(); i++) {
                if (Character.isLowerCase(line.charAt(i))) {
                    count++;
                }
            }
            readLine.close();
        }
        writer.printf("Number of lower case: %d\n", count);
        sc.close();
        writer.close();
    }

    public static void countDigits(File fileToRead, File fileToWrite) throws IOException {
        Scanner sc = new Scanner(fileToRead);
        PrintWriter writer = new PrintWriter(new FileWriter(fileToWrite, true));
        int count = 0;

        while (sc.hasNext()) {
            Scanner readLine = new Scanner(sc.next());
            String line = readLine.next();
            for (int i = 0; i < line.length(); i++) {
                if (Character.isDigit(line.charAt(i))) {
                    count++;
                }
            }
            readLine.close();
        }
        writer.printf("Number of digit: %d\n", count);
        sc.close();
        writer.close();
    }

    public static void countNumbers(File fileToRead, File fileToWrite) throws IOException {
        Scanner sc = new Scanner(fileToRead);
        PrintWriter writer = new PrintWriter(new FileWriter(fileToWrite, true));

        int count = 0;

        while (sc.hasNext()) {
            String s = sc.next();
            try {
                Double.parseDouble(s);
                count++;
            } catch (NumberFormatException nfe) {
                ;
            }
        }
        writer.printf("Current words: %d\n", count);
        sc.close();
        writer.close();
    }

    public static void countSpecialCharacters(File fileToRead, File fileToWrite) throws IOException {
        Scanner sc = new Scanner(fileToRead);
        PrintWriter writer = new PrintWriter(new FileWriter(fileToWrite, true));
        int count = 0;

        while (sc.hasNext()) {
            Scanner readLine = new Scanner(sc.next());
            String line = readLine.next();
            for (int i = 0; i < line.length(); i++) {
                if (line.substring(i, i+1).matches("[^A-Za-z0-9]")) {
                    count++;
                }
            }
            readLine.close();
        }
        writer.printf("Number of special characters: %d\n", count);
        sc.close();
        writer.close();
    }

    public static void numberOfBytes(File fileToRead, File fileToWrite) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(fileToWrite, true));
        writer.printf("Number bytes: %d\n", fileToRead.length());
        writer.close();
    }

    public static void listOfSpecialCharacters(File fileToRead, File fileToWrite) throws IOException {
        Scanner sc = new Scanner(fileToRead);
        PrintWriter writer = new PrintWriter(new FileWriter(fileToWrite, true));

        while (sc.hasNext()) {
            Scanner readLine = new Scanner(sc.next());
            String line = readLine.next();
            for (int i = 0; i < line.length(); i++) {
                if (line.substring(i, i+1).matches("[^A-Za-z0-9]")) {
                    writer.printf("Special character: %s Ascii value: %d\n", line.substring(i, i+1), (int)line.charAt(i));
                }
            }
            readLine.close();
        }
        sc.close();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        String fileWhereIWrite;
        String fileWhereIRead;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Please select an input file");
        fileWhereIRead = fileToRead(fileChooser);
        fileWhereIWrite = fileToWrite(fileChooser);

        File fileToRead = new File(fileWhereIRead);
        File fileToWrite = new File(fileWhereIWrite);

        writingReadingFile(fileToRead, fileToWrite);
        countRecords(fileToRead, fileToWrite); //records = lines ?
        countWords(fileToRead, fileToWrite);
        countUpperCase(fileToRead, fileToWrite);
        countLowerCase(fileToRead, fileToWrite);
        countDigits(fileToRead, fileToWrite);
        countNumbers(fileToRead, fileToWrite);
        countSpecialCharacters(fileToRead, fileToWrite);
        numberOfBytes(fileToRead, fileToWrite);
        listOfSpecialCharacters(fileToRead, fileToWrite);
    }
}
