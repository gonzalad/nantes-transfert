package com.transfert.tasks.config;

import com.transfert.tasks.web.PageableToPageRequestConverter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        // registry.addConverter(new PageableToPageRequestConverter());
    }
}