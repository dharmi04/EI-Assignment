import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Map to keep track of created employees by name
        Map<String, Employee> employees = new HashMap<>();

        System.out.println("Employee Management System (type 'exit' to quit)");

        while (true) {
            System.out.println("\nCommands: add, assign, show, exit");
            System.out.print("Enter command: ");
            String command = scanner.nextLine().trim().toLowerCase();

            if (command.equals("exit")) {
                System.out.println("Exiting...");
                break;
            }

            switch (command) {
                case "add":
                    System.out.print("Enter employee name: ");
                    String name = scanner.nextLine().trim();

                    System.out.print("Enter role: ");
                    String role = scanner.nextLine().trim();

                    employees.put(name, new Employee(name, role));
                    System.out.println("✅ Employee added: " + name + " (" + role + ")");
                    break;

                case "assign":
                    System.out.print("Enter manager name: ");
                    String managerName = scanner.nextLine().trim();

                    System.out.print("Enter employee name to assign: ");
                    String empName = scanner.nextLine().trim();

                    Employee manager = employees.get(managerName);
                    Employee emp = employees.get(empName);

                    if (manager != null && emp != null) {
                        manager.add(emp);
                        System.out.println("👔 Assigned " + empName + " under " + managerName);
                    } else {
                        System.out.println("❌ Manager or Employee not found!");
                    }
                    break;

                case "show":
                    System.out.print("Enter employee name to show details: ");
                    String showName = scanner.nextLine().trim();

                    Employee e = employees.get(showName);
                    if (e != null) {
                        e.showDetails();
                    } else {
                        System.out.println("❌ Employee not found!");
                    }
                    break;

                default:
                    System.out.println("❌ Invalid command. Try again.");
            }
        }

        scanner.close();
    }
}
