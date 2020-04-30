package com.jetbrains;

/**
 * A class to manage input's error.
 * Homework Assignment:
 *
 * @author Yann Probst
 * @version 1.01 03/03/2019
 */
public class InputError {
    /** Single Instance of the input error manager. */
    private static InputError m_inputErrorManager = null;

    private InputError() {

    }

    /**
     * Get a singleton of the instance
     * @return instance of the class
     */
    public static InputError getInstance() {
        if (m_inputErrorManager == null) {
            m_inputErrorManager = new InputError();
        }
        return m_inputErrorManager;
    }

    /**
     * Verify the input's of the user
     * @param _input we need to search in the array
     * @param _validInput array of the valid input
     * @return true if the input is valid
     */
    private boolean validInput(String _input, String[] _validInput) {
        boolean valid = false;

        for (String s : _validInput) {
            if (_input.equals(s)) {
                valid = true;
            }
        }
        return valid;
    }

    /**
     * Check the option input's of the user
     * @param _input we need to verify
     * @return true if the input is valid
     */
    public boolean checkOptionInput(String _input) {
        boolean valid = true;
        String[] validInput = {"s", "show products", "i", "insert coin", "b", "buy", "a", "add product", "r", "remove coins", "q", "quit"};

        try {
            if (!validInput(_input, validInput)) {
                throw new IncorrectInputException("Please, specify a valid input");
            }
        } catch (IncorrectInputException err) {
            System.out.println(err.getMessage());
            valid = false;
        }
        return valid;
    }

    /**
     * Check the product input's of the user
     * @param _input we need to verify
     * @return true if the input is valid
     */
    public boolean checkProduct(String _input) {
        boolean valid = true;
        String[] validInput = {"diet pepsi", "water", "mars bar", "m&ms", "popcorn"};

        try {
            if (!validInput(_input, validInput)) {
                throw new IncorrectInputException("Unknown Drink");
            }
        } catch (IncorrectInputException err) {
            System.out.println(err.getMessage());
            valid = false;
        }
        return valid;
    }

    /**
     * Check the quantity input's of the user
     * @param _input we need to verify
     * @return true if the input is valid
     */
    public boolean checkNumber(String _input) {
        boolean valid = true;

        try {
           if (!_input.matches("[0-9]+")) {
               throw new IncorrectInputException("Accept only digit number");
           }
        } catch (IncorrectInputException err) {
            System.out.println(err.getMessage());
            valid = false;
        }
        return valid;
    }

    /**
     * Check the added coin that the user put in the vending machine
     * @param _input we need to verify
     * @return true if the input is valid
     */
    public boolean checkCoin(String _input) {
        boolean valid = true;
        String[] validInput = {"dollar", "half dollar", "dime", "nickel", "penny", "quarter"};

        try {
            if (!validInput(_input, validInput)) {
                throw new IncorrectInputException("We don't take fake money");
            }
        } catch (IncorrectInputException err) {
            System.out.println(err.getMessage());
            valid = false;
        }
        return valid;
    }

    @Override
    public String toString() {
        return "InputError{}";
    }
}
