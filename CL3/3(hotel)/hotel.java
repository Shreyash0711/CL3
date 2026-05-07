import java.rmi.Remote;
import java.rmi.RemoteException;

public interface hotel extends Remote {
    String checkAvailability() throws RemoteException;
    String bookRoom(String guestName) throws RemoteException;
}
