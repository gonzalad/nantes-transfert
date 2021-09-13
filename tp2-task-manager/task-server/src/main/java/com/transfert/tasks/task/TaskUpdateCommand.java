package com.transfert.tasks.task;

import java.util.UUID;

public class TaskUpdateCommand extends TaskCommand {
    private final UUID id;

    public TaskUpdateCommand(UUID id, String name) {
        super(name);
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
