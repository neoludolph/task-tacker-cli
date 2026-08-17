package de.neoludolph.task_tracker_cli.Service;

import de.neoludolph.task_tracker_cli.Model.TaskModel;
import de.neoludolph.task_tracker_cli.Repository.TaskRepository;

public class TaskServiceImpl implements TaskService {

    public TaskServiceImpl(TaskRepository taskRepository) {
    }

    @Override
    public void add(String description) {

    }

    @Override
    public void update(TaskModel task, long id, String description) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void markAs(String markAs) {

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
