package taskmanager;

import java.util.ArrayList;
import java.util.List;

// This class represents the project that holds tasks together
public class Project {

    // Encapsulation (private fields)
    private String name;          // Project name
    private List<Task> tasks;     // Tasks belonging to the project

    // Constructor
    // The project name and task list are initialized when the Project object is created
    public Project(String name) {
        this.name = name;
        this.tasks = new ArrayList<>();
    }

    // Returns the project name
    public String getName() {
        return name;
    }

    // Adds a task to the project
    public void addTask(Task task) {
        tasks.add(task);
    }

    // Returns all tasks in the project
    public List<Task> getTasks() {
        return tasks;
    }

    // Displays upcoming tasks (using polymorphism)
    public void showUpcomingTasks() {
        System.out.println("Upcoming tasks in project: " + name);

        for (Task task : tasks) {
            if (!task.isCompleted() && task.isUpcoming()) {
                System.out.println("- " + task.getTitle() + " | Priority: " + task.getPriority());
            }
        }
    }

    // Displays completed tasks
    public void showCompletedTasks() {
        System.out.println("Completed tasks:");

        for (Task task : tasks) {
            if (task.isCompleted()) {
            System.out.println("- " + task.getTitle() + " | Priority: " + task.getPriority());
            }
        }
    }

}

    
