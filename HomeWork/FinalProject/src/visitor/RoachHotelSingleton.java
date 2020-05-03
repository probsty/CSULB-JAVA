package visitor;

import java.util.ArrayList;

/**
 * Singleton of the RoachHotel
 * Final Project Assignment:
 *
 * @author Yann Probst
 * @version 1.01 05/01/2020
 */
public class RoachHotelSingleton {
    /** Singleton instance */
    private static RoachHotelSingleton m_instance = null;
    /** Name of the roachHotel */
    String m_name;
    /** Number of rooms in the roachHotel */
    int m_capacity;
    /** ArrayList of room */
    ArrayList<Room> m_rooms;
    /** Vacancy */
    boolean m_vacancy;

    private RoachHotelSingleton() {
        m_rooms = new ArrayList<>();
    }

    private RoachHotelSingleton(int _capacity, String _name) {
        m_name = _name;
        m_capacity = _capacity;
        m_vacancy = m_capacity > 0;
    }

    /** Return the instance of roachHotel or create it
     * @param _capacity number of rooms available
     * @param _name of the hotel
     * @return instance of roachHotel
     * */
    public static RoachHotelSingleton getInstance(int _capacity, String _name) {
        if (m_instance == null) {
            m_instance = new RoachHotelSingleton(_capacity, _name);
        }
        return m_instance;
    }

    /** Return the instance of roachHotel or create it
     * @return instance of roachHotel
     * */
    public static RoachHotelSingleton getInstance() {
        if (m_instance == null) {
            m_instance = new RoachHotelSingleton(0, "default");
        }
        return m_instance;
    }
}
