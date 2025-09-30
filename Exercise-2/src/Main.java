import facade.VirtualClassroomManager;
import exceptions.ClassroomException;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VirtualClassroomManager manager = new VirtualClassroomManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Virtual Classroom Manager ===");
        System.out.println("Commands:");
        System.out.println("  add_classroom <ClassName>");
        System.out.println("  remove_classroom <ClassName>");
        System.out.println("  add_student <StudentID> <ClassName>");
        System.out.println("  schedule_assignment <ClassName> <AssignmentDetails>");
        System.out.println("  submit_assignment <StudentID> <ClassName> <AssignmentDetails>");
        System.out.println("  list_classrooms");
        System.out.println("  list_students <ClassName>");
        System.out.println("  list_assignments <ClassName>");
        System.out.println("  help");
        System.out.println("  exit");

        while (true) {
            System.out.print("> ");
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            List<String> tokens = CommandLineParser.parse(line);
            if (tokens.isEmpty()) continue;

            String cmd = tokens.get(0).toLowerCase();

            try {
                switch (cmd) {
                    case "exit":
                        System.out.println("Exiting...");
                        scanner.close();
                        return;

                    case "help":
                        System.out.println("See command list printed at startup.");
                        break;

                    case "add_classroom":
                        if (tokens.size() < 2) {
                            System.out.println("Usage: add_classroom <ClassName>");
                        } else {
                            manager.addClassroom(tokens.get(1));
                        }
                        break;

                    case "remove_classroom":
                        if (tokens.size() < 2) {
                            System.out.println("Usage: remove_classroom <ClassName>");
                        } else {
                            manager.removeClassroom(tokens.get(1));
                        }
                        break;

                    case "add_student":
                        if (tokens.size() < 3) {
                            System.out.println("Usage: add_student <StudentID> <ClassName>");
                        } else {
                            manager.addStudent(tokens.get(1), tokens.get(2));
                        }
                        break;

                    case "schedule_assignment":
                        if (tokens.size() < 3) {
                            System.out.println("Usage: schedule_assignment <ClassName> <AssignmentDetails>");
                        } else {
                            manager.scheduleAssignment(tokens.get(1), tokens.get(2));
                        }
                        break;

                    case "submit_assignment":
                        if (tokens.size() < 4) {
                            System.out.println("Usage: submit_assignment <StudentID> <ClassName> <AssignmentDetails>");
                        } else {
                            manager.submitAssignment(tokens.get(1), tokens.get(2), tokens.get(3));
                        }
                        break;

                    case "list_classrooms":
                        manager.listClassrooms();
                        break;

                    case "list_students":
                        if (tokens.size() < 2) {
                            System.out.println("Usage: list_students <ClassName>");
                        } else {
                            manager.listStudents(tokens.get(1));
                        }
                        break;

                    case "list_assignments":
                        if (tokens.size() < 2) {
                            System.out.println("Usage: list_assignments <ClassName>");
                        } else {
                            manager.listAssignments(tokens.get(1));
                        }
                        break;

                    default:
                        System.out.println("Unknown command: " + cmd + ". Type 'help' for list.");
                }
            } catch (ClassroomException ce) {
                System.out.println("Error: " + ce.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
    }

   
    static class CommandLineParser {
        static java.util.List<String> parse(String line) {
            java.util.List<String> tokens = new java.util.ArrayList<>();
            StringBuilder cur = new StringBuilder();
            boolean inDouble = false;
            boolean inSingle = false;

            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (c == '"' && !inSingle) {
                    inDouble = !inDouble;
                    if (!inDouble) { 
                        tokens.add(cur.toString());
                        cur.setLength(0);
                    }
                    continue;
                }
                if (c == '\'' && !inDouble) {
                    inSingle = !inSingle;
                    if (!inSingle) {
                        tokens.add(cur.toString());
                        cur.setLength(0);
                    }
                    continue;
                }
                if (!inDouble && !inSingle && Character.isWhitespace(c)) {
                    if (cur.length() > 0) {
                        tokens.add(cur.toString());
                        cur.setLength(0);
                    }
                } else {
                    cur.append(c);
                }
            }
            if (cur.length() > 0) tokens.add(cur.toString());
            return tokens;
        }
    }
}
