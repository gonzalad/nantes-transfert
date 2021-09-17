package com.transfert.tasks.task;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class TaskManager {
    private final TaskServicePort taskServicePort;

    public TaskManager(TaskServicePort taskRepository) {
        this.taskServicePort = taskRepository;
    }

    public Page<Task> findAll(PageRequest pageRequest) {
        return taskServicePort.findAll(pageRequest);
    }

    public Optional<Task> findById(UUID id) {
        return taskServicePort.findById(id);
    }

    public Task create(TaskCreateCommand command) {
        String taskName = command.getName();
        if (taskServicePort.existsByName(taskName)) {
            throw new TaskNameAlreadyExistsException(taskName);
        }
        var task = newTask(taskName);
        return taskServicePort.save(task);
    }

    private Task newTask(String taskName) {
        return new Task(UUID.randomUUID(), taskName);
    }

    public Task update(TaskUpdateCommand command) {
        var task = taskServicePort.findById(command.getId()).orElseThrow(() -> new TaskNotFoundException(command.getId()));
        copy(command, task);
        taskServicePort.save(task);
        return task;
    }

    private void copy(TaskUpdateCommand command, Task task) {
        task.setName(command.getName());
    }

    public void delete(UUID id) {
        if (!taskServicePort.existsById(id)) {
            throw new TaskNotFoundException(id);
        }
        taskServicePort.deleteById(id);
    }
}
