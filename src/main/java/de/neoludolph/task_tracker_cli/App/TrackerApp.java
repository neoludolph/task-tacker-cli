package de.neoludolph.task_tracker_cli.App;

import de.neoludolph.task_tracker_cli.Service.TaskService;
import de.neoludolph.task_tracker_cli.Service.TaskServiceImpl;

public class TrackerApp {

    public static void startApp(String[] args) {
        TaskServiceImpl taskService = new TaskServiceImpl();

        switch (args[0]) {
            case "add":
                taskService.add(args[1]);
                break;
        }
    }
}
