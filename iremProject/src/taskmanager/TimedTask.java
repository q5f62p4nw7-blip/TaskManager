package taskmanager;

// Bu sınıf, son teslim tarihi olan görevleri temsil eder
// Task sınıfından türetilmiştir (inheritance)
public class TimedTask extends Task {

    // Görevin son teslim tarihi
    private Deadline deadline;

    // Constructor
    // TimedTask oluşturulurken görev bilgileri ve deadline ayarlanır
    public TimedTask(String title, String description, Deadline deadline) {
        super(title, description); // Task sınıfının constructor'ı çağrılır
        this.deadline = deadline;
    }

    // Görevin son teslim tarihini verir
    public Deadline getDeadline() {
        return deadline;
    }
}

