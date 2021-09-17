package com.transfert.tasks.web;

import java.util.stream.Collectors;
import com.transfert.tasks.rest.model.PagedTasks;
import com.transfert.tasks.task.Task;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class PagedTaskConverter implements Converter<Page<Task>, PagedTasks> {
    @Override
    public PagedTasks convert(Page<Task> source) {
        if (source == null) {
            return null;
        }
        return new PagedTasks()
            .page(source.getNumber())
            .taille(source.getSize())
            .totalPages(source.getTotalPages())
            .items(source.stream().map(this::convertToApi).collect(Collectors.toList()));
    }

    private com.transfert.tasks.rest.model.Task convertToApi(Task value) {
        return new com.transfert.tasks.rest.model.Task()
            .id(value.getId().toString())
            .name(value.getName());
    }
}
