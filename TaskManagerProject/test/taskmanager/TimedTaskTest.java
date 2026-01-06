package test.taskmanager;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

import taskmanager.*;

class TimedTaskTest {

    @Test
    void isUpcoming_true() {
        Deadline deadline = new Deadline(LocalDate.now().plusDays(3));
        TimedTask task = new TimedTask("T", "D", deadline, Priority.MEDIUM, 1);

        assertTrue(task.isUpcoming());
    }

    @Test
    void isUpcoming_false() {
        Deadline deadline = new Deadline(LocalDate.now().minusDays(1));
        TimedTask task = new TimedTask("T", "D", deadline, Priority.MEDIUM, 1);

        assertFalse(task.isUpcoming());
    }

    @Test
    void shouldRemind_whenReminderDay() {
        int reminderDaysBefore = 2;
        Deadline deadline = new Deadline(LocalDate.now().plusDays(reminderDaysBefore));
        TimedTask task = new TimedTask("T", "D", deadline, Priority.HIGH, reminderDaysBefore);

        assertTrue(task.shouldRemind());
    }

    @Test
    void shouldRemind_whenCompleted() {
        int reminderDaysBefore = 2;
        Deadline deadline = new Deadline(LocalDate.now().plusDays(reminderDaysBefore));
        TimedTask task = new TimedTask("T", "D", deadline, Priority.HIGH, reminderDaysBefore);

        task.complete();

        assertFalse(task.shouldRemind());
    }

    @Test
    void getDeadline_returnsDeadline() {
        Deadline deadline = new Deadline(LocalDate.now().plusDays(10));
        TimedTask task = new TimedTask("T", "D", deadline, Priority.LOW, 3);

        assertEquals(deadline, task.getDeadline());
        assertEquals(deadline.getDueDate(), task.getDeadline().getDueDate());
    }
}
