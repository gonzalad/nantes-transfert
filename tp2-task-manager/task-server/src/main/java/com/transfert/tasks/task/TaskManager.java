package com.transfert.tasks.task;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

public class TaskManager {
    public TaskManager(TaskRepository taskRepository) {

    }

    Page<Task> findAll(PageRequest pageRequest) {
        return new PageImpl<>(List.of(), pageRequest, 0L);
    }
}
