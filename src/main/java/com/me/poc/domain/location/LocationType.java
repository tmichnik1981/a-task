package com.me.poc.domain.location;

public enum LocationType {
    START("start"), GRASSLAND("grassland"), ROAD("road"), WOODS("woods"), TOWN("town"), WETLANDS("wetlands"),
    SETTLEMENT("settlement");

    LocationType(String name) {
        this.name = name;
    }

    private String name;

    public static LocationType parse(String code) {
        for (LocationType eachLocationType : values()) {
            if (eachLocationType.name.equalsIgnoreCase(code)) {
                return eachLocationType;
            }
        }
        throw new IllegalArgumentException("Unknown location type " + code);
    }
}
