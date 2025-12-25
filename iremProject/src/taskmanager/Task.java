package taskmanager;

// Bu sınıf, yapılacak bir görevi temsil eder
// Task(görev) tamamlanabilir olduğu için Completable interface'ini kullanır

public class Task implements Completable {
    
    // Encapsulation (private alanlar)
    private String title;  // Görevin adı
    private String description;  // Görevin açıklaması
    private boolean completed;  // Görev bitti mi bitmedi mi?

    // Constructor
    // Task nesnesi oluşturulurken görev adı, açıklama ve başlangıç durumunu ayarlamak için kullanılır.
    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false;
    }

    // Getter'lar
    // Görevin bilgisini dışarıya vermek için kullanılır.

    // Görevin adını verir
    public String getTitle() {
        return title;
    }

    // Görevin açıklamasını verir
    public String getDescription() {
        return description;
    }

    // Görev tamamlandı mı?
    // Boolean’larda get yerine is kullanılır (Java kuralı)
    public boolean isCompleted() {
        return completed;
    }

    // Interface metodu
    // Görevi tamamlandı olarak işaretler
    @Override
    public void complete() {
        this.completed = true; //Bu görev artık tamamlandı
        System.out.println("Görev tamamlandı: " + title); // kullanıcıya bilgi verir
    }
}
