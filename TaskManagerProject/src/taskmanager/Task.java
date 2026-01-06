package taskmanager;

// This class represents a task to be done
// Since a Task is completable, it uses the Completable interface

public class Task implements Completable {
    
    // Encapsulation (private fields)
    private String title;
    private String description;
    private boolean completed;
    private Priority priority;


    // Constructor
    // Used to set the task name, description, and initial status when a Task object is created
    public Task(String title, String description, Priority priority) {
        this.title = title;
        this.description = description;
        this.completed = false;
        this.priority = priority;
    }
    
    // Getters
    // Used to expose the task information to the outside

    // Returns the task name
    public String getTitle() {
        return title;
    }

    // Returns the task description
    public String getDescription() {
        return description;
    }

    // Is the task completed?
    // In booleans, `is` is used instead of `get` (Java convention)

    public boolean isCompleted() {
        return completed;
    }

    // Tasks without deadlines are not considered upcoming
    public boolean isUpcoming() {
        return false;
    }

    // Returns the priority level of the task
    // Priority indicates how important the task is (LOW, MEDIUM, HIGH)
    public Priority getPriority() {
        return priority;
    }


    // Interface method
    // Marks the task as completed

    @Override
    public void complete() {
        this.completed = true; // This task has now been completed
        System.out.println("Task completed: " + title);  // Informs the user
    }
 
}
