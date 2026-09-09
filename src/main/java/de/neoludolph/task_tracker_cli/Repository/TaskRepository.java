package de.neoludolph.task_tracker_cli.Repository;

import de.neoludolph.task_tracker_cli.Model.TaskModel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public void saveNewTaskInJson(TaskModel task) throws IOException {
        Path path = Path.of("src/main/resources/tasks.json");
        String tasksJson = loadTasksJson();

        if (tasksJson.equals("[\n]")) {
            task.setId(0);
            String newTask = task.toJson();

            int position = tasksJson.lastIndexOf("]");
            String json = tasksJson.substring(0, position)
                    + newTask
                    + "\n"
                    + tasksJson.substring(position);
            Files.writeString(path, json);
        } else {
            String currentJson = loadTasksJson();
            Pattern pattern = Pattern.compile("\"id\":\\s*(\\d+)");
            Matcher matcher = pattern.matcher(currentJson);

            int lastId = 0;

            while (matcher.find()) {
                lastId = Integer.parseInt(matcher.group(1));
            }
            task.setId(lastId + 1);

            String newTask = task.toJson();

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

    public void saveUpdatedTaskJson(long id, String description) throws IOException {
        Path path = Path.of("src/main/resources/tasks.json");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
        String currentJson = loadTasksJson();

        Pattern patternForId = Pattern.compile("\"id\":\\s*" + id + "\\b");
        Matcher matcherForId = patternForId.matcher(currentJson);

        int endOfMatch = 0;

        while (matcherForId.find()) {
            endOfMatch = matcherForId.end(); // das Komma bei "id": id,
        }

        int comma = currentJson.indexOf(",", endOfMatch + 1);

        String searchedDescription = currentJson.substring(endOfMatch + 26, comma); // "text von description"
        currentJson = currentJson.replace(searchedDescription, description + "\"");
        Files.writeString(path, currentJson);

        String addUpdatedAtToJson = currentJson.substring(0, endOfMatch + 1)
                + "\n"
                + "\t\t"
                + "\"updatedAt\": "
                + "\""
                + LocalDateTime.now().format(formatter)
                + "\""
                + currentJson.substring(endOfMatch);
        Files.writeString(path, addUpdatedAtToJson);
    }
}
