package taskmanager;

// This class represents tasks with a deadline
// It is derived from the Task class (inheritance)
public class TimedTask extends Task {

    // Task deadline
    private Deadline deadline;

    // Constructor
    // Sets the task details and deadline when a TimedTask is created
    public TimedTask(String title, String description, Deadline deadline) {
        super(title, description); // The constructor of the Task class is called
        this.deadline = deadline;
    }

    // Returns the task deadline
    public Deadline getDeadline() {
        return deadline;
    }
}

