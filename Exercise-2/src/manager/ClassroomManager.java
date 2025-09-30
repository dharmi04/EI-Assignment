package manager;

import composite.Classroom;
import exceptions.ClassroomException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassroomManager {
    private final Map<String, Classroom> classrooms = new HashMap<>();

    public void addClassroom(String name) throws ClassroomException {
        if (name == null || name.trim().isEmpty()) throw new ClassroomException("Class name cannot be empty.");
        if (classrooms.containsKey(name)) throw new ClassroomException("Classroom already exists: " + name);
        classrooms.put(name, new Classroom(name));
    }

    public void removeClassroom(String name) throws ClassroomException {
        if (!classrooms.containsKey(name)) throw new ClassroomException("Classroom not found: " + name);
        classrooms.remove(name);
    }

    public Classroom getClassroom(String name) throws ClassroomException {
        Classroom c = classrooms.get(name);
        if (c == null) throw new ClassroomException("Classroom not found: " + name);
        return c;
    }

    public List<Classroom> listAll() {
        return new ArrayList<>(classrooms.values());
    }
}
