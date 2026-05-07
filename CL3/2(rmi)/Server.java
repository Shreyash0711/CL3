import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class Server implements StringConcatenator {

    public Server() {}

    @Override
    public String concatenate(String s1, String s2) throws RemoteException {
        System.out.println("Server received: '" + s1 + "' and '" + s2 + "'");
        return s1 + s2;
    }

    public static void main(String args[]) {
        try {
            // Instantiate the remote object
            Server obj = new Server();
            
            // Export the remote object to the Java RMI runtime
            StringConcatenator stub = (StringConcatenator) UnicastRemoteObject.exportObject(obj, 0);

            // Create and get reference to RMI registry on port 1099
            Registry registry = LocateRegistry.createRegistry(1099);
            
            // Bind the remote object's stub in the registry
            registry.bind("StringConcatenator", stub);

            System.out.println("RMI Server is ready and waiting for requests...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
