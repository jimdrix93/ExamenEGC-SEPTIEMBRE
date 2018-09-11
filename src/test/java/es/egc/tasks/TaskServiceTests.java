package es.egc.tasks;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * GreetingTranslatorTests
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes={Application.class})
public class TaskServiceTests {
    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskRepository repository;

    @Test
    public void testAddTask() {
        long numberOfTasks = repository.count();
        Task task = new Task("TODO", "Work");
        taskService.add(task);

        long newNumberOfTasks = repository.count();
        assertThat(newNumberOfTasks).isEqualTo(numberOfTasks+1);
    }

    @Test
    public void testGetTask() {
        Task task = new Task("TODO", "Work");
        Task r = taskService.add(task);

        Task newTask = taskService.getTask(r.getId());
        assertThat(newTask.getName()).isEqualTo(task.getName());
        assertThat(newTask.getContext()).isEqualTo(task.getContext());
    }
    
}