package de.neoludolph.task_tracker_cli.Repository;

import de.neoludolph.task_tracker_cli.Model.TaskModel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TaskRepository {
    public String loadTasksJson() throws IOException {
        Path path = Path.of("src/main/resources/tasks.json");
        if (Files.notExists(path)) {
            Files.createFile(path);
            String curlyBrackets = "{\n\n}";
//            String curlyBrackets = """
//                    {
//                                              Alternative notation
//                    }
//                    """;
            Files.writeString(path, curlyBrackets);
        }
        return Files.readString(path);
    }

    public void saveTasksJson(TaskModel task) throws IOException {
        Path path = Path.of("src/main/resources/tasks.json");
        String tasksJson = loadTasksJson();
        String newTask = task.toJson();

        if (tasksJson.equals("{\n\n}")) {
            int position = tasksJson.lastIndexOf("}");
            String json = tasksJson.substring(0, position - 1)
                    + "\t"
                    + newTask;
        } else {
            int position = tasksJson.lastIndexOf("}");
            String json = tasksJson.substring(0, position - 1)
                    + ","
                    + "\n"
                    + "\t"
                    + newTask;
            Files.writeString(path, json);
        }
    }
}
