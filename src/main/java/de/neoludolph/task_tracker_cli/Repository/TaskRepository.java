package de.neoludolph.task_tracker_cli.Repository;

import de.neoludolph.task_tracker_cli.Model.TaskModel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TaskRepository {
    public String loadTasksJson() throws IOException {
        Path path = Path.of("src/main/resources/tasks.json");
        if (Files.notExists(path)) {
            Files.createFile(path);
            String brackets = "[\n]";
            Files.writeString(path, brackets);
        }
        return Files.readString(path);
    }

    public void saveTasksJson(TaskModel task) throws IOException {
        Path path = Path.of("src/main/resources/tasks.json");
        String tasksJson = loadTasksJson();
        String newTask = task.toJson();

        if (tasksJson.equals("[\n]")) {
            int position = tasksJson.lastIndexOf("]");
            String json = tasksJson.substring(0, position)
                    + newTask
                    + "\n"
                    + tasksJson.substring(position);
            Files.writeString(path, json);
        } else {
            int position = tasksJson.lastIndexOf("]");
            String json = tasksJson.substring(0, position - 1)
                    + ","
                    + "\n"
                    + newTask
                    + "\n"
                    + tasksJson.substring(position);
            Files.writeString(path, json);
        }
    }
}
