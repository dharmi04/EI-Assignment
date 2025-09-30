import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        Scanner scanner = new Scanner(System.in);

        Observer phone = new DisplayDevice("Phone");
        Observer laptop = new DisplayDevice("Laptop");

        station.addObserver(phone);
        station.addObserver(laptop);

        System.out.println("Enter weather updates (type 'exit' to stop):");

        while (true) {
            System.out.print("Weather: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            station.setWeather(input);
        }

        // Optionally remove an observer before exiting
        station.removeObserver(laptop);
        System.out.println("Laptop removed from observers.");
        
        scanner.close();
        System.out.println("Program ended.");
    }
}
