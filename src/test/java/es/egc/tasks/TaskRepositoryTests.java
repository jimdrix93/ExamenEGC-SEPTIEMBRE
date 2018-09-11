package es.egc.tasks;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * GreetingRepositoryTests
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class TaskRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;
    
    @Autowired
    private TaskRepository greetings;

    @Test
    public void testFindByLastName() {
        Task task = new Task("es", "Hola");
        entityManager.persist(task);

        List<Task> findByLang = greetings.findByName(task.getName());

        assertThat(findByLang).extracting(Task::getName).containsOnly(task.getName());
    }    
}