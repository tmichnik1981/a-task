package com.me.poc.service;

import java.util.HashMap;
import java.util.Map;

public class ServicesContainer {

    private static final Map<String, ApplicationService> services = new HashMap<>();

    private ServicesContainer() {
    }


    {
        services.put("startService", new StartService());
        services.put("newGameService", new NewGameService());
        services.put("continueGame", new ContinueGameService());
        services.put("gameService", new GameService());
    }

    public ApplicationService getService(String serviceName) {
        return services.get(serviceName);
    }


    public static ServicesContainer getInstance() {
        return SingletonHelper.instance;
    }

    private static class SingletonHelper {
        private static final ServicesContainer instance = new
                ServicesContainer();
    }
}
