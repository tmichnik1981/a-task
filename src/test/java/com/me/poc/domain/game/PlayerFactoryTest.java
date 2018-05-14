package com.me.poc.domain.game;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerFactoryTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();
    private PlayerFactory playerFactory = new PlayerFactory();

    @Test
    public void shouldCreateNewFighterForNoviceLevel() {
        //given
        DifficultyLevel level = DifficultyLevel.NOVICE;
        String characterName = "He-Man";
        PlayerType playerType = PlayerType.FIGHTER;

        //when
        Player createdPlayer = playerFactory.create(level, characterName, playerType);

        //then
        assertThat(createdPlayer).isNotNull().isInstanceOf(Fighter.class);
        Fighter fighter = (Fighter) createdPlayer;
        assertThat(fighter.getAttack()).isEqualTo(PlayerFactory.ATTACK_SKILL_5);
        assertThat(fighter.getDefense()).isEqualTo(PlayerFactory.DEFENSE_SKILL_3);
        assertThat(fighter.getExperience()).isEqualTo(PlayerFactory.EXPERIENCE_300);
        assertThat(fighter.getHealth()).isEqualTo(PlayerFactory.HEALTH_300);
        assertThat(fighter.getLevel()).isEqualTo(PlayerFactory.LEVEL_3);
        assertThat(fighter.getName()).isEqualTo(characterName);
    }

    @Test
    public void shouldCreateNewFighterForAdvancedLevel() {
        //given
        DifficultyLevel level = DifficultyLevel.ADVANCED;
        String characterName = "He-Man";
        PlayerType playerType = PlayerType.FIGHTER;

        //when
        Player createdPlayer = playerFactory.create(level, characterName, playerType);

        //then
        assertThat(createdPlayer).isNotNull().isInstanceOf(Fighter.class);
        Fighter fighter = (Fighter) createdPlayer;
        assertThat(fighter.getAttack()).isEqualTo(PlayerFactory.ATTACK_SKILL_3);
        assertThat(fighter.getDefense()).isEqualTo(PlayerFactory.DEFENSE_SKILL_1);
        assertThat(fighter.getExperience()).isEqualTo(PlayerFactory.EXPERIENCE_100);
        assertThat(fighter.getHealth()).isEqualTo(PlayerFactory.HEALTH_100);
        assertThat(fighter.getLevel()).isEqualTo(PlayerFactory.LEVEL_1);
        assertThat(fighter.getName()).isEqualTo(characterName);
    }

    @Test
    public void shouldCreateNewMagForNoviceLevel() {
        //given
        DifficultyLevel level = DifficultyLevel.NOVICE;
        String characterName = "Merlin";
        PlayerType playerType = PlayerType.MAGE;

        //when
        Player createdPlayer = playerFactory.create(level, characterName, playerType);

        //then
        assertThat(createdPlayer).isNotNull().isInstanceOf(Mage.class);
        Mage mage = (Mage) createdPlayer;
        assertThat(mage.getAttack()).isEqualTo(PlayerFactory.ATTACK_SKILL_3);
        assertThat(mage.getDefense()).isEqualTo(PlayerFactory.DEFENSE_SKILL_5);
        assertThat(mage.getExperience()).isEqualTo(PlayerFactory.EXPERIENCE_300);
        assertThat(mage.getHealth()).isEqualTo(PlayerFactory.HEALTH_300);
        assertThat(mage.getLevel()).isEqualTo(PlayerFactory.LEVEL_3);
        assertThat(mage.getName()).isEqualTo(characterName);
    }

    @Test
    public void shouldCreateNewMagForAdvancedLevel() {
        //given
        DifficultyLevel level = DifficultyLevel.ADVANCED;
        String characterName = "Merlin";
        PlayerType playerType = PlayerType.MAGE;

        //when
        Player createdPlayer = playerFactory.create(level, characterName, playerType);

        //then
        assertThat(createdPlayer).isNotNull().isInstanceOf(Mage.class);
        Mage mage = (Mage) createdPlayer;
        assertThat(mage.getAttack()).isEqualTo(PlayerFactory.ATTACK_SKILL_1);
        assertThat(mage.getDefense()).isEqualTo(PlayerFactory.DEFENSE_SKILL_3);
        assertThat(mage.getExperience()).isEqualTo(PlayerFactory.EXPERIENCE_100);
        assertThat(mage.getHealth()).isEqualTo(PlayerFactory.HEALTH_100);
        assertThat(mage.getLevel()).isEqualTo(PlayerFactory.LEVEL_1);
        assertThat(mage.getName()).isEqualTo(characterName);
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