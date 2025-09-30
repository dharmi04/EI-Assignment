public class Main {
    public static void main(String[] args) {
        Classroom classroom = new Classroom();

        Command add = new AddStudentCommand(classroom, "Alice");
        Command remove = new RemoveStudentCommand(classroom, "Alice");

        add.execute();
        classroom.showStudents();

        remove.execute();
        classroom.showStudents();
    }
}