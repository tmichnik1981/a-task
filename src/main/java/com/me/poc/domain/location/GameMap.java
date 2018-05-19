package com.me.poc.domain.location;

import java.io.Serializable;

public class GameMap implements Serializable{
    private final Location[][] locationsMap;


    public GameMap(Location[][] locationsMap) {
        this.locationsMap = locationsMap;
    }

    public Location[][] getLocationsMap() {
        return locationsMap;
    }
}
