package taskmanager;

import java.time.LocalDate;

// This class represents the deadline of a task
public class Deadline {

    // Deadline
    private LocalDate dueDate;

    // Constructor
    // The date is set when the Deadline object is created
    public Deadline(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    // Returns the deadline
    public LocalDate getDueDate() {
        return dueDate;
    }

   // Checks whether the task has not yet expired
    public boolean isUpcoming() {
        return dueDate.isAfter(LocalDate.now());
    }
}
