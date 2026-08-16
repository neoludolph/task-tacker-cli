package de.neoludolph.task_tracker_cli.App;

import de.neoludolph.task_tracker_cli.Service.TaskService;

public class TrackerApp {

    public static void startApp(String[] args) {
        TaskService taskService = new TaskService();

        switch (args[0]) {
            case "add":
                taskService.add();
                break;
        }
    }
}
