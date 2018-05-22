package com.me.poc.domain.location;

public class Start extends Location {

    private static final String DEFAULT_NAME = "Starting position";
    private static final String DEFAULT_DESCRIPTION_NAME = "You are starting a new game";

    public Start() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION_NAME, LocationStatus.UNEXPLORED);
    }

    public Start(LocationBuilder locationBuilder) {
        super(locationBuilder);
    }
}
