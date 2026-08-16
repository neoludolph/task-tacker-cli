package de.neoludolph.task_tracker_cli.Service;

import de.neoludolph.task_tracker_cli.Repository.TaskRepository;

public class TaskService {

    public void add() {
        TaskRepository taskRepository = new TaskRepository();
        taskRepository.loadTasksJson();
        // Logik
        taskRepository.saveTasksJson();
    }

    public void update() {

    }

    public void delete() {

    }

    public void markAs() {

    }

    public void listAll() {

    }

    public void listDone() {

    }

    public void listToDo() {

    }

    public void listInProgress() {

    }
}
