import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        System.out.println("Logger System (type 'exit' to quit)");
        System.out.println("Same instance? " + (logger1 == logger2));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter log message: ");
            String message = scanner.nextLine();

            if (message.equalsIgnoreCase("exit")) {
                System.out.println("Logging stopped.");
                break;
            }

            // Either logger1 or logger2 (both are same instance)
            logger1.log(message);
        }

        scanner.close();
    }
}
