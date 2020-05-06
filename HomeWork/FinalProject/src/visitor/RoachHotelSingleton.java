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
    /** Number of rooms in the roachHotel */
    int m_capacity;
    /** Singleton instance */
    private static RoachHotelSingleton m_instance = null;
    /** Name of the roachHotel */
    String m_name;
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

    public String getName() {
        return this.m_name;
    }

    public void createRooms() {
        RoomFactory roomFactory = new RoomFactory();

        m_instance.m_rooms = new ArrayList<>();
        for (int i = 0; i < this.m_capacity; i++) {
            m_instance.m_rooms.add(roomFactory.getRoom("test", null));
            m_instance.m_rooms.get(i).setRoomNumber(i);
            m_instance.m_rooms.get(i).setDoNotDisturb(false);
        }
    }

    public void cleanRooms() {

    }

    public Room checkIn(Customer colony, String a, ArrayList<String> b) {
        return new Room();
    }

    public double checkOut(Room room, int a, String b) {
        return 0.0;
    }
}
