package data.model;

import data.repository.Storable;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Task implements Storable {
    private String id;
    private String taskName;
    private String taskDescription;
    private LocalDateTime createdTime;

    public Task(String taskName, String taskDescription) {
        this.id = UUID.randomUUID().toString();
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        createdTime = LocalDateTime.now();
    }

    @Override
    public String getEmail() {
        return null;
    }
}
