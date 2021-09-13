package com.transfert.tasks.task;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TaskRepository extends PagingAndSortingRepository<Task, UUID> {

    boolean existsByName(String name);
}
