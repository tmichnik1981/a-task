package com.me.poc.domain.game;

import com.me.poc.domain.game.location.Location;
import com.me.poc.domain.game.location.LocationType;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class GameMapFactory {

    static final String LOCATION_SOURCE_FILE = "locations.csv";

    private static final int EXTRA_STARTING_LOCATION = 1;

    private final CsvReader csvReader;

    public GameMapFactory(CsvReader csvReader) {
        this.csvReader = csvReader;
    }


    public GameMap create() {

        List<Location> loadedLocations = loadLocationsFromFile();

        List<Location> allLocations = new ArrayList<>(loadedLocations);

        allLocations.addAll(generateLackingLocations(loadedLocations.size()));

        GameMap gameMap = new GameMap();

        gameMap.initRandomly(allLocations);


        return gameMap;
    }

    private List<Location> generateLackingLocations(int loadedLocationsNumber) {
        int maxLocationsNumber = GameMap.MAX_ROWS * GameMap.MAX_COLS;
        int lackingLocationsNumber = maxLocationsNumber - (loadedLocationsNumber + EXTRA_STARTING_LOCATION);

        List<LocationType> locationTypes = Arrays.asList(LocationType.GRASSLAND, LocationType.WOODS, LocationType.WETLANDS);
        int max = locationTypes.size();

        Random random = new Random();
        int counter = 0;
        List<Location> lackingLocations = new LinkedList<>();
        while (counter < lackingLocationsNumber) {

            int index = random.nextInt(max);
            lackingLocations.add(Location.ofType(locationTypes.get(index)));
            ++counter;
        }

        return lackingLocations;
    }


    private List<Location> loadLocationsFromFile() {

        try {
            return csvReader.readFile(LOCATION_SOURCE_FILE);

        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException("Cannot read " + LOCATION_SOURCE_FILE);
        }
    }


}
