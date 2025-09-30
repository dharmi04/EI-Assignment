package composite;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Assignment implements ClassroomComponent {
    private static final AtomicInteger COUNTER = new AtomicInteger(0);

    private final String id;
    private final String details;
    private final Set<String> submittedBy = new HashSet<>();

    public Assignment(String details) {
        this.id = "A-" + COUNTER.incrementAndGet();
        this.details = details;
    }

    public String getId() {
        return id;
    }

    public String getDetails() {
        return details;
    }

    public void submit(String studentId) {
        submittedBy.add(studentId);
    }

    public int getSubmittedCount() {
        return submittedBy.size();
    }

    public boolean isSubmittedBy(String studentId) {
        return submittedBy.contains(studentId);
    }

    @Override
    public void showDetails() {
        System.out.println("  Assignment [" + id + "]: " + details + " (submitted: " + submittedBy.size() + ")");
    }
}
