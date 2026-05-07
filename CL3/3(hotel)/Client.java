import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String host = (args.length < 1) ? "localhost" : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host, 1099);
            hotel stub = (hotel) registry.lookup("HotelService");
            
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("\n--- Hotel Menu ---");
                System.out.println("1. Check Availability");
                System.out.println("2. Book Room");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
                
                if (choice == 1) {
                    System.out.println("Server response: " + stub.checkAvailability());
                } else if (choice == 2) {
                    System.out.print("Enter guest name: ");
                    String name = scanner.nextLine();
                    System.out.println("Server response: " + stub.bookRoom(name));
                } else if (choice == 3) {
                    break;
                } else {
                    System.out.println("Invalid choice.");
                }
            }
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
