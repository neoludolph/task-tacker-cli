package de.neoludolph.task_tracker_cli.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import de.neoludolph.task_tracker_cli.Model.TaskModel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class TaskRepositoryImpl implements TaskRepository {
    @Override
    public void loadJson() throws IOException {
        Path path = Path.of("src/main/resources/tasks.json");
        if (Files.notExists(path)) {
            Files.writeString(path, "[\n]");
        }
    }

    @Override
    public void saveNewTaskInJson(TaskModel task) throws IOException {
        loadJson();
        Path path = Path.of("src/main/resources/tasks.json");
        ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        ArrayList<TaskModel> al = objectMapper.readValue(
                path.toFile(),
                new TypeReference<ArrayList<TaskModel>>() {}
        );

        if (al.isEmpty()) {
            task.setId(0);
            al.add(task);

            objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValue(path.toFile(), al);
        } else {
            TaskModel lastTask = al.getLast();
            task.setId(lastTask.getId() + 1);
            al.add(task);



            objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValue(path.toFile(), al);
        }
    }

    @Override
    public void saveUpdatedTaskJson(long id, String description) throws IOException {
//        Path path = Path.of("src/main/resources/tasks.json");
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
//        String currentJson = loadTasksJson();
//
//        Pattern patternForId = Pattern.compile("\"id\":\\s*" + id + "\\b");
//        Matcher matcherForId = patternForId.matcher(currentJson);
//
//        int endOfMatch = 0;
//
//        while (matcherForId.find()) {
//            endOfMatch = matcherForId.end(); // das Komma bei "id": id,
//        }
//
//        int comma = currentJson.indexOf(",", endOfMatch + 1);
//
//        String searchedDescription = currentJson.substring(endOfMatch + 26, comma); // "text von description"
//        currentJson = currentJson.replace(searchedDescription, description + "\"");
//        Files.writeString(path, currentJson);
//
//        String addUpdatedAtToJson = currentJson.substring(0, endOfMatch + 1)
//                + "\n"
//                + "\t\t"
//                + "\"updatedAt\": "
//                + "\""
//                + LocalDateTime.now().format(formatter)
//                + "\""
//                + currentJson.substring(endOfMatch);
//        Files.writeString(path, addUpdatedAtToJson);
    }
}
