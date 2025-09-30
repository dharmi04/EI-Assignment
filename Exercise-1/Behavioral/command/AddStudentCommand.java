public class AddStudentCommand implements Command {
    private Classroom classroom;
    private String student;

    public AddStudentCommand(Classroom classroom, String student) {
        this.classroom = classroom;
        this.student = student;
    }

    @Override
    public void execute() {
        classroom.addStudent(student);
    }
}
