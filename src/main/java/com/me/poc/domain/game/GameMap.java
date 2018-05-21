package com.me.poc.domain.game;

import com.me.poc.domain.game.location.Location;
import com.me.poc.domain.game.location.LocationStatus;
import com.me.poc.domain.game.location.Position;
import com.me.poc.domain.game.location.Start;
import com.me.poc.domain.game.player.Player;

import java.util.*;

public class GameMap {

    static final int STARTING_LOCATION_ROW = 0;
    static final int STARTING_LOCATION_COL = 2;

    static final int MAX_ROWS = 5;
    static final int MAX_COLS = 6;

    private final Location[][] locationsMatrix = new Location[MAX_ROWS][MAX_COLS];

    private Location currentLocation;

    void movePlayerOnStart(Player player) {
        Location start = locationsMatrix[STARTING_LOCATION_ROW][STARTING_LOCATION_COL];
        start.putPlayer(player);
        currentLocation = start;
        unveilNeighboringLocations(start);
    }

    LocationStatus movePlayerTo(int x, int y) {
        Player player = currentLocation.removePlayer();
        Location destination = locationsMatrix[x][y];
        LocationStatus status = destination.putPlayer(player);
        currentLocation = destination;

        unveilNeighboringLocations(destination);

        return status;
    }

    List<Position> getPossibleMoves() {
        int row = currentLocation.getRowOnMap();
        int col = currentLocation.getColOnMap();

        List<Position> positions = new ArrayList<>();

        int[][] modifiers = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int counter = 0;
        while (counter < 4) {
            int rowToTest = row + modifiers[counter][0];
            int colToTest = col + modifiers[counter][1];
            if (inDimensions(rowToTest, colToTest)) {
                positions.add(new Position(rowToTest, colToTest));
            }
            counter++;
        }

        return positions;
    }


    private void unveilNeighboringLocations(Location destination) {

        if (!LocationStatus.DUEL.equals(destination.getStatus())) {
            int row = destination.getRowOnMap();
            int col = destination.getColOnMap();
            getLocation(row, col + 1).ifPresent(Location::unveil);
            getLocation(row, col - 1).ifPresent(Location::unveil);
            getLocation(row + 1, col).ifPresent(Location::unveil);
            getLocation(row - 1, col).ifPresent(Location::unveil);
        }

    }

    private Optional<Location> getLocation(int row, int col) {
        if (inDimensions(row, col)) {
            return Optional.ofNullable(locationsMatrix[row][col]);
        }
        return Optional.empty();
    }

    private boolean inDimensions(int row, int col) {
        return (row > 0 && row < MAX_ROWS && col > 0 && col < MAX_COLS);
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
