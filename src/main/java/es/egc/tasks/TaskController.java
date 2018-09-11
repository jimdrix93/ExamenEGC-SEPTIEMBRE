package es.egc.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class TaskController {

    @Autowired
	private TaskService taskService;

    @RequestMapping(value = "/tareas")
    public Iterable<Task> tasks() {
        return taskService.getAllTasks();
    }

    @RequestMapping(value = "/tareas", method = RequestMethod.POST)
    public ResponseEntity<?> addGreeting(@RequestBody Task task) {
        Task t = taskService.add(new Task(task.getName(), task.getContext()));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(t.getId()).toUri();

        return ResponseEntity.created(location).build();
    }


    @RequestMapping(value = "/tareas/{taskId}")
    public Task taskById(@PathVariable Long taskId) {
        return taskService.getTask(taskId);
    }

}
