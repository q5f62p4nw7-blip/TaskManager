package taskmanager;

import java.util.ArrayList;
import java.util.List;

// Bu sınıf, projeleri yöneten kullanıcıyı temsil eder
public class User {

    // Encapsulation (private alanlar)
    private String name;                  // Kullanıcının adı
    private List<Project> projects;       // Kullanıcıya ait projeler

    // Constructor
    // User nesnesi oluşturulurken isim ve boş proje listesi oluşturulur
    public User(String name) {
        this.name = name;
        this.projects = new ArrayList<>();
    }

    // Kullanıcının adını verir
    public String getName() {
        return name;
    }

    // Kullanıcının projelerini verir
    public List<Project> getProjects() {
        return projects;
    }

    // Kullanıcıya yeni proje ekler
    public void addProject(Project project) {
        projects.add(project);
    }
}
