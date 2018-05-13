package com.me.poc.domain.game;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PlayerFactoryTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();
    private PlayerFactory playerFactory = new PlayerFactory();

    @Test
    public void shouldCreateNewFighterForNoviceLevel() {
        //given
        //when
        //then
    }

    @Test
    public void shouldCreateNewFighterForAdvancedLevel() {
        //given
        //when
        //then
    }

    @Test
    public void shouldCreateNewMagForNoviceLevel() {
        //given
        //when
        //then
    }

    @Test
    public void shouldCreateNewMagForAdvancedLevel() {
        //given
        //when
        //then
    }

    @Test
    public void shouldThrowExceptionCharacterNameNotProvided() {
        //given
        exception.expect(IllegalArgumentException.class);

        DifficultyLevel level = DifficultyLevel.MEDIUM;
        String characterName = "";

        //when
        playerFactory.create(level, characterName, PlayerType.FIGHTER);

        //then


    }

    @Test
    public void shouldThrowExceptionCharacterTypeNotProvided() {
        //given
        exception.expect(IllegalArgumentException.class);

        DifficultyLevel level = DifficultyLevel.MEDIUM;
        String characterName = "Warrior 123";
        PlayerType playerType = null;

        //when
        playerFactory.create(level, characterName, playerType);

        //then
    }

    @Test
    public void shouldThrowExceptionLevelNotProvided() {
        //given
        exception.expect(IllegalArgumentException.class);
        DifficultyLevel level = null;
        String characterName = "Sir Lancelot";

        //when
        playerFactory.create(level, characterName, PlayerType.FIGHTER);

        //then

    }

}