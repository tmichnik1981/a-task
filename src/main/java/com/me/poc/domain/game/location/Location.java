package com.me.poc.domain.game.location;

import com.me.poc.domain.game.enemy.Enemy;
import com.me.poc.domain.game.player.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static com.me.poc.domain.game.location.LocationStatus.UNEXPLORED;

public abstract class Location implements Serializable {

    private final UUID id;
    private final String name;
    private final String description;
    private LocationStatus status;
    private final List<Enemy> enemies = new ArrayList();
    private Player player;

    private int rowOnMap;
    private int colOnMap;

    public UUID getId() {
        return id;
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

    public int getRowOnMap() {
        return rowOnMap;
    }

    public int getColOnMap() {
        return colOnMap;
    }

    public LocationStatus putPlayer(Player player) {
        this.player = player;
        changeStatusOnPlayerEnter();
        return status;
    }

    public Player removePlayer() {
        Player leavingPlayer = this.player;
        this.player = null;
        return leavingPlayer;
    }

    private void changeStatusOnPlayerEnter() {
        if (enemies.isEmpty()) {
            status = LocationStatus.EXPLORED;
        } else {
            status = LocationStatus.DUEL;
        }
    }

    public void unveil() {
        if(LocationStatus.UNEXPLORED.equals(status)){
            status = LocationStatus.UNKNOWN;
        }
    }

    public void updatePosition(int row, int col) {
        this.rowOnMap = row;
        this.colOnMap = col;
    }


    public Location(String name, String description, LocationStatus status) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.id = UUID.randomUUID();
    }

    public Location(LocationBuilder locationBuilder) {
        this.name = locationBuilder.name;
        this.description = locationBuilder.description;
        this.status = locationBuilder.status;
        this.rowOnMap = locationBuilder.rowOnMap;
        this.colOnMap = locationBuilder.colOnMap;
        this.id = UUID.randomUUID();
    }


    public static Location ofType(LocationType locationType) {
        switch (locationType) {
            case TOWN:
                return new Town();
            case GRASSLAND:
                return new Grassland();
            case START:
                return new Start();
            case WOODS:
                return new Forest();
            case WETLANDS:
                return new Wetlands();
        }
        throw new RuntimeException("Cannot create a Location of unknown type");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(id, location.id) &&
                Objects.equals(name, location.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    public static LocationBuilder builder() {
        return new LocationBuilder();
    }




    public static class LocationBuilder {
        private LocationType type;
        private String name;
        private String description;
        private LocationStatus status = UNEXPLORED;
        private int rowOnMap;
        private int colOnMap;


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

        public LocationBuilder withType(LocationType type) {
            this.type = type;
            return this;
        }

        public LocationBuilder withRowOnMap(int rowOnMap) {
            this.rowOnMap = rowOnMap;
            return this;
        }

        public LocationBuilder withColOnMap(int colOnMap) {
            this.colOnMap = colOnMap;
            return this;
        }

        public Location build() {

            switch (type) {
                case TOWN:
                    return new Town(this);
                case GRASSLAND:
                    return new Grassland(this);
                case START:
                    return new Start(this);
                case WOODS:
                    return new Forest(this);
                case WETLANDS:
                    return new Wetlands(this);
            }
            throw new RuntimeException("Cannot create a Location");
        }


        public void clear() {
            LocationType type = null;
            String name = "";
            String description = "";
            LocationStatus status = UNEXPLORED;
        }
    }

}
