package com.me.poc.domain.game;

import com.me.poc.domain.game.gamemap.CsvReader;
import com.me.poc.domain.game.gamemap.GameMapFactory;
import com.me.poc.domain.game.player.PlayerFactory;
import com.me.poc.domain.game.player.PlayerType;
import org.junit.Before;
import org.junit.Test;

public class GameTest {




    private Game game;

    @Before
    public void setUp(){
        CsvReader csvReader =  new CsvReader();

        PlayerFactory playerFactory = new PlayerFactory();
        GameMapFactory gameMapFactory = new GameMapFactory(csvReader);
        game = new GameFactory(playerFactory, gameMapFactory).create(DifficultyLevel.MEDIUM, "He-Man", PlayerType.FIGHTER);
    }

    @Test
    public void shouldStart(){
        //given
        //when
        game.start();
        //then
    }

}