package es.egc.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(TaskRepository taskService) {
        return (evt) -> {
            logger.info("Initializing database with some content...");

            taskService.save(new Task("Add pom.xml", "Exam"));
            taskService.save(new Task("Add Dockerfile", "Exam"));
        };
    }

}