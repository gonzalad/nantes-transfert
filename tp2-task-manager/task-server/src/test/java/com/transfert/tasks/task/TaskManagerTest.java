package com.transfert.tasks.task;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

class TaskManagerTest {
    private TaskManager taskManager;
    private TaskServicePort taskServicePort;

    @BeforeEach
    void setUp() {
        taskServicePort = mock(TaskServicePort.class);
        taskManager = new TaskManager(taskServicePort);
    }

    @Test
    void whenFindAllThenVerifyTasksReturnedFromRepository() {
        PageRequest pageRequest = PageRequest.of(0, 10);
        PageImpl<Task> page = new PageImpl<>(List.of(new Task(UUID.randomUUID(), "someTask")), pageRequest, 1L);
        when(taskServicePort.findAll(pageRequest)).thenReturn(page);

        Page<Task> tasks = taskManager.findAll(pageRequest);

        assertThat(tasks).isSameAs(page);
    }

    @Test
    void whenFindByIdThenVerifyTasksReturnedFromRepository() {
        UUID id = UUID.randomUUID();
        Task task = new Task(id, "hello");
        when(taskServicePort.findById(id)).thenReturn(Optional.of(task));

        Optional<Task> tasks = taskManager.findById(id);

        assertThat(tasks).get().isSameAs(task);
    }

    @Test
    void whenCreateThenVerifyTaskCopiedAndCreatedInRepository() {
        String taskName = "name";
        TaskCreateCommand command = new TaskCreateCommand(taskName);
        when(taskServicePort.existsByName(taskName)).thenReturn(false);
        Task created = new Task(UUID.randomUUID(), taskName);
        when(taskServicePort.save(any())).thenReturn(created);

        Task task = taskManager.create(command);

        assertThat(task).isSameAs(created);
        ArgumentCaptor<Task> argumentCaptor = ArgumentCaptor.forClass(Task.class);
        verify(taskServicePort).save(argumentCaptor.capture());
        Task saved = argumentCaptor.getValue();
        assertThat(saved).isNotNull();
        assertThat(saved.getName()).isEqualTo(taskName);
    }

    @Test
    void givenTaskNameAlreadyExistsWhenCreateThenVerifyError() {
        String taskName = "name";
        TaskCreateCommand command = new TaskCreateCommand(taskName);
        when(taskServicePort.existsByName(taskName)).thenReturn(true);

        Throwable thrown = catchThrowable(() -> taskManager.create(command));

        assertThat(thrown).isInstanceOf(TaskNameAlreadyExistsException.class);
        verify(taskServicePort, never()).save(any());
    }

    @Test
    void whenUpdateThenVerifyTaskCopiedAndUpdatedInRepository() {
        TaskUpdateCommand command = new TaskUpdateCommand(UUID.randomUUID(), "name");
        Task taskInDb = new Task(command.getId(), "previousName");
        when(taskServicePort.findById(command.getId())).thenReturn(Optional.of(taskInDb));

        Task task = taskManager.update(command);

        assertThat(task).isSameAs(taskInDb);
        verify(taskServicePort).save(taskInDb);
        assertThat(taskInDb.getName()).isEqualTo(command.getName());
    }

    @Test
    void givenInexistantTaskWhenUpdateThenError() {
        TaskUpdateCommand command = new TaskUpdateCommand(UUID.randomUUID(), "name");
        when(taskServicePort.findById(command.getId())).thenReturn(Optional.empty());

        Throwable thrown = catchThrowable(() -> taskManager.update(command));

        assertThat(thrown).isInstanceOf(TaskNotFoundException.class);
    }

    @Test
    void whenDeleteThenVerifyDeletedInRepository() {
        UUID id = UUID.randomUUID();
        when(taskServicePort.existsById(id)).thenReturn(true);

        taskManager.delete(id);

        verify(taskServicePort).deleteById(id);
    }

    @Test
    void givenInexistantTaskWhenDeleteThenError() {
        UUID id = UUID.randomUUID();
        when(taskServicePort.existsById(id)).thenReturn(false);

        Throwable thrown = catchThrowable(() -> taskManager.delete(id));

        assertThat(thrown).isInstanceOf(TaskNotFoundException.class);
    }
}
