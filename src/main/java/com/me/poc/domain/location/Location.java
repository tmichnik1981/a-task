package com.me.poc.domain.location;

import java.io.Serializable;

import static com.me.poc.domain.location.LocationStatus.UNEXPLORED;

public class Location implements Serializable{

    private String code;
    private String name;
    private String description;
    private LocationStatus status;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocationStatus getStatus() {
        return status;
    }

    public Location(LocationBuilder locationBuilder) {
        this.name = locationBuilder.name;
        this.description = locationBuilder.description;
        this.status = locationBuilder.status;
        this.code = locationBuilder.code;
    }

    public static LocationBuilder builder() {
        return new LocationBuilder();
    }

    public static class LocationBuilder {
        private String code;
        private String name;
        private String description;
        private LocationStatus status = UNEXPLORED;

        public LocationBuilder withCode(String code) {
            this.code = code;
            return this;
        }

        public LocationBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public LocationBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public LocationBuilder withLocationStatus(LocationStatus status) {
            this.status = status;
            return this;
        }


        public Location build() {
            return new Location(this);
        }

    }

}
