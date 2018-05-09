package com.me.poc.controller;


import com.me.poc.view.GenericTemplate;
import com.me.poc.view.ViewModel;

import java.util.Map;

public class Controller implements Runnable {

    public Controller(Map<String, ViewModel> viewModels) {
        this.viewModels = viewModels;
    }

    GenericTemplate genericTemplate = new GenericTemplate();
    String currentView = "start";
    Map<String, ViewModel> viewModels;

    @Override
    public void run() {



        int k = 0;
        String results;
        do  {

            System.out.println("Controller runs rendering " + k);
              results =  genericTemplate.render(viewModels.get(currentView));


            System.out.println("Controller after rendering " + k + " results: " + results);
            ++k;
        }while ("M3".equalsIgnoreCase(results));


    }
}
