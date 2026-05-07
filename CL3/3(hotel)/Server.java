import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ExportException;

public class Server {
    public static void main(String[] args) {
        try {
            HotelImpl obj = new HotelImpl();
            Registry registry;
            try {
                registry = LocateRegistry.createRegistry(1099);
            } catch (ExportException e) {
                // If registry is already running on 1099
                registry = LocateRegistry.getRegistry(1099);
            }
            registry.rebind("HotelService", obj);
            System.out.println("Hotel Server is ready.");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
