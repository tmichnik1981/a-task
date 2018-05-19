package com.me.poc.domain.game.gamemap;


import com.me.poc.domain.game.gamemap.location.Location;
import com.me.poc.domain.game.gamemap.location.LocationStatus;
import com.me.poc.domain.game.gamemap.location.LocationType;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.LinkedList;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;


public class GameMapFactoryTest {


    private CsvReader csvReader = mock(CsvReader.class);

    private GameMapFactory gameMapFactory = new GameMapFactory(csvReader);

    @Test
    public void shouldCreateMap() throws FileNotFoundException, URISyntaxException {

        //given
        List<Location> locations = new LinkedList<>();
        Location.LocationBuilder builder = Location.builder();
        builder.withName("aaa")
                .withDescription("aaa-desc")
                .withType(LocationType.SETTLEMENT)
                .withLocationStatus(LocationStatus.UNKNOWN);
        locations.add(builder.build());

        builder.clear();
        builder.withName("bbb")
                .withDescription("bbb-desc")
                .withType(LocationType.TOWN);
        locations.add(builder.build());

        builder.clear();
        builder.withName("ccc")
                .withDescription("ccc-desc")
                .withType(LocationType.TOWN);
        locations.add(builder.build());

        given(csvReader.readFile(GameMapFactory.LOCATION_SOURCE_FILE)).willReturn(locations);

        //when
        Location[][] gameMap = gameMapFactory.create();

        //then

        assertThat(gameMap)
                .isNotNull().isNotEmpty().doesNotContainNull().hasSize(GameMapFactory.rows);

        assertThat(gameMap[0]).isNotNull().isNotEmpty().doesNotContainNull().hasSize(GameMapFactory.cols);
        assertThat(gameMap[1]).isNotNull().isNotEmpty().doesNotContainNull();
        assertThat(gameMap[2]).isNotNull().isNotEmpty().doesNotContainNull();
        assertThat(gameMap[3]).isNotNull().isNotEmpty().doesNotContainNull();
        assertThat(gameMap[4]).isNotNull().isNotEmpty().doesNotContainNull();

        List<Location> flatLocationMap = Arrays.stream(gameMap).flatMap(Arrays::stream).collect(Collectors.toList());

        assertThat(flatLocationMap).contains(locations.get(0),locations.get(1),locations.get(2));
    }
}