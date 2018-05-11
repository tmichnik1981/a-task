package com.me.poc.service;

import com.me.poc.controller.View;
import com.me.poc.repository.GameRepository;

import java.util.HashMap;
import java.util.Map;

public class ServicesContainer {

    private static final Map<View, ApplicationService> services = new HashMap<>();

    private ServicesContainer() {
    }

    {
        services.put(View.START, new StartService());
        services.put(View.NEW_GAME, new NewGameService());
        services.put(View.CONTINUE_GAME, new ContinueGameService(new GameRepository()));
        services.put(View.GAME, new GameService());
    }

    public ApplicationService getService(View view) {
        return services.get(view);
    }

    public static ServicesContainer getInstance() {
        return SingletonHelper.instance;
    }

    private static class SingletonHelper {
        private static final ServicesContainer instance = new
            ServicesContainer();
    }
}
