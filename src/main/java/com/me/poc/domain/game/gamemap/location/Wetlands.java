package com.me.poc.domain.game.gamemap.location;

public class Wetlands extends Location {

    private static final String DEFAULT_NAME = "In the wetlands";
    private static final String DEFAULT_DESCRIPTION_NAME = "You are entering the wetlands";


    public Wetlands() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION_NAME, LocationStatus.UNEXPLORED);
    }

    public Wetlands(LocationBuilder locationBuilder) {
        super(locationBuilder);
    }
}
