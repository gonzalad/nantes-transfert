package com.transfert.tasks.task;

import java.util.List;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

class TaskManagerTest {
    private TaskManager taskManager;
    private TaskRepository taskRepository;

    @BeforeEach
    void setUp() {
        taskRepository = mock(TaskRepository.class);
        taskManager = new TaskManager(taskRepository);
    }

    @Test
    void givenNoTasksWhenFindAllThenVerifyEmptyList() {
        PageRequest pageRequest = PageRequest.of(0, 10);

        Page<Task> tasks = taskManager.findAll(pageRequest);

        assertThat(tasks).isEmpty();
    }

    @Test
    void whenFindAllThenVerifyTasksFromDbReturned() {
        PageRequest pageRequest = PageRequest.of(0, 10);
        PageImpl<Task> page = new PageImpl<>(List.of(new Task(UUID.randomUUID(), "someTask")), pageRequest, 1L);
        when(taskRepository.findAll(pageRequest)).thenReturn(page);

        Page<Task> tasks = taskManager.findAll(pageRequest);

        assertThat(tasks).isSameAs(page);
    }
}
