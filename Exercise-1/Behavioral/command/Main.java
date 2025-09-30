import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Classroom classroom = new Classroom();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Classroom Management System (type 'exit' to quit)");

        while (true) {
            System.out.print("\nEnter command (add/remove/show/exit): ");
            String command = scanner.nextLine().trim().toLowerCase();

            if (command.equals("exit")) {
                System.out.println("Exiting...");
                break;
            }

            switch (command) {
                case "add":
                    System.out.print("Enter student name to add: ");
                    String addName = scanner.nextLine().trim();
                    Command add = new AddStudentCommand(classroom, addName);
                    add.execute();
                    break;

                case "remove":
                    System.out.print("Enter student name to remove: ");
                    String removeName = scanner.nextLine().trim();
                    Command remove = new RemoveStudentCommand(classroom, removeName);
                    remove.execute();
                    break;

                case "show":
                    classroom.showStudents();
                    break;

                default:
                    System.out.println("Invalid command. Try again!");
            }
        }

        scanner.close();
    }
}
