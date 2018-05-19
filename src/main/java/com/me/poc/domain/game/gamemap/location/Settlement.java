package com.me.poc.domain.game.gamemap.location;

public class Settlement extends Location{


    private static final String DEFAULT_NAME = "In a settlement";
    private static final String DEFAULT_DESCRIPTION_NAME = "You are entering a settlement";


    public Settlement() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION_NAME, LocationStatus.UNEXPLORED);
    }

    public Settlement(LocationBuilder locationBuilder) {
        super(locationBuilder);
    }
}
