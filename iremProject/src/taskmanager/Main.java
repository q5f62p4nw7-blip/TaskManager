package taskmanager;

import java.time.LocalDate;

// Main class where the program starts
public class Main {

    public static void main(String[] args) {

        // Create a user
        User user = new User("Irem");

        // Create a project and add it to the user
        Project project = new Project("OOP Task Manager");
        user.addProject(project);

        // Create a normal task (without deadline)
        Task task1 = new Task(
          "Read OOP notes",
          "Study encapsulation and inheritance",
          Priority.HIGH
        );

        // Create a deadline for a timed task
        Deadline deadline = new Deadline(LocalDate.now().plusDays(3));


        // Create a timed task (task with deadline)
        TimedTask task2 = new TimedTask(
                "Write final report",
                "Prepare project report",
                deadline,
                Priority.MEDIUM
        );

        // Add tasks to the project
        project.addTask(task1);
        project.addTask(task2);

        // Mark the timed task as completed
        task2.complete();

        // Display upcoming (not completed) tasks
        project.showUpcomingTasks();

        // Display completed tasks
        project.showCompletedTasks();


        // Send a notification (optional feature)
        Notification notification = new Notification();
        notification.send("Program finished successfully.");

    }
}
