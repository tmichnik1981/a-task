package com.me.poc.domain.player;

import com.me.poc.util.StringUtils;

public class PlayerFactory {

    public Player create(String characterName, PlayerType type) {

        validateInput(characterName, type);


        switch (type) {
            case FIGHTER:
                return new Fighter(characterName);
            case MAGE:
                return new Mage(characterName);
        }

        throw new IllegalArgumentException("Unknown PlayerType");
    }


    private void validateInput(String characterName, PlayerType type) {

        if (StringUtils.isBlank(characterName)) {
            throw new IllegalArgumentException("Required character's name was not provided");
        }
        if (type == null) {
            throw new IllegalArgumentException("Required player's type level was not provided");
        }
    }

}
