package de.neoludolph.task_tracker_cli.Repository;

import de.neoludolph.task_tracker_cli.Model.TaskModel;

import java.io.IOException;

public interface TaskRepository {
    void loadJson() throws IOException;
    void saveNewTaskInJson(TaskModel task) throws IOException;
    void saveUpdatedTaskJson(long id, String description) throws IOException;
}
