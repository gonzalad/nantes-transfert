package com.transfert.tasks.task;

import java.util.UUID;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TaskRepository extends PagingAndSortingRepository<Task, UUID> {
}
