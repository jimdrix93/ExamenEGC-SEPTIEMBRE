package es.egc.tasks;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskService {

	@Autowired
	private TaskRepository repository;
	
	public Task getTask(Long id) {
 		return repository.findOne(id);
	}

	public Task add(Task newTask) {
		return repository.save(newTask);
	}

	public Iterable<Task> getAllTasks() {
		return repository.findAll();
	}

}