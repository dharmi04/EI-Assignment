public class Main {
    public static void main(String[] args) {
        Employee manager = new Employee("Alice", "Manager");
        Employee dev1 = new Employee("Bob", "Developer");
        Employee dev2 = new Employee("Charlie", "Developer");

        manager.add(dev1);
        manager.add(dev2);

        manager.showDetails();
    }
}