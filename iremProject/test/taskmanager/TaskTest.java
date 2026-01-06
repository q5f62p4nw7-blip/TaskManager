package test.taskmanager;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import taskmanager.*;

class TaskTest {

    @Test
    void newTask_notCompleted() {
        Task task = new Task("T1", "Desc", Priority.HIGH);
        assertFalse(task.isCompleted());
    }

    @Test
    void complete_marksCompleted() {
        Task task = new Task("T1", "Desc", Priority.MEDIUM);

        task.complete();

        assertTrue(task.isCompleted());
    }

    @Test
    void getters_returnValues() {
        Task task = new Task("Read", "Study OOP", Priority.HIGH);

        assertEquals("Read", task.getTitle());
        assertEquals("Study OOP", task.getDescription());
        assertEquals(Priority.HIGH, task.getPriority());
    }

    @Test
    void isUpcoming_normalTask() {
        Task task = new Task("T1", "Desc", Priority.LOW);
        assertFalse(task.isUpcoming());
    }
}
