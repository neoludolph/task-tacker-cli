import java.util.Scanner;

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
