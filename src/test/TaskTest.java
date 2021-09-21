import data.dto.TaskDto;
import data.model.Task;
import data.repository.TaskDatabase;
import data.repository.UserDatabase;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import services.TaskService;
import services.TaskServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class TaskTest {
   private TaskDto taskDto;
   private TaskService taskService;
   private TaskDatabase<Task> taskDataBase;
    @BeforeEach
    void setup(){
        taskDto = new TaskDto("Teach", "Teach My Guys");
        taskService = new TaskServiceImpl();
        taskDataBase = TaskDatabase.getInstance();
    }

    @AfterEach
    void tearDown(){
        taskDto = null;
    }

    @Test
    @DisplayName("Task can be instantiate")
    void taskCanBeInstantiate(){
        Task task = TaskDto.unpackDto(taskDto);
        assertAll(
                ()-> assertThat(task.getTaskName()).isEqualTo("Teach"),
                ()-> assertThat(task.getId()).isNotNull(),
                ()-> assertThat(task.getTaskDescription()).isEqualTo(taskDto.getTaskDescription()),
                ()-> assertThat(task.getCreatedTime()).isNotNull()
        );

    }
    @Test
    @DisplayName("Task can be created")
    void taskCanBeCreatedByUser(){
         taskService.createTask(taskDto);
         AssertionsForClassTypes.assertThat(taskDataBase.size()).isEqualTo(1);
    }
}
