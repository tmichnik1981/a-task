package com.me.poc.domain.game;

import com.me.poc.util.StringUtils;

public class PlayerFactory {

    public Player create(DifficultyLevel level, String characterName, PlayerType type) {

        validateInput(level, characterName, type);

        Player.PlayerBuilder playerBuilder = Player.builder()
                .withName(characterName)
                .withPlayerType(type);


        switch (level) {
            case NOVICE:
                playerBuilder.withLevel(3)
                        .withHealth(300)
                        .withAttack(resolveAttackSkills(level, type))
                        .withDefense(resolveDefenseSkills(level, type))
                        .withExperience(300);
                break;
            case MEDIUM:
                playerBuilder.withLevel(2)
                        .withHealth(200)
                        .withAttack(resolveAttackSkills(level, type))
                        .withDefense(resolveDefenseSkills(level, type))
                        .withExperience(200);
                break;
            case ADVANCED:

                playerBuilder.withLevel(1)
                        .withHealth(100)
                        .withAttack(resolveAttackSkills(level, type))
                        .withDefense(resolveDefenseSkills(level, type))
                        .withExperience(100);
                break;
        }


        return playerBuilder.build();
    }

    private void validateInput(DifficultyLevel level, String characterName, PlayerType type) {
        if (level == null) {
            throw new IllegalArgumentException("Required game level was not provided");
        }
        if (StringUtils.isBlank(characterName)) {
            throw new IllegalArgumentException("Required character's name was not provided");
        }
        if (type == null) {
            throw new IllegalArgumentException("Required player's type level was not provided");
        }
    }

    private int resolveAttackSkills(DifficultyLevel level, PlayerType type) {

        switch (level) {
            case NOVICE:
                return PlayerType.FIGHTER.equals(type) ? 5 : 3;
            case MEDIUM:
                return PlayerType.FIGHTER.equals(type) ? 4 : 2;
            case ADVANCED:
                return PlayerType.FIGHTER.equals(type) ? 3 : 1;


        }

        throw new IllegalArgumentException("Unknown DifficultyLevel");

    }

    private int resolveDefenseSkills(DifficultyLevel level, PlayerType type) {

        switch (level) {
            case NOVICE:
                return PlayerType.MAGE.equals(type) ? 5 : 3;
            case MEDIUM:
                return PlayerType.MAGE.equals(type) ? 4 : 2;
            case ADVANCED:
                return PlayerType.MAGE.equals(type) ? 3 : 1;


        }

        throw new IllegalArgumentException("Unknown DifficultyLevel");

    }

}
