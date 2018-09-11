package es.egc.tasks;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String context;

    protected Task() {}

    public Task(String name, String context) {
        super();
        this.name = name;
        this.context = context;
    }

    public Long getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the context
     */
    public String getContext() {
        return context;
    }

}