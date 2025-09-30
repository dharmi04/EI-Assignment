package manager;

import composite.Classroom;
import composite.Student;
import exceptions.ClassroomException;


public class StudentManager {
    private final ClassroomManager classroomManager;

    public StudentManager(ClassroomManager classroomManager) {
        this.classroomManager = classroomManager;
    }

    public void enrollStudent(String studentId, String className) throws ClassroomException {
        if (studentId == null || studentId.trim().isEmpty())
            throw new ClassroomException("Student ID cannot be empty.");
        Classroom classroom = classroomManager.getClassroom(className);
        boolean exists = classroom.getStudents().stream().anyMatch(s -> s.getId().equals(studentId));
        if (exists) throw new ClassroomException("Student already enrolled: " + studentId);
        classroom.addStudent(new Student(studentId));
    }
}
