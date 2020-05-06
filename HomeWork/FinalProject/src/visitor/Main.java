package visitor;

public class Main {

    public static void main(String[] args) {
        RoachHotelSingleton roachHotel = RoachHotelSingleton.getInstance(5, "French Hotel");
        roachHotel.createRooms();
        System.out.println("motel: The only motel in town " + roachHotel.getName() +
                ". Available rooms: " + roachHotel.m_rooms.size());
        System.out.println("Rooms number:");
        for (int i = 0; i < roachHotel.m_rooms.size(); i++) {
            System.out.printf("%s ", roachHotel.m_rooms.get(i).getRoomNumber());
        }
        System.out.printf("\n");
    }
}
