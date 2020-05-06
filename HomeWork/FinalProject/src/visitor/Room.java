package visitor;

import java.util.ArrayList;

public class Room {
    int roomNumber;
    boolean doNotDisturb;
    String description;
    ArrayList<String> amenities;

    Room() {
    }

    public String getDescription() {
        return this.description;
    }

    public ArrayList<String> getAmenities() {
        return this.amenities;
    }

    public void setDoNotDisturb(boolean doNotDisturb) {
        this.doNotDisturb = doNotDisturb;
    }

    public boolean isDoNotDisturb() {
        return this.doNotDisturb;
    }

    public void setAmenities(ArrayList<String> amenities)  {
        this.amenities = amenities;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRoomNumber() {
        return this.roomNumber;
    }

    public double cost() {
        return 1.0;
    }

    //implements strategy for the choice.
}
