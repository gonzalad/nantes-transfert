package com.transfert.tasks.task;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

public class TaskManager {
    private final TaskRepository taskRepository;

    public TaskManager(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Page<Task> findAll(PageRequest pageRequest) {
        return taskRepository.findAll(pageRequest);
    }

    public Optional<Task> findById(UUID id) {
        return taskRepository.findById(id);
    }

    public Task create(TaskCreateCommand command) {
        String taskName = command.getName();
        if (taskRepository.existsByName(taskName)) {
            throw new TaskNameAlreadyExistsException(taskName);
        }
        Task task = newTask(taskName);
        return taskRepository.save(task);
    }

    private Task newTask(String taskName) {
        return new Task(UUID.randomUUID(), taskName);
    }

    public Task update(TaskUpdateCommand command) {
        Task task = taskRepository.findById(command.getId()).orElseThrow(()  -> new TaskNotFoundException(command.getId()));
        copy(command, task);
        taskRepository.save(task);
        return task;
    }

    private void copy(TaskUpdateCommand command, Task task) {
        task.setName(command.getName());
    }

    public void delete(UUID id) {
        if (!taskRepository.existsById(id)) {
            throw new TaskNotFoundException(id);
        }
        taskRepository.deleteById(id);
    }
}
