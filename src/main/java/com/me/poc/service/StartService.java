package com.me.poc.service;

import com.me.poc.controller.TransferObject;
import com.me.poc.controller.View;
import com.me.poc.view.ViewMenu;
import com.me.poc.view.ViewModel;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StartService implements ApplicationService {

    @Override
    public TransferObject handle(Map<String, String> requestParams) {

        TransferObject.TransferObjectBuilder transferObjectBuilder = TransferObject.builder();

        if (requestParams.isEmpty()) {
            ViewModel.ViewModelBuilder viewModelBuilder = ViewModel.builder()
                .withTitle("Start")
                .withIntro("Welcome to Any RPG!!!");

            Set<String> allowedValues = new HashSet<>();
            allowedValues.add("M1");
            allowedValues.add("M2");
            allowedValues.add("Q");

            ViewMenu menu = new ViewMenu("NEW GAME (M1)  CONTINUE (M2)  QUIT (Q)", allowedValues);
            viewModelBuilder.withMenu(menu);

            transferObjectBuilder.withRedirect(false);
            transferObjectBuilder.withView(View.START);
            transferObjectBuilder.withViewModel(viewModelBuilder.build());
        }

        return transferObjectBuilder.build();
    }
}
