public class RemoveStudentCommand implements Command {
    private Classroom classroom;
    private String student;

    public RemoveStudentCommand(Classroom classroom, String student) {
        this.classroom = classroom;
        this.student = student;
    }

    @Override
    public void execute() {
        classroom.removeStudent(student);
    }
}