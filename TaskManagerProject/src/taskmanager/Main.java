package taskmanager;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // USER
        System.out.print("Enter user name: ");
        String userName = scanner.nextLine();
        User user = new User(userName);

        // PROJECT
        System.out.print("Enter project name: ");
        String projectName = scanner.nextLine();
        Project project = new Project(projectName);
        user.addProject(project);

        boolean running = true;

        while (running) {
            System.out.println("\n=== MENU ===");
            System.out.println("1) Add task");
            System.out.println("2) Show upcoming tasks");
            System.out.println("3) Show completed tasks");
            System.out.println("4) Show reminders");
            System.out.println("5) Complete a task");
            System.out.println("6) Export tasks to file");
            System.out.println("7) Exit");
            System.out.print("Choose: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1" -> {
                    // ADD TASK
                    System.out.print("Task title: ");
                    String title = scanner.nextLine();

                    System.out.print("Task description: ");
                    String description = scanner.nextLine();

                    System.out.print("Priority (LOW, MEDIUM, HIGH): ");
                    Priority priority =
                            Priority.valueOf(scanner.nextLine().toUpperCase());

                    System.out.print("Does this task have a deadline? (yes/no): ");
                    String hasDeadline = scanner.nextLine();

                    if (hasDeadline.equalsIgnoreCase("yes")) {
                        System.out.print("Days until deadline: ");
                        int days = Integer.parseInt(scanner.nextLine());

                        System.out.print("Reminder days before deadline: ");
                        int remindDays = Integer.parseInt(scanner.nextLine());

                        Deadline deadline =
                                new Deadline(LocalDate.now().plusDays(days));

                        TimedTask timedTask = new TimedTask(
                                title,
                                description,
                                deadline,
                                priority,
                                remindDays
                        );

                        project.addTask(timedTask);

                    } else {
                        Task task = new Task(title, description, priority);
                        project.addTask(task);
                    }

                    System.out.println("✅ Task added successfully!");
                }

                case "2" -> {
                    project.showUpcomingTasks();
                }

                case "3" -> {
                    project.showCompletedTasks();
                }

                case "4" -> {
                    project.showReminders();
                }

                case "5" -> {
                    project.listAllTasks();
                    System.out.print("Enter task number to complete: ");
                    int num = Integer.parseInt(scanner.nextLine());
                    project.completeTask(num);
                }

                case "6" -> {
                    project.exportTasksToFile("tasks.txt");
                }

                case "7" -> {
                   Notification notification = new Notification();
                   notification.send("Program finished successfully.");

                   running = false;
                   System.out.println("👋 Program finished.");
                }

                default -> {
                    System.out.println("❌ Invalid choice.");
                }
            }
        }

        scanner.close();
    }
}
