package com.transfert.tasks.task;

import java.util.UUID;

public class Task {
    private final UUID id;
    private final String name;

    public Task(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
}
