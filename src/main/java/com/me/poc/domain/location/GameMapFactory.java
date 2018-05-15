package com.me.poc.domain.location;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GameMapFactory {


    static final String LOCATION_SOURCE_FILE = "locations.csv";
    static final int rows = 5;
    static final int colls = 6;
    private static final int EXTRA_STARTING_LOCATION =1;

    private final CsvReader csvReader;

    public GameMapFactory(CsvReader csvReader) {
        this.csvReader = csvReader;
    }


    public GameMap create() {

        Set<Location> loadedLocations = loadLocations();

        int maxLocationsNumber = rows * colls;

        int numberToGenerate = maxLocationsNumber - loadedLocations.size();

        numberToGenerate = numberToGenerate - EXTRA_STARTING_LOCATION;

        Location startingLocation = Location.builder()
                .withName("Start of a game")
                .withDescription("Start of a game")
                .withType(LocationType.START)
                .withLocationStatus(LocationStatus.EXPLORED)
                .build();

        List<Location> allLocations = new ArrayList<>(maxLocationsNumber-EXTRA_STARTING_LOCATION);

        if (numberToGenerate > 0) {
            allLocations.addAll(generateLackingLocations(numberToGenerate));
        }else if(numberToGenerate<0){

        }
        return new GameMap(locationsMap);
    }

    private Set<Location> generateLackingLocations(int numberToGenerate) {


    }

    private Set<Location> loadLocations() {

        try {
            return csvReader.readFile(LOCATION_SOURCE_FILE);

        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException("Cannot read " + LOCATION_SOURCE_FILE);
        }
    }


}
