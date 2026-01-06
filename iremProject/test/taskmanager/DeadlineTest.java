package test.taskmanager;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

import taskmanager.*;

class DeadlineTest {

    @Test
    void getDueDate_returnsDate() {
        LocalDate date = LocalDate.now().plusDays(5);
        Deadline deadline = new Deadline(date);

        assertEquals(date, deadline.getDueDate());
    }

    @Test
    void isUpcoming_future_true() {
        Deadline deadline = new Deadline(LocalDate.now().plusDays(1));
        assertTrue(deadline.isUpcoming());
    }

    @Test
    void isUpcoming_today_false() {
        // Senin kodun isAfter(now) kullandığı için bugün false döner
        Deadline deadline = new Deadline(LocalDate.now());
        assertFalse(deadline.isUpcoming());
    }

    @Test
    void isUpcoming_past_false() {
        Deadline deadline = new Deadline(LocalDate.now().minusDays(1));
        assertFalse(deadline.isUpcoming());
    }
}
