import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {

    private Client() {}

    public static void main(String[] args) {
        String host = (args.length < 1) ? "localhost" : args[0];
        try {
            // Locate the RMI registry on the specified host and port
            Registry registry = LocateRegistry.getRegistry(host, 1099);
            
            // Look up the remote object
            StringConcatenator stub = (StringConcatenator) registry.lookup("StringConcatenator");
            
            Scanner scanner = new Scanner(System.in);
            
            System.out.print("Enter first string: ");
            String string1 = scanner.nextLine();
            
            System.out.print("Enter second string: ");
            String string2 = scanner.nextLine();

            System.out.println("Client sending: '" + string1 + "' and '" + string2 + "' to server...");
            
            // Invoke the remote method
            String response = stub.concatenate(string1, string2);
            
            System.out.println("Server response (concatenated string): " + response);
            
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
