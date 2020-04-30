package com.company;
import java.io.IOException;
import java.util.EnumSet;
import java.util.Scanner;

public class MementoRunner {
    public static String getNameInfo(String question) {
        Scanner sc = new Scanner(System.in);
        System.out.println(question);

        String name = sc.nextLine();
        if (name.length() == 0) {
            System.out.println("Bad input");
            return getNameInfo(question);
        }
        return name;
    }

    public static Person.HairColor getHairColor() {
        int i = 0;
        for (Person.HairColor info : EnumSet.allOf(Person.HairColor.class)) {
            System.out.printf("%d: %s\n", i, info);
            i++;
        }
        System.out.println("Please enter the # corresponding to the hair color:");
        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine();
        try {
            double value = Double.parseDouble(id);
            if (value < 0) {
                System.out.println("ID should be positive or equal to 0");
                return getHairColor();
            } else if (value > Person.HairColor.values().length - 1) {
                System.out.printf("ID should be lower than %d\n", Person.HairColor.values().length);
                return getHairColor();
            }
        } catch (NumberFormatException e) {
            System.out.println("ID:  "+ id + "is not a number");
            return getHairColor();
        }
        System.out.printf("You entered color %s\n", Person.HairColor.getColor(Integer.parseInt(id)));
        return Person.HairColor.getColor(Integer.parseInt(id));
    }

    public static int getHeightFeet(Person person) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Person's height in feet:");
        String height = sc.nextLine();
        try {
            int value = Integer.parseInt(height);
            person.setHeight(value, 0);

        } catch (NumberFormatException e) {
            System.out.println("Height:  "+ height + "is not a number");
            return getHeightFeet(person);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getHeightFeet(person);
        }
        return Integer.parseInt(height);
    }

    public static int getHeightInches(Person person) {
        Scanner sc = new Scanner(System.in);
        System.out.println("And the inches? For instance, 5'10' would be 10:");
        String inches = sc.nextLine();
        try {
            int value = Integer.parseInt(inches);
            person.setHeight(person.getHeightFeet(), value);
        } catch (NumberFormatException e) {
            System.out.println("Height:  "+ inches + "is not a number");
            return getHeightInches(person);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getHeightInches(person);
        }
        return Integer.parseInt(inches);
    }

    public static int getWeight(Person person) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Their weight in pounds:");
        String weight = sc.nextLine();
        try {
            int value = Integer.parseInt(weight);
            person.setWeight(value);
        } catch (NumberFormatException e) {
            System.out.println("Weight:  "+ weight + "is not a number");
            return getWeight(person);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWeight(person);
        }
        return Integer.parseInt(weight);
    }

    public static boolean shouldContinue() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Are we done here(Y/N):");
        String finish = sc.nextLine().toUpperCase();
        if (finish.length() == 1) {
            if (finish.charAt(0) == 'Y') {
                return true;
            } else if (finish.charAt(0) == 'N') {
                return false;
            }
        }
        System.out.println("Please enter a valid format.");
        return shouldContinue();
    }

    public static void  getSkinniestVersion(Person person, CareTaker ct) throws IOException {
        person.restore(ct.getMemento());
        System.out.println("Skinniest version");
        System.out.println(ct.getMemento().getSavedPerson().toString());
    }

    public static int  searchSpecificWeight(Person person, CareTaker ct) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("What weight do you want to search for ?");
        String weight = sc.nextLine();

        try {
            int value = Integer.parseInt(weight);
        } catch (NumberFormatException e) {
            System.out.println("Weight:  "+ weight + "is not a number");
            return searchSpecificWeight(person, ct);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return searchSpecificWeight(person, ct);
        }

        PersonMemento personMemento = ct.getMemento(Integer.parseInt(weight));
        if (personMemento != null) {
            System.out.println(person.restore(personMemento));
        } else {
            System.out.println("Sorry we didnt find this weight, please try again");
            return searchSpecificWeight(person, ct);
        }
        return 0;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, CloneNotSupportedException {
        boolean done = false;
        System.out.println("prompting you for persons");
        String lastName = getNameInfo("Enter the person's last name:");
        String firstName = getNameInfo("Enter the person's first name:");
        CareTaker ct = new CareTaker("C:/Users/yprob/OneDrive/Bureau/ok.txt");
        Person person = new Person(lastName, firstName);

        while (!done) {
            person.setHairColor(getHairColor());
            int feet = getHeightFeet(person);
            person.setHeight(feet, getHeightInches(person));
            person.setWeight(getWeight(person));
            ct.addMemento(person.add());
            done = shouldContinue();
        }
        getSkinniestVersion(person, ct);
        searchSpecificWeight(person, ct);
        System.out.println("Completed satisfactorily");
    }
}
