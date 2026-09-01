package de.neoludolph.task_tracker_cli;

import de.neoludolph.task_tracker_cli.App.TrackerApp;
import de.neoludolph.task_tracker_cli.Model.TaskModel;
import de.neoludolph.task_tracker_cli.Repository.TaskRepository;
import de.neoludolph.task_tracker_cli.Service.TaskService;
import de.neoludolph.task_tracker_cli.Service.TaskServiceImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
//        TrackerApp.startApp(args);
        TaskService taskService = new TaskServiceImpl(new TaskRepository());
        taskService.add("bdss");
    }
}