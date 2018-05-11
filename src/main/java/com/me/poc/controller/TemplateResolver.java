package com.me.poc.controller;

import com.me.poc.view.ViewTemplate;

import java.util.Map;

public class TemplateResolver {

    private final Map<Template, ViewTemplate> templates;

    public TemplateResolver(Map<Template, ViewTemplate> templates) {
        this.templates = templates;
    }

    public ViewTemplate resolve(View view) {
        return templates.get(view.getTemplate());
    }
}
