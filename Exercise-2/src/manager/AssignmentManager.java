package manager;

import composite.Assignment;
import composite.Classroom;
import exceptions.ClassroomException;

public class AssignmentManager {
    private final ClassroomManager classroomManager;

    public AssignmentManager(ClassroomManager classroomManager) {
        this.classroomManager = classroomManager;
    }

    public Assignment scheduleAssignment(String className, String details) throws ClassroomException {
        if (details == null || details.trim().isEmpty()) throw new ClassroomException("Assignment details cannot be empty.");
        Classroom classroom = classroomManager.getClassroom(className);
        Assignment a = new Assignment(details);
        classroom.addAssignment(a);
        return a;
    }

    public void submitAssignment(String studentId, String className, String details) throws ClassroomException {
        if (studentId == null || studentId.trim().isEmpty()) throw new ClassroomException("Student ID cannot be empty.");
        if (details == null || details.trim().isEmpty()) throw new ClassroomException("Assignment details cannot be empty.");

        Classroom classroom = classroomManager.getClassroom(className);

      
        boolean studentExists = classroom.getStudents().stream().anyMatch(s -> s.getId().equals(studentId));
        if (!studentExists) throw new ClassroomException("Student " + studentId + " is not enrolled in " + className);

        Assignment assignment = classroom.findAssignmentByDetails(details)
                .orElseThrow(() -> new ClassroomException("Assignment not found with given details in " + className));

 
        assignment.submit(studentId);
    }
}
