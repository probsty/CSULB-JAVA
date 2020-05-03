package visitor;

import java.util.ArrayList;

public class RoomFactory {
    RoomFactory() {

    }

    public Room getRoom(String name, ArrayList<String> rooms) {
        Room room = new Room(10.0);
        return room;
    }
}
