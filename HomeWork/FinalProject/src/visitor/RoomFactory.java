package visitor;

import java.util.ArrayList;

public class RoomFactory {
    RoomFactory() {

    }

    public Room getRoom(String name, ArrayList<String> amenities) {
        return new Room();
    }
}
