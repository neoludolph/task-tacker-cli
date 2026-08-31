package de.neoludolph.task_tracker_cli.App;

import de.neoludolph.task_tracker_cli.Repository.TaskRepository;
import de.neoludolph.task_tracker_cli.Service.TaskServiceImpl;

public class TrackerApp {

    public static void startApp(String[] args) {
        TaskServiceImpl taskService = new TaskServiceImpl(new TaskRepository());

        switch (args[0]) {
            case "add":
                taskService.add(args[1]);
                break;
        }
    }
}
