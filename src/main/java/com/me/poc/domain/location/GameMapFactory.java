package com.me.poc.domain.location;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class GameMapFactory {


    static final String LOCATION_SOURCE_FILE = "locations.csv";
    static final int rows = 5;
    static final int cols = 6;

    private static final int EXTRA_STARTING_LOCATION = 1;

    private final CsvReader csvReader;

    public GameMapFactory(CsvReader csvReader) {
        this.csvReader = csvReader;
    }


    public GameMap create() {

        Set<Location> loadedLocations = loadLocations();

        int maxLocationsNumber = rows * cols;

        int numberToGenerate = maxLocationsNumber - loadedLocations.size();


        Location[][] locationsMatrix = fillLocationsMatrix(loadedLocations);

        return new GameMap(locationsMatrix);
    }

    private Location[][] fillLocationsMatrix(Set<Location> loadedLocations) {

        int maxLocationsNumber = rows * cols;
        int lackingLocationsNumber = maxLocationsNumber - (loadedLocations.size() + EXTRA_STARTING_LOCATION);

        List<Location> locationList = new ArrayList<>(loadedLocations);

        if (lackingLocationsNumber > 0) {
            locationList.addAll(generateLackingLocations(lackingLocationsNumber, LocationType.GRASSLAND, LocationType.WOODS));
        }


        Location startingLocation = Location.builder()
                .withName("Start of a game")
                .withDescription("Start of a game")
                .withType(LocationType.START)
                .withLocationStatus(LocationStatus.EXPLORED)
                .build();


        Location[][] locationsMatrix = new Location[rows][cols];

        locationsMatrix[0][0] = startingLocation;
        Random random = new Random();

        for (int row = 0; row < rows; ++row) {

            for (int col = 1; col < cols; ++col) {

                //TODO: dodac petle i sprawdzenie czy wylosowana liczba sie nie powtarza
                int drawLocationIndex = random.nextInt(locationList.size());

                locationsMatrix[row][col] = locationList.get(drawLocationIndex);
            }

        }

        return locationsMatrix;

    }

    private Collection<? extends Location> generateLackingLocations(int lackingLocationsNumber, LocationType... woods) {
        //TODO:to implement
        return null;
    }

    private Set<Location> loadLocations() {

        try {
            return csvReader.readFile(LOCATION_SOURCE_FILE);

        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException("Cannot read " + LOCATION_SOURCE_FILE);
        }
    }


}
