package com.me.poc.domain.game.gamemap;

import com.me.poc.domain.game.gamemap.location.Location;
import com.me.poc.domain.game.gamemap.location.LocationType;
import com.me.poc.domain.game.gamemap.location.Start;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class GameMapFactory {

    static final String LOCATION_SOURCE_FILE = "locations.csv";
    static final int rows = 5;
    static final int cols = 6;
    static final int STARTING_LOCATION_ROW = 0;
    static final int STARTING_LOCATION_COL = 2;

    private static final int EXTRA_STARTING_LOCATION = 1;

    private final CsvReader csvReader;

    public GameMapFactory(CsvReader csvReader) {
        this.csvReader = csvReader;
    }


    public Location[][]  create() {

        List<Location> loadedLocations = loadLocations();

        Location[][] locationsMatrix = fillLocationsMatrix(loadedLocations);

        return locationsMatrix;
    }

    private Location[][] fillLocationsMatrix(List<Location> loadedLocations) {

        int maxLocationsNumber = rows * cols;
        int lackingLocationsNumber = maxLocationsNumber - (loadedLocations.size() + EXTRA_STARTING_LOCATION);

        List<Location> locationList = new ArrayList<>(loadedLocations);

        if (lackingLocationsNumber > 0) {
            locationList.addAll(generateLackingLocations(lackingLocationsNumber));
        }

        Location[][] locationsMatrix = new Location[rows][cols];

        locationsMatrix[STARTING_LOCATION_ROW][STARTING_LOCATION_COL] = new Start();

        Random random = new Random();
        Set<Integer> uniqueDrawNumbers = new HashSet<>();

        for (int row = 0; row < rows; ++row) {

            for (int col = 0; col < cols; ++col) {

                if (locationsMatrix[row][col] == null)
                    while (true) {
                        int drawLocationIndex = random.nextInt(locationList.size());
                        if (!uniqueDrawNumbers.contains(drawLocationIndex)) {
                            uniqueDrawNumbers.add(drawLocationIndex);
                            locationsMatrix[row][col] = locationList.get(drawLocationIndex);
                            break;

                        }
                    }


            }

        }

        return locationsMatrix;

    }

    private List<Location> generateLackingLocations(int lackingLocationsNumber) {

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


    private List<Location> loadLocations() {

        try {
            return csvReader.readFile(LOCATION_SOURCE_FILE);

        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException("Cannot read " + LOCATION_SOURCE_FILE);
        }
    }


}
