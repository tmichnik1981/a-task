package com.me.poc.domain.game.gamemap.location;

public class Town extends Location {

    private static final String DEFAULT_NAME = "In a town";
    private static final String DEFAULT_DESCRIPTION_NAME = "You are entering a town";

    public Town(String name, String description, LocationStatus status) {
        super(name, description, status);
    }

    public Town() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION_NAME, LocationStatus.UNEXPLORED);
    }

    public Town(LocationBuilder locationBuilder) {
        super(locationBuilder);
    }
}
