package com.me.poc.domain.location;

public class Woods extends Location{

    private static final String DEFAULT_NAME = "In the woods";
    private static final String DEFAULT_DESCRIPTION_NAME = "You are entering the woods";

    public Woods(String name, String description, LocationStatus status) {
        super(name, description, status);
    }

    public Woods() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION_NAME, LocationStatus.UNEXPLORED);
    }

    public Woods(LocationBuilder locationBuilder) {
        super(locationBuilder);
    }
}
