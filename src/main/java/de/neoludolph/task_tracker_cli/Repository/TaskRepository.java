package de.neoludolph.task_tracker_cli.Repository;

import java.nio.file.Files;
import java.nio.file.Paths;

public class TaskRepository {

    public void loadTasksJson() throws Exception {
        String file = "src/main/resources/tasks.json";
        String json = readFileAsString(file);
    }

    public static String readFileAsString(String file)throws Exception {
        return new String(Files.readAllBytes(Paths.get(file)));
    }

    public void saveTasksJson() {

    }
}
