package de.neoludolph.task_tracker_cli.Service;

import de.neoludolph.task_tracker_cli.Model.TaskModel;
import de.neoludolph.task_tracker_cli.Repository.TaskRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void add(String description) {
        try {
            if (taskRepository.loadTasksJson().equals("[\n]")) {
                TaskModel taskModel = new TaskModel(description);
                taskModel.setId(0);
                taskRepository.saveTasksJson(taskModel);
            } else {
                String currentJson = taskRepository.loadTasksJson();
                Pattern pattern = Pattern.compile("\"id\":\\s*(\\d+)");
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
