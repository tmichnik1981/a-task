package com.me.poc.domain.game.gamemap.location;

import com.me.poc.domain.game.gamemap.CsvReader;
import org.assertj.core.api.Condition;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class CsvReaderTest {

    private static final String LOCATIONS_FILE_NAME = "test-locations.csv";

    private CsvReader csvReader = new CsvReader();

    @Test
    public void shouldParseLocationsFile() throws Exception {
        //given

        //when
        List<Location> parsedLocation = csvReader.readFile(LOCATIONS_FILE_NAME);

        //then
        assertThat(parsedLocation).isNotNull().hasSize(3);


        assertThat(parsedLocation).haveExactly(1, new Condition<>(location -> location instanceof Town && "Testing-town".equalsIgnoreCase(location.getName())
                && "Town description".equalsIgnoreCase(location.getDescription()), "Read only one Tows"));

        assertThat(parsedLocation).haveExactly(1, new Condition<>(location -> location instanceof Wetlands && "Testing-wetlands".equalsIgnoreCase(location.getName())
                && "Wetlands description".equalsIgnoreCase(location.getDescription()), "Read only one Wetlands "));

        assertThat(parsedLocation).haveExactly(1, new Condition<>(location -> location instanceof Grassland && "Testing-grass".equalsIgnoreCase(location.getName())
                && "Grassland description".equalsIgnoreCase(location.getDescription()), "Read only one Grassland"));



    }

}