package taskmanager;

// This class represents tasks with a deadline
// It is derived from the Task class (inheritance)
public class TimedTask extends Task {

    // Task deadline
    private Deadline deadline;

    // Constructor
    // Sets the task details and deadline when a TimedTask is created
    public TimedTask(String title, String description, Deadline deadline, Priority priority) {
        super(title, description, priority); // The constructor of the Task class is called
        this.deadline = deadline;
    }

    // Returns the task deadline
    public Deadline getDeadline() {
        return deadline;
    }

    /*  Polymorphism example: this method overrides the base class implementation
    to provide deadline-based upcoming logic for timed tasks */
    @Override
    public boolean isUpcoming() {
        return deadline != null && deadline.isUpcoming();
    }

}

