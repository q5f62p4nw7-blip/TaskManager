package test.taskmanager;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import taskmanager.*;

class ProjectTest {

    @Test
    void getName_returnsName() {
        Project project = new Project("OOP Task Manager");
        assertEquals("OOP Task Manager", project.getName());
    }

    @Test
    void addTask_addsTask() {
        Project project = new Project("P1");
        Task task = new Task("T1", "Desc", Priority.HIGH);

        project.addTask(task);

        List<Task> tasks = project.getTasks();
        assertEquals(1, tasks.size());
        assertEquals("T1", tasks.get(0).getTitle());
    }

    @Test
    void exportTasks_createsFile() throws Exception {
        Project project = new Project("ExportTestProject");

        Task normal = new Task("Normal Task", "No deadline", Priority.LOW);
        Deadline deadline = new Deadline(LocalDate.now().plusDays(5));
        TimedTask timed = new TimedTask("Timed Task", "Has deadline", deadline, Priority.HIGH, 2);

        timed.complete(); 

        project.addTask(normal);
        project.addTask(timed);

        Path tempFile = Files.createTempFile("tasks-", ".txt");
        String fileName = tempFile.toAbsolutePath().toString();

        project.exportTasksToFile(fileName);

        assertTrue(Files.exists(tempFile));

        String content = Files.readString(tempFile);

        assertTrue(content.contains("Project: " + project.getName()));
        assertTrue(content.contains("Title: " + normal.getTitle()));
        assertTrue(content.contains("Title: " + timed.getTitle()));
        assertTrue(content.contains("Priority: " + timed.getPriority()));

        assertTrue(content.contains("Deadline: " + deadline.getDueDate().toString()));
    }
}
