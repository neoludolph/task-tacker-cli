package de.neoludolph.task_tracker_cli.Service;

import de.neoludolph.task_tracker_cli.Model.TaskModel;
import de.neoludolph.task_tracker_cli.Repository.TaskRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void add(String description) {
        TaskModel taskModel = new TaskModel(description);
        try {
            if (taskRepository.loadTasksJson().equals("[\n]")) {
                taskModel.setId(0);
                taskRepository.saveTasksJson(taskModel);
            } else {
                String currentJson = taskRepository.loadTasksJson();
                Pattern pattern = Pattern.compile("\"id\":\\s*(\\d+)"); // \\s* -> null oder mehr Whitespaces, () -> Capturing Group, um alles darin gezielt auszulesen, \\d+ -> Mindestens eine Ziffer von 0-9
                Matcher matcher = pattern.matcher(currentJson);

                int lastId = 0;

                while (matcher.find()) {
                    lastId = Integer.parseInt(matcher.group(1));
                }
                taskModel.setId(lastId + 1);
                taskRepository.saveTasksJson(taskModel);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(TaskModel task, long id, String description) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void markInProgress(String mark, long id) {

    }

    @Override
    public void markDone(String mark, long id) {

    }

    @Override
    public void listAll() {

    }

    @Override
    public void listDone() {

    }

    @Override
    public void listToDo() {

    }

    @Override
    public void listInProgress() {

    }
}
