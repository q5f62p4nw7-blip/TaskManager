package taskmanager;

import java.util.ArrayList;
import java.util.List;

// This class represents the user who manages projects
public class User {

    // Encapsulation (private fields)
    private String name;                  // User name
    private List<Project> projects;       // Projects belonging to the user

    // Constructor
    // When a User object is created, the name and an empty project list are initialized

    public User(String name) {
        this.name = name;
        this.projects = new ArrayList<>();
    }

    // Returns the user's name
    public String getName() {
        return name;
    }

    // Returns the user's projects
    public List<Project> getProjects() {
        return projects;
    }

    // Adds a new project to the user
    public void addProject(Project project) {
         if (project != null) {
        projects.add(project);
    }
    }
}
