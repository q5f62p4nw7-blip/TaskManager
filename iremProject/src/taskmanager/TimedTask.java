package taskmanager;

import java.time.LocalDate;

// This class represents tasks with a deadline
// It is derived from the Task class (inheritance)
public class TimedTask extends Task {

    private Deadline deadline;
    private int reminderDaysBefore;


    // Constructor
    // Sets the task details and deadline when a TimedTask is created
    public TimedTask(String title, String description, Deadline deadline, Priority priority, int reminderDaysBefore) {
        super(title, description, priority); // The constructor of the Task class is called
        this.deadline = deadline;
        this.reminderDaysBefore = reminderDaysBefore;
    }

    // Returns the task deadline
    public Deadline getDeadline() {
        return deadline;
    }

    // Checks whether a reminder should be shown for this task
    // Returns true if the task is not completed and the reminder date is today
    public boolean shouldRemind() {
        return !isCompleted() &&
           deadline.getDueDate().minusDays(reminderDaysBefore)
                   .isEqual(LocalDate.now());
    }

    /*  Polymorphism example: this method overrides the base class implementation
    to provide deadline-based upcoming logic for timed tasks */
    @Override
    public boolean isUpcoming() {
        return deadline != null && deadline.isUpcoming();
    }

}

