package test.taskmanager;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import taskmanager.*;

public class UserTest {

    @Test
    void testUserName() {
        User user = new User("Irem");
        assertEquals("Irem", user.getName());
    }

    @Test
    void testAddProject() {
        User user = new User("Irem");
        Project project = new Project("Test Project");

        user.addProject(project);

        assertEquals(1, user.getProjects().size());
        assertEquals("Test Project",
                     user.getProjects().get(0).getName());
    }
}
