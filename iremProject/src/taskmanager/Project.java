package taskmanager;

import java.util.ArrayList;
import java.util.List;

// Bu sınıf, görevleri bir arada tutan projeyi temsil eder
public class Project {

    // Encapsulation (private alanlar)
    private String name;          // Proje adı
    private List<Task> tasks;     // Projeye ait görevler

    // Constructor
    // Project nesnesi oluşturulurken proje adı ve görev listesi hazırlanır
    public Project(String name) {
        this.name = name;
        this.tasks = new ArrayList<>();
    }

    // Proje adını verir
    public String getName() {
        return name;
    }

    // Projeye görev ekler
    public void addTask(Task task) {
        tasks.add(task);
    }

    // Projedeki tüm görevleri verir
    public List<Task> getTasks() {
        return tasks;
    }

    // Yaklaşan görevleri gösterir (polymorphism ile)
    public void showUpcomingTasks() {
        System.out.println("Upcoming tasks in project: " + name);

        for (Task task : tasks) {
            if (!task.isCompleted() && task.isUpcoming()) {
                System.out.println("- " + task.getTitle());
            }
        }
    }
}
