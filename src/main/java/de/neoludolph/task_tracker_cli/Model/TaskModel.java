package de.neoludolph.task_tracker_cli.Model;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;

public class TaskModel {

    public enum Status {
        DONE,
        TODO,
        IN_PROGRESS
    }

    private long id;
    private String description;
    private LocalDateTime createdAt;
    private Status status;

    public TaskModel() {}

    public TaskModel(String description) {
        this.description = description;
        this.createdAt = LocalDateTime.now();
        this.status = Status.TODO;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
