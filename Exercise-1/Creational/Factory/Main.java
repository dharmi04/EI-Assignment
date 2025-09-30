import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Transport Delivery System");
        System.out.println("Available transports: car, plane, ship");
        System.out.println("Type 'exit' anytime to quit.\n");

        while (true) {
            System.out.print("Enter transport type: ");
            String transportType = scanner.nextLine().trim().toLowerCase();

            if (transportType.equals("exit")) {
                System.out.println("Exiting...");
                break;
            }

            System.out.print("Enter item to deliver: ");
            String item = scanner.nextLine().trim();

            Transport transport = TransportFactory.getTransport(transportType);

            if (transport != null) {
                transport.deliver(item);
            } else {
                System.out.println("❌ Invalid transport type. Try again!");
            }
        }

        scanner.close();
    }
}
