package com.transfert.tasks.task;

public class TaskNameAlreadyExistsException extends RuntimeException {
    public TaskNameAlreadyExistsException(String taskName) {
        super("Une tâche de nom " + taskName + " existe déjà");
    }
}
