package com.transfert.tasks.web;

import com.transfert.tasks.rest.model.Pageable;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
public class PageableToPageRequestConverter implements Converter<Pageable, PageRequest> {
    @Override
    public PageRequest convert(Pageable value) {
        if (value == null) {
            return PageRequest.ofSize(10);
        }
        Integer size = value.getTaille();
        if (size == null || size <= 0) {
            size = 20;
        }
        return PageRequest.of(value.getPage(), size);
    }
}
