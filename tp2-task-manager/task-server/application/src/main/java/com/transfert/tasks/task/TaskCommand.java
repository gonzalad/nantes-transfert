package com.transfert.tasks.task;

public abstract class TaskCommand {
    private final String name;

    public TaskCommand(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
