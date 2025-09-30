import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private String role;
    private List<Employee> subordinates = new ArrayList<>();

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public void add(Employee e) {
        subordinates.add(e);
    }

    public void remove(Employee e) {
        subordinates.remove(e);
    }

    public void showDetails() {
        System.out.println(role + ": " + name);
        for (Employee e : subordinates) {
            e.showDetails();
        }
    }
}