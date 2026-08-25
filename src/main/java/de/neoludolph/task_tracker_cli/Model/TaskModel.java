package de.neoludolph.task_tracker_cli.Model;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.concurrent.atomic.AtomicLong;

public class TaskModel {

    private enum Status {
        DONE,
        TODO,
        IN_PROGRESS
    }

    private static final AtomicLong NEXT_ID = new AtomicLong(0);
    private long id;
    private String description;
    @JsonFormat(pattern = "dd.MM.yy")
    private LocalDateTime createdAt;
    @JsonFormat(pattern = "dd.MM.yy")
    private LocalDateTime updatedAt;
    private Status status;

    public TaskModel(String description) {
        this.id = NEXT_ID.incrementAndGet();
        this.description = description;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.status = Status.TODO;
    }

    public String toJson() {
        return """
                {
                "id" = "%d",
                "description"= "%s",
                "createdAt" = "%s",
                "updatedAt" = "%s",
                "status" = "%s"
                }
                """.formatted(this.id, this.description, this.createdAt, this.updatedAt, this.status);
    }

//    Beispiel
//    import java.io.IOException;
//    import java.nio.file.Files;
//    import java.nio.file.Paths;
//
//    // Ihre bestehende Objekt-Klasse
//    class User {
//        String name = "Max";
//        int alter = 30;
//        boolean istAktiv = true;
//    }
//
//    public class JsonOhneLib {
//        public static void main(String[] args) {
//            // 1. Objekt erstellen
//            User user = new User();
//
//            // 2. Felder des Objekts direkt in den Text Block einsetzen
//            String jsonString = """
//            {
//                "name": "%s",
//                "alter": %d,
//                "istAktiv": %b
//            }
//            """.formatted(user.name, user.alter, user.istAktiv);
//
//            // 3. Speichern
//            try {
//                Files.writeString(Paths.get("output.json"), jsonString);
//                System.out.println("Erfolgreich gespeichert!");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
