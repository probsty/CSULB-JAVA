import java.util.ArrayList;
import java.util.Collections;

/**
 * A class that do things on ArrayList
 * Homework Assignment: LAB-1 ArrayList
 *
 * @author Yann Probst
 * @version 1.01 10/17/2019
 */

public class ArrayListRunner {

    /**
     * Add a specific name in a ArrayList.
     * @param _names is the list where we add the specific name
     * @param _namesToAdd specific name that need to be added
     */
    public static void addNamesInArrayList( ArrayList<String> _names, String[] _namesToAdd) {
        Collections.addAll(_names, _namesToAdd);
    }

    /**
     * Replace a specific name by a new one in a ArrayList.
     * @param _names is the list where we replace the specific name
     * @param _oldName name that need to be replaced
     * @param _newName name that replace the older one
     */
    public static void replaceNameInArrayList(ArrayList<String> _names, String _oldName, String _newName) {
        boolean containsSpecificName = _names.contains(_oldName);
        if (containsSpecificName) {
            _names.set(_names.indexOf(_oldName), _newName);
            System.out.print("STEP 4:\nStep: 4The list of names now looks like:\n");
            printNames(_names);
        } else {
            System.out.printf("No %s inside the ArrayList\n", _oldName);
        }
    }

    /**
     * Add a specific name after a given name in a ArrayList.
     * @param _names is the list where we add a specific name
     * @param _nameToSearch name that we search on the list
     * @param _nameToAdd name that we want to add
     */
    public static void addNameAfterNameInArrayList(ArrayList<String> _names, String _nameToSearch, String _nameToAdd) {
        boolean containsSpecificName = _names.contains(_nameToSearch);
        if (containsSpecificName) {
            _names.add(_names.indexOf(_nameToSearch) + 1, _nameToAdd);
            System.out.print("STEP 5: The list of names now looks like:\n");
            printNames(_names);
        } else {
            System.out.printf("No %s inside the ArrayList\n", _nameToSearch);
        }
    }

    /**
     * Remove a name of position in a ArrayList.
     * @param _names is the list where we remove a specific name of a specific position
     * @param _position the position of the name we want to remove
     */
    public static void removeNameOfPositionInArrayList(ArrayList<String> _names, int _position) {
        _names.remove(_position);
        System.out.print("STEP 7:\nOriginal List after removing the first element:\nStep: 7 The list of names now looks like:\n");
        printNames(_names);
    }

    public static void printNames(ArrayList<String> _names) {
        for (String name : _names) {
            System.out.println(name);
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        String[] namesToAdd = {"Alice", "Bob", "Connie", "David", "Edward", "Fran", "Gomez", "Harry"};
        System.out.println("Step: 0 The list of names now looks like:");
        printNames(names);
        addNamesInArrayList(names, namesToAdd);
        System.out.println("Step: 1After performing the original adds");
        System.out.print("Step: 1 The list of names now looks like:\n");
        printNames(names);
        System.out.printf("STEP 2:\nThe names list currently has: %s\n\n", names.size());
        System.out.printf("STEP 3:\nFirst name in the list: %s\nLast name in the list: %s\n\n", names.get(0), names.get(names.size() - 1));
        replaceNameInArrayList(names, "Alice", "Alice B. Toklas");
        addNameAfterNameInArrayList(names, "David", "Doug");
        System.out.print("STEP 6 create a deep copy of the list of names:\n");
        ArrayList<String> names2 = new ArrayList<>(names);
        System.out.print("Step: 6 The list of names now looks like:\n");
        printNames(names2);
        removeNameOfPositionInArrayList(names, 0);
        System.out.print("Deep copy of the original list:\nStep: 7 The list of names now looks like:\n");
        printNames(names2);
        System.out.println("Completed Satisfactorily.");
    }

    public String toString() {
        return "ArrayListRunner{}";
    }

}
