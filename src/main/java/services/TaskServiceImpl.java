package services;

import data.dto.TaskDto;
import data.model.Task;
import data.repository.TaskDatabase;

public class TaskServiceImpl implements TaskService {
    TaskDatabase<Task> taskDatabase = TaskDatabase.getInstance();
    @Override
    public void createTask(TaskDto taskDto) {
        Task task = TaskDto.unpackDto(taskDto);
        taskDatabase.save(task);
    }
}
