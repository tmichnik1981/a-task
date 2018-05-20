package com.me.poc.domain.game.gamemap.location;

import com.me.poc.domain.game.gamemap.GameMap;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class GameMapTest {

    private GameMap gameMap = new GameMap();

    @Test
    public void shouldPlaceLocationOntoPosition() {
        //given
        Town town = new Town();
        int y = 0;
        int x = 0;

        //when
        boolean successfulPlacement = gameMap.put(town, x, y);

        //then
        assertThat(successfulPlacement).isTrue();
    }

    @Test
    public void shouldNotPlaceLocationOntoPositionWhenItIsNotFree() {
        //given
        Town town = new Town();
        Forest forest = new Forest();
        int y = 0;
        int x = 0;

        //when
        boolean firstPlacement = gameMap.put(town, x, y);
        boolean secondPlacement = gameMap.put(forest, x, y);

        //then
        assertThat(firstPlacement).isTrue();
        assertThat(secondPlacement).isFalse();
    }

    @Test
    public void shouldReplaceLocationInPosition() {
        //given
        Start start = new Start();
        Town town = new Town();
        int y = 0;
        int x = 0;
        //when
        boolean firstPlacement = gameMap.put(start, x, y);
        Optional<Location> oldLocation = gameMap.putAndReplace(town, x, y);


        //then
        assertThat(firstPlacement).isTrue();
        assertThat(oldLocation.isPresent()).isTrue();

        assertThat(oldLocation.get()).isEqualTo(start);
    }


}