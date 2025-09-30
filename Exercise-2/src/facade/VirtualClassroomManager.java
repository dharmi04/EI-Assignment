package facade;

import composite.Assignment;
import composite.Classroom;
import composite.Student;
import exceptions.ClassroomException;
import manager.AssignmentManager;
import manager.ClassroomManager;
import manager.StudentManager;
import utils.LoggerUtil;

import java.util.logging.Logger;


public class VirtualClassroomManager {
    private final ClassroomManager classroomManager;
    private final StudentManager studentManager;
    private final AssignmentManager assignmentManager;
    private final Logger logger = LoggerUtil.getLogger();

    public VirtualClassroomManager() {
        this.classroomManager = new ClassroomManager();
        this.studentManager = new StudentManager(classroomManager);
        this.assignmentManager = new AssignmentManager(classroomManager);
    }

    public void addClassroom(String name) throws ClassroomException {
        classroomManager.addClassroom(name);
        System.out.println("Classroom " + name + " has been created.");
        logger.info("Created classroom: " + name);
    }

    public void removeClassroom(String name) throws ClassroomException {
        classroomManager.removeClassroom(name);
        System.out.println("Classroom " + name + " has been removed.");
        logger.info("Removed classroom: " + name);
    }

    public void addStudent(String studentId, String className) throws ClassroomException {
        studentManager.enrollStudent(studentId, className);
        System.out.println("Student " + studentId + " has been enrolled in " + className + ".");
        logger.info("Enrolled student: " + studentId + " in class " + className);
    }

    public void scheduleAssignment(String className, String details) throws ClassroomException {
        Assignment assignment = assignmentManager.scheduleAssignment(className, details);
        System.out.println("Assignment for " + className + " has been scheduled.");
        logger.info("Scheduled assignment [" + assignment.getId() + "] in " + className);
    }

    public void submitAssignment(String studentId, String className, String details) throws ClassroomException {
        assignmentManager.submitAssignment(studentId, className, details);
        System.out.println("Assignment submitted by Student " + studentId + " in " + className + ".");
        logger.info("Submission by " + studentId + " for class " + className + " assignment: " + details);
    }

    public void listClassrooms() {
        for (Classroom c : classroomManager.listAll()) {
            c.showDetails();
        }
    }

    public void listStudents(String className) throws ClassroomException {
        Classroom c = classroomManager.getClassroom(className);
        System.out.println("Students in " + className + ":");
        for (Student s : c.getStudents()) {
            System.out.println("  " + s.getId());
        }
    }

    public void listAssignments(String className) throws ClassroomException {
        Classroom c = classroomManager.getClassroom(className);
        System.out.println("Assignments in " + className + ":");
        c.getAssignments().forEach(a -> {
            System.out.println("  [" + a.getId() + "] " + a.getDetails() + " (submitted: " + a.getSubmittedCount() + ")");
        });
    }
}
