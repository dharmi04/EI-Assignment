import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AudioPlayer player = new AudioPlayer();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Audio Player System (type 'exit' as format to quit)");

        while (true) {
            System.out.print("\nEnter media format (e.g., mp3, mp4, vlc): ");
            String format = scanner.nextLine().trim().toLowerCase();

            if (format.equals("exit")) {
                System.out.println("Exiting...");
                break;
            }

            System.out.print("Enter file name (with extension): ");
            String fileName = scanner.nextLine().trim();

            player.play(format, fileName);
        }

        scanner.close();
    }
}
