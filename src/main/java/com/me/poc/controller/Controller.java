package com.me.poc.controller;


import com.me.poc.service.ServicesContainer;
import com.me.poc.view.ViewTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Controller implements Runnable {

    private final ServicesContainer servicesContainer;
    private final TemplateResolver templateResolver;
    private final View startingView = View.START;

    public Controller(ServicesContainer servicesContainer, TemplateResolver templateResolver) {
        this.templateResolver = templateResolver;
        this.servicesContainer = servicesContainer;
    }

    @Override
    public void run() {

        //TODO:do usuniecia
        int k = 0;

        Map<String, String> requestParams = new HashMap<>();

        View currentView = startingView;
        do {
            System.out.println("Controller runs rendering " + k);

            TransferObject transferObject = servicesContainer.getService(currentView).handle(requestParams);

            if(transferObject.isRedirect()){
                currentView = transferObject.getView();
                requestParams = Collections.EMPTY_MAP;
                continue;
            }

            ViewTemplate template = templateResolver.resolve(transferObject.getView());

            requestParams = template.render(transferObject.getViewModel());


            System.out.println("Controller after rendering " + k );
            ++k;
        } while (k < 3);

    }
}
