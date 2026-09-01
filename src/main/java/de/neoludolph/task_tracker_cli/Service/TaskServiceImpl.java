package de.neoludolph.task_tracker_cli.Service;

import de.neoludolph.task_tracker_cli.Model.TaskModel;
import de.neoludolph.task_tracker_cli.Repository.TaskRepository;

import java.io.IOException;
import java.util.ArrayList;

public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void add(String description) {
        TaskModel taskModel = new TaskModel(description);
        try {
            taskRepository.saveTasksJson(taskModel);
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
