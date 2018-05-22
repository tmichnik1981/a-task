package com.me.poc.domain.location;

public class Grassland extends Location {

    private static final String DEFAULT_NAME = "Grassland";
    private static final String DEFAULT_DESCRIPTION_NAME = "You are in a grassland";


    public Grassland() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION_NAME, LocationStatus.UNEXPLORED);
    }

    public Grassland(LocationBuilder locationBuilder) {
        super(locationBuilder);
    }
}