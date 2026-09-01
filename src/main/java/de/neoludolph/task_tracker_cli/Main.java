package de.neoludolph.task_tracker_cli;

import de.neoludolph.task_tracker_cli.App.TrackerApp;
import de.neoludolph.task_tracker_cli.Model.TaskModel;
import de.neoludolph.task_tracker_cli.Repository.TaskRepository;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
//        TrackerApp.startApp(args);

        TaskRepository tr = new TaskRepository();
        TaskModel tm = new TaskModel("blabla");
        try {
            tr.saveTasksJson(tm);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}