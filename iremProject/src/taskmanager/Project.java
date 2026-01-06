package taskmanager;

import java.io.FileWriter;
import java.io.IOException;
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

    public void showReminders() {
    System.out.println("Reminders:");

    for (Task task : tasks) {
        if (task instanceof TimedTask timedTask) {
            if (timedTask.shouldRemind()) {
                System.out.println(
                    "- REMINDER: " + task.getTitle() +
                    " | Priority: " + task.getPriority()
                );
            }
        }
    }
}


// Exports all tasks in the project to a text file
public void exportTasksToFile(String fileName) {
    try (FileWriter writer = new FileWriter(fileName)) {

        writer.write("Project: " + name + "\n\n");

        for (Task task : tasks) {
            writer.write("Title: " + task.getTitle() + "\n");
            writer.write("Description: " + task.getDescription() + "\n");
            writer.write("Status: " + (task.isCompleted() ? "Completed" : "Not completed") + "\n");
            writer.write("Priority: " + task.getPriority() + "\n");

            if (task instanceof TimedTask timedTask) {
                writer.write("Deadline: " +
                        timedTask.getDeadline().getDueDate() + "\n");
            }

            writer.write("\n");
        }

        System.out.println("Tasks exported to file: " + fileName);

    } catch (IOException e) {
        System.out.println("Error while exporting tasks: " + e.getMessage());
    }
}




}

    
