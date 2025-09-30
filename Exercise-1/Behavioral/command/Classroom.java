import java.util.ArrayList;
import java.util.List;

public class Classroom {
    private List<String> students = new ArrayList<>();

    public void addStudent(String name) {
        students.add(name);
        System.out.println(name + " has been added to classroom.");
    }

    public void removeStudent(String name) {
        students.remove(name);
        System.out.println(name + " has been removed from classroom.");
    }

    public void showStudents() {
        System.out.println("Students: " + students);
    }
}