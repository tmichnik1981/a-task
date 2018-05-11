package com.me.poc.controller;


import com.me.poc.service.ServicesContainer;
import com.me.poc.view.GenericTemplate;
import com.me.poc.view.ViewMenu;
import com.me.poc.view.ViewTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Controller implements Runnable {

    private final ServicesContainer servicesContainer;
    /*private final TemplateResolver templateResolver;*/
    private final ViewTemplate template;
    private final View startingView = View.START;

    public Controller(ServicesContainer servicesContainer, GenericTemplate template) {
        this.template = template;
        this.servicesContainer = servicesContainer;
    }

    @Override
    public void run() {

        //TODO:do usuniecia
        int k = 0;

        Map<String, String> requestParams = Collections.EMPTY_MAP;

        View currentView = startingView;
        do {

            TransferObject transferObject = servicesContainer.getService(currentView).handle(requestParams);

            //TODO:do usuniecia
            if(transferObject == null){
                System.out.println("Ending...");
                break;
            }

            if (transferObject.isRedirect()) {
                currentView = transferObject.getView();
                requestParams = Collections.EMPTY_MAP;
                continue;
            }

            requestParams = template.render(transferObject.getViewModel());

            if (requestParams.containsKey(ViewMenu.INPUT_KEY) && ViewMenu.QUIT.equalsIgnoreCase(requestParams.get(ViewMenu.INPUT_KEY))) {
                break;
            }
            ++k;
        } while (k < 10);

    }
}
