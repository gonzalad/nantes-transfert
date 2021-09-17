package com.transfert.tasks.task;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Task {
    @Id
    private UUID id;
    private String name;

    // Empty constructor for JPA
    @SuppressWarnings("unused")
    Task() {
    }

    public Task(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }
}
