package com.me.poc.domain.game.location;

public class Forest extends Location{

    private static final String DEFAULT_NAME = "In the woods";
    private static final String DEFAULT_DESCRIPTION_NAME = "You are entering the woods";



    public Forest() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION_NAME, LocationStatus.UNEXPLORED);
    }

    public Forest(LocationBuilder locationBuilder) {
        super(locationBuilder);
    }
}
