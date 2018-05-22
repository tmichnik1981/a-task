package com.me.poc.domain;

import com.me.poc.domain.player.PlayerFactory;
import com.me.poc.domain.player.PlayerType;
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