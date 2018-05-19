package com.me.poc.domain.location;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class CsvReader {


    private static final String DEFAULT_DELIMITER = ",";

    public List<Location> readFile(String fileName) throws URISyntaxException, FileNotFoundException {

        Location.LocationBuilder builder = Location.builder();

        List<Location> locations = new LinkedList<>();
        try (Scanner lineScanner = new Scanner(new File(GameMapFactory.class.getClassLoader().getResource(fileName).toURI()))) {

            while (lineScanner.hasNextLine()) {
                try (Scanner dataScanner = new Scanner(lineScanner.nextLine())) {
                    dataScanner.useDelimiter(DEFAULT_DELIMITER);

                    //col 0
                    builder.withType(LocationType.parse(dataScanner.next()));
                    //col 1
                    builder.withName(dataScanner.next());
                    //col 2
                    builder.withDescription(dataScanner.next());

                    locations.add(builder.build());
                }


            }
        }
        return  locations;
    }
}