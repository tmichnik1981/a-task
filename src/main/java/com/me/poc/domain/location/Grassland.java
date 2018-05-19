package com.me.poc.domain.location;

public class Grassland extends Location {

    private static final String DEFAULT_NAME = "Grassland";
    private static final String DEFAULT_DESCRIPTION_NAME = "You are in a grassland";

    public Grassland(String name, String description, LocationStatus status) {
        super(name, description, status);
    }

    public Grassland() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION_NAME, LocationStatus.UNEXPLORED);
    }

    public Grassland(LocationBuilder locationBuilder) {
        super(locationBuilder);
    }
}