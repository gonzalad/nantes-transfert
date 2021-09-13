package com.transfert.tasks.task;

import com.transfert.tasks.rest.api.TasksApi;
import com.transfert.tasks.rest.model.Pageable;
import com.transfert.tasks.rest.model.PagedTasks;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TaskController implements TasksApi {

    private final TaskManager taskManager;

    private final ConversionService conversionService;

    public TaskController(TaskManager taskManager, ConversionService conversionService) {
        this.taskManager = taskManager;
        this.conversionService = conversionService;
    }

    @Override
    public ResponseEntity<PagedTasks> findAllTasks(Pageable pageable) {
        PageRequest pageRequest = conversionService.convert(pageable, PageRequest.class);

        Page<Task> tasks = taskManager.findAll(pageRequest);

        return ResponseEntity.ok(conversionService.convert(tasks, PagedTasks.class));
    }
}
