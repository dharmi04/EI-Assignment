package composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Classroom implements ClassroomComponent {
    private final String name;
    private final List<Student> students = new ArrayList<>();
    private final List<Assignment> assignments = new ArrayList<>();

    public Classroom(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public void addStudent(Student s) { students.add(s); }

    public void removeStudent(String studentId) {
        students.removeIf(s -> s.getId().equals(studentId));
    }

    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }

    public void addAssignment(Assignment a) { assignments.add(a); }

    public void removeAssignment(String assignmentId) {
        assignments.removeIf(a -> a.getId().equals(assignmentId));
    }

    public List<Assignment> getAssignments() {
        return Collections.unmodifiableList(assignments);
    }

    public Optional<Assignment> findAssignmentByDetails(String details) {
        return assignments.stream().filter(a -> a.getDetails().equals(details)).findFirst();
    }

    @Override
    public void showDetails() {
        System.out.println("Classroom: " + name);
        if (students.isEmpty()) {
            System.out.println("  No students enrolled.");
        } else {
            students.forEach(Student::showDetails);
        }

        if (assignments.isEmpty()) {
            System.out.println("  No assignments scheduled.");
        } else {
            assignments.forEach(Assignment::showDetails);
        }
    }
}
