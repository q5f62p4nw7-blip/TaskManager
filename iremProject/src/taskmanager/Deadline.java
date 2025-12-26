package taskmanager;

import java.time.LocalDate;

// Bu sınıf, bir görevin son teslim tarihini temsil eder
public class Deadline {

    // Son teslim tarihi
    private LocalDate dueDate;

    // Constructor
    // Deadline nesnesi oluşturulurken tarih ayarlanır
    public Deadline(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    // Son teslim tarihini verir
    public LocalDate getDueDate() {
        return dueDate;
    }

    // Görev henüz süresi dolmamış mı kontrol eder
    public boolean isUpcoming() {
        return dueDate.isAfter(LocalDate.now());
    }
}
