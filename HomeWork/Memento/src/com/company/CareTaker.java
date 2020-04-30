package com.company;

import java.io.*;
public class CareTaker {
    /** File name.*/
    String m_filename;
    /** Corresponding object input stream.*/
    private ObjectInputStream m_ois = null;
    /** Corresponding object output stream.*/
    private ObjectOutputStream m_oos = null;

    CareTaker(String _filename) throws IOException {
        m_filename = _filename;
        m_oos = new ObjectOutputStream(new FileOutputStream(_filename));
        m_ois = new ObjectInputStream(new FileInputStream(_filename));
    }

    /**
     * Write a given PersonMemento into a ObjectOutputStream
     * @param _personMemento given object that we need to write into a file
     */
    public void addMemento(PersonMemento _personMemento) throws IOException {
        System.out.println(_personMemento.getSavedPerson().toString());
        m_oos.writeObject(_personMemento);
    }

    /**
     * Get the lowest weight of a PersonMemento into a ObjectInputStream
     * @return PersonMemento: instance with the lowest weight
     */
    public PersonMemento getMemento() throws IOException {
        boolean end = false;
        PersonMemento next = null;
        PersonMemento result = null;
        int lowestWeight = Person.maxWeight;
        m_ois = new ObjectInputStream(new FileInputStream(m_filename));

        while (!end) {
            try {
                next = (PersonMemento) m_ois.readObject();
            } catch (EOFException | ClassNotFoundException e) {
                end = true;
            }
            if (next != null) {
                int currentWeight = next.getSavedPerson().getWeightPounds();
                if (currentWeight <= lowestWeight) {
                    lowestWeight = currentWeight;
                    result = next;
                }
            }
        }
        return result;
    }

    /**
     * Get a given weight of a PersonMemento into a ObjectInputStream
     * @param weightToSearch: the weight we need to find in our ObjectInputStream
     * @return PersonMemento: instance with the given weight
     */
    public PersonMemento getMemento(int weightToSearch) throws IOException {
        boolean end = false;
        PersonMemento next = null;
        PersonMemento result = null;

        m_ois = new ObjectInputStream(new FileInputStream(m_filename));

        while (!end) {
            try {
                next = (PersonMemento) m_ois.readObject();
            } catch (EOFException | ClassNotFoundException e) {
                end = true;
            }
            if (next != null) {
                int currentWeight = next.getSavedPerson().getWeightPounds();
                if (currentWeight == weightToSearch) {
                    result = next;
                }
            }
        }
        return result;
    }
}
