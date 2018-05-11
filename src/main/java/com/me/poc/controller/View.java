package com.me.poc.controller;

public enum View {

    START(Template.GENERIC), NEW_GAME(Template.GENERIC), CONTINUE_GAME(Template.GENERIC), GAME(Template.GENERIC);

    private Template template;

    View(Template template) {
        this.template = template;
    }

    public Template getTemplate() {
        return template;
    }
}
