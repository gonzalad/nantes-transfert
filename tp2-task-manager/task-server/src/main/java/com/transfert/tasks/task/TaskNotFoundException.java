package com.transfert.tasks.task;

import java.util.UUID;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(UUID id) {
        super("Tâche " + id + " inexistante");
    }
}
