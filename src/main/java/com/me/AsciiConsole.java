package com.me;


import com.me.poc.controller.Controller;
import com.me.poc.view.ViewCommand;
import com.me.poc.view.ViewModel;

import java.util.*;

public class AsciiConsole {


        //TODO: inicjalizacja frameworka gry
    public void start() {
        Map<String, ViewModel> viewModels = new HashMap();

        ViewModel startModel = new ViewModel();
        startModel.setTitle("Start");
        startModel.setDescription("Welcome to Any RPG!!!");
        startModel.setMenu("NEW GAME (M1)  CONTINUE (M2)  EXIT (M3)");
        ViewCommand viewCommand = new ViewCommand();

        viewCommand.setText(">");
        Set<String> allowedCommands = new HashSet<>();
        allowedCommands.add("M1");
        allowedCommands.add("M2");
        allowedCommands.add("M3");
        viewCommand.setAllowedValues(allowedCommands);

        startModel.setCommand(viewCommand);

        viewModels.put("start",startModel );

        new Thread(new Controller(viewModels)).start();

    }


}
