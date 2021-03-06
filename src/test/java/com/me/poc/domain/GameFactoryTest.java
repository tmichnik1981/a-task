package com.me.poc.domain;

import com.me.poc.domain.player.PlayerFactory;
import com.me.poc.domain.player.PlayerType;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GameFactoryTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private PlayerFactory playerFactory = mock(PlayerFactory.class);
    private GameMapFactory gameMapFactory = mock(GameMapFactory.class);
    private GameFactory gameFactory = new GameFactory(playerFactory, gameMapFactory);

    @Test
    public void shouldCreateNoviceLevelGame() {
        //given
        DifficultyLevel level = DifficultyLevel.NOVICE;
        String characterName = "Sir Lancelot";
        //when
        Game resultGame = gameFactory.create(level, characterName, PlayerType.FIGHTER);

        //then

        assertThat(resultGame).isNotNull();
        assertThat(resultGame.getId()).isNotNull();
        assertThat(resultGame.getLevel()).isEqualTo(level);

        verify(playerFactory).create(characterName, PlayerType.FIGHTER);
        verify(gameMapFactory).create();
    }

    @Test
    public void shouldCreateMediumLevelGame() {
        //given
        DifficultyLevel level = DifficultyLevel.MEDIUM;
        String characterName = "Sir Lancelot";
        int expectedStartDay = 1;
        //when
        Game resultGame = gameFactory.create(level, characterName, PlayerType.FIGHTER);

        //then

        assertThat(resultGame).isNotNull();
        assertThat(resultGame.getId()).isNotNull();
        assertThat(resultGame.getLevel()).isEqualTo(DifficultyLevel.MEDIUM);

        verify(playerFactory).create(characterName, PlayerType.FIGHTER);
        verify(gameMapFactory).create();

    }

    @Test
    public void shouldThrowExceptionLevelNotProvided() {
        //given
        exception.expect(IllegalArgumentException.class);
        DifficultyLevel level = null;
        String characterName = "Sir Lancelot";

        //when
        gameFactory.create(level, characterName, PlayerType.FIGHTER);

        //then

    }

    @Test
    public void shouldThrowExceptionCharacterNameNotProvided() {
        //given
        exception.expect(IllegalArgumentException.class);

        DifficultyLevel level = DifficultyLevel.MEDIUM;
        String characterName = "";

        //when
        gameFactory.create(level, characterName, PlayerType.FIGHTER);

        //then


    }
}