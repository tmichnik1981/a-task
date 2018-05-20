package com.me.poc.domain.game.gamemap;

import com.me.poc.domain.game.gamemap.location.Location;
import com.me.poc.domain.game.gamemap.location.LocationStatus;
import com.me.poc.domain.game.gamemap.location.Start;
import com.me.poc.domain.game.player.Player;

import java.util.*;

public class GameMap {

    static final int STARTING_LOCATION_ROW = 0;
    static final int STARTING_LOCATION_COL = 2;

    static final int MAX_ROWS = 5;
    static final int MAX_COLS = 6;

    private final Location[][] locationsMatrix = new Location[MAX_ROWS][MAX_COLS];

    private Location lastLocation;

    public Location movePlayerOnStart(Player player) {
        Location start = locationsMatrix[STARTING_LOCATION_ROW][STARTING_LOCATION_COL];
        start.putPlayer(player);
        lastLocation = start;
        unveilNeighboringLocations(start);
        return lastLocation;
    }

    public void movePlayerTo(int x, int y) {
        Player player = lastLocation.removePlayer();
        Location destination = locationsMatrix[x][y];
        destination.putPlayer(player);
        lastLocation = destination;

        unveilNeighboringLocations(destination);
    }

    void unveilNeighboringLocations(Location destination) {

        if (!LocationStatus.UNSAFE.equals(destination.getStatus())) {
            int row = destination.getRowOnMap();
            int col = destination.getColOnMap();
            getLocation(row, col + 1).ifPresent(Location::unveil);
            getLocation(row, col - 1).ifPresent(Location::unveil);
            getLocation(row + 1, col).ifPresent(Location::unveil);
            getLocation(row - 1, col).ifPresent(Location::unveil);
        }

    }

    private Optional<Location> getLocation(int row, int col) {
        return Optional.ofNullable(locationsMatrix[row][col]);
    }

    public boolean put(Location location, int x, int y) {

        if (!getLocation(x, y).isPresent()) {
            locationsMatrix[x][y] = location;
            location.updatePosition(x, y);
            return true;
        }

        return false;
    }

    public Optional<Location> putAndReplace(Location newLocation, int x, int y) {

        Location oldLocation = getLocation(x, y).get();
        locationsMatrix[x][y] = newLocation;
        newLocation.updatePosition(x, y);
        return Optional.ofNullable(oldLocation);
    }

    public void initRandomly(List<Location> allLocations) {

        locationsMatrix[STARTING_LOCATION_ROW][STARTING_LOCATION_COL] = new Start();

        Random random = new Random();
        Set<Integer> uniqueDrawNumbers = new HashSet<>();

        for (int row = 0; row < MAX_ROWS; ++row) {

            for (int col = 0; col < MAX_COLS; ++col) {

                if (locationsMatrix[row][col] == null)

                    while (true) {
                        int drawLocationIndex = random.nextInt(allLocations.size());
                        if (!uniqueDrawNumbers.contains(drawLocationIndex)) {
                            uniqueDrawNumbers.add(drawLocationIndex);

                            Location selectedLocation = allLocations.get(drawLocationIndex);
                            selectedLocation.updatePosition(row, col);
                            locationsMatrix[row][col] = selectedLocation;
                            break;

                        }
                    }
            }

        }
    }


}
