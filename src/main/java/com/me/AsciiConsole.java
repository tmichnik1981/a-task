package com.me;


import com.me.poc.controller.Controller;
import com.me.poc.controller.Template;
import com.me.poc.controller.TemplateResolver;
import com.me.poc.service.ServicesContainer;
import com.me.poc.view.GenericTemplate;
import com.me.poc.view.NewGameTemplate;
import com.me.poc.view.ViewTemplate;

import java.util.HashMap;
import java.util.Map;

public class AsciiConsole {

    public void start() {

        Map<Template, ViewTemplate> templates = new HashMap<>();
        templates.put(Template.GENERIC, new GenericTemplate());
        templates.put(Template.NEW_GAME, new NewGameTemplate());

        ServicesContainer servicesContainer = ServicesContainer.getInstance();
        TemplateResolver templateResolver = new TemplateResolver(templates);

        new Thread(new Controller(servicesContainer, templateResolver)).start();
    }


}
