package com.me.poc.domain.player;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.me.poc.domain.player.PlayerType.FIGHTER;
import static com.me.poc.domain.player.PlayerType.MAGE;
import static org.assertj.core.api.Assertions.assertThat;

public class PlayerFactoryTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();
    private PlayerFactory playerFactory = new PlayerFactory();


    @Test
    public void shouldCreateNewFighter() {
        //given
        String characterName = "He-Man";
        PlayerType playerType = FIGHTER;

        //when
        Player createdPlayer = playerFactory.create(characterName, playerType);

        //then
        assertThat(createdPlayer).isNotNull().isInstanceOf(Fighter.class);
        Fighter fighter = (Fighter) createdPlayer;
        assertThat(fighter.getAttack()).isEqualTo(FIGHTER.getAttack());
        assertThat(fighter.getDefense()).isEqualTo(FIGHTER.getDefense());
        assertThat(fighter.getExperience()).isEqualTo(FIGHTER.getExperience());
        assertThat(fighter.getHealth()).isEqualTo(FIGHTER.getHealth());
        assertThat(fighter.getLevel()).isEqualTo(FIGHTER.getLevel());
        assertThat(fighter.getName()).isEqualTo(characterName);
    }


    @Test
    public void shouldCreateNewMag() {
        //given
        String characterName = "Merlin";
        PlayerType playerType = MAGE;

        //when
        Player createdPlayer = playerFactory.create(characterName, playerType);

        //then
        assertThat(createdPlayer).isNotNull().isInstanceOf(Mage.class);
        Mage mage = (Mage) createdPlayer;
        assertThat(mage.getAttack()).isEqualTo(MAGE.getAttack());
        assertThat(mage.getDefense()).isEqualTo(MAGE.getDefense());
        assertThat(mage.getExperience()).isEqualTo(MAGE.getExperience());
        assertThat(mage.getHealth()).isEqualTo(MAGE.getHealth());
        assertThat(mage.getLevel()).isEqualTo(MAGE.getLevel());
        assertThat(mage.getName()).isEqualTo(characterName);
    }

    @Test
    public void shouldThrowExceptionCharacterNameNotProvided() {
        //given
        exception.expect(IllegalArgumentException.class);

        String characterName = "";

        //when
        playerFactory.create(characterName, FIGHTER);

        //then


    }

    @Test
    public void shouldThrowExceptionCharacterTypeNotProvided() {
        //given
        exception.expect(IllegalArgumentException.class);

        String characterName = "Warrior 123";
        PlayerType playerType = null;

        //when
        playerFactory.create(characterName, playerType);

        //then
    }


}