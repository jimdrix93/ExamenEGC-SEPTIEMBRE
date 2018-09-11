package es.egc.tasks;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * GreetingRepository
 */
public interface TaskRepository extends CrudRepository<Task, Long> {
    List<Task> findByName(String name);
}