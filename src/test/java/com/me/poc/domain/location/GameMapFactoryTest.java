package com.me.poc.domain.location;

import com.me.poc.domain.game.DifficultyLevel;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;


public class GameMapFactoryTest {


    private CsvReader csvReader = mock(CsvReader.class);

    private GameMapFactory gameMapFactory = new GameMapFactory(csvReader);

    @Test
    public void shouldCreateMap() throws FileNotFoundException, URISyntaxException {

        //given
        List<Location> locations = new ArrayList<>(2);
        Location.LocationBuilder builder = Location.builder();
        builder.withName("aaa")
                .withDescription("aaa-desc")
                .withType(LocationType.GRASSLAND)
                .withLocationStatus(LocationStatus.UNKNOWN);
        locations.add(builder.build());

        builder.clear();
        builder.withName("bbb")
                .withDescription("bbb-desc")
                .withType(LocationType.TOWN);
        locations.add(builder.build());

        given(csvReader.readFile(GameMapFactory.LOCATION_SOURCE_FILE)).willReturn(locations);

        //when
        GameMap gameMap = gameMapFactory.create();

        //then
        assertThat(gameMap).isNotNull();
    }
}