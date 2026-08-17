package de.neoludolph.task_tracker_cli.Service;

import de.neoludolph.task_tracker_cli.Model.TaskModel;

public interface TaskService {
    void add(String description);
    void update(TaskModel task, long id, String description);
    void delete(long id);
    void markInProgress(String mark, long id);
    void markDone(String mark, long id);
    void listAll();
    void listDone();
    void listToDo();
    void listInProgress();
}
