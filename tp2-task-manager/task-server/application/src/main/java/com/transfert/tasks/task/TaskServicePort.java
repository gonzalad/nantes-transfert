package com.transfert.tasks.task;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface TaskServicePort {

    boolean existsById(UUID id);

    boolean existsByName(String name);

    void deleteById(UUID id);

    Task save(Task task);

    Optional<Task> findById(UUID id);

    Page<Task> findAll(PageRequest pageRequest);
}
