import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HotelImpl extends UnicastRemoteObject implements hotel {
    private int availableRooms = 10;

    protected HotelImpl() throws RemoteException {
        super();
    }

    @Override
    public String checkAvailability() throws RemoteException {
        return "Available rooms: " + availableRooms;
    }

    @Override
    public String bookRoom(String guestName) throws RemoteException {
        if (availableRooms > 0) {
            availableRooms--;
            return "Room booked successfully for " + guestName + ". Remaining rooms: " + availableRooms;
        } else {
            return "Sorry, no rooms available.";
        }
    }
}
