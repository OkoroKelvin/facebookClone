package data.dto;

import data.model.Post;
import data.model.Task;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class TaskDto {
    private String id;
    @NonNull
    private String taskName;
    @NonNull
    private String taskDescription;
    private LocalDateTime createdTime;


    public static Task unpackDto(TaskDto taskDto){
        return new Task(taskDto.getTaskName(), taskDto.taskDescription);
    }
}


