package de.neoludolph.task_tracker_cli.App;

import de.neoludolph.task_tracker_cli.Repository.TaskRepositoryImpl;
import de.neoludolph.task_tracker_cli.Service.TaskServiceImpl;

public class TrackerApp {

    public static void startApp(String[] args) {
        TaskServiceImpl taskService = new TaskServiceImpl(new TaskRepositoryImpl());

        switch (args[0]) {
            case "add":
                taskService.add(args[1]);
                break;
            case "update":
                taskService.update(Long.parseLong(args[1]), args[2]);
                break;
        }
    }
}
