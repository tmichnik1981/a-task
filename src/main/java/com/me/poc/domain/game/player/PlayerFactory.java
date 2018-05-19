package com.me.poc.domain.game.player;

import com.me.poc.domain.game.DifficultyLevel;
import com.me.poc.util.StringUtils;

public class PlayerFactory {

    static final int LEVEL_3 = 3, LEVEL_2 = 2, LEVEL_1 = 1;
    static final int HEALTH_300 = 300, HEALTH_200 = 200, HEALTH_100 = 100;
    static final int EXPERIENCE_300 = 300, EXPERIENCE_200 = 200, EXPERIENCE_100 = 100;
    static final int ATTACK_SKILL_5 = 5, ATTACK_SKILL_4 = 4, ATTACK_SKILL_3 = 3, ATTACK_SKILL_2 = 2, ATTACK_SKILL_1 = 1;
    static final int DEFENSE_SKILL_5 = 5, DEFENSE_SKILL_4 = 4, DEFENSE_SKILL_3 = 3, DEFENSE_SKILL_2 = 2, DEFENSE_SKILL_1 = 1;

    public Player create(DifficultyLevel level, String characterName, PlayerType type) {

        validateInput(level, characterName, type);

        Player.PlayerBuilder playerBuilder = Player.builder()
                .withName(characterName)
                .withPlayerType(type);


        switch (level) {
            case NOVICE:
                playerBuilder.withLevel(LEVEL_3)
                        .withHealth(HEALTH_300)
                        .withAttack(resolveAttackSkills(level, type))
                        .withDefense(resolveDefenseSkills(level, type))
                        .withExperience(EXPERIENCE_300);
                break;
            case MEDIUM:
                playerBuilder.withLevel(LEVEL_2)
                        .withHealth(HEALTH_200)
                        .withAttack(resolveAttackSkills(level, type))
                        .withDefense(resolveDefenseSkills(level, type))
                        .withExperience(EXPERIENCE_200);
                break;
            case ADVANCED:

                playerBuilder.withLevel(LEVEL_1)
                        .withHealth(HEALTH_100)
                        .withAttack(resolveAttackSkills(level, type))
                        .withDefense(resolveDefenseSkills(level, type))
                        .withExperience(EXPERIENCE_100);
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
                return PlayerType.FIGHTER.equals(type) ? ATTACK_SKILL_5 : ATTACK_SKILL_3;
            case MEDIUM:
                return PlayerType.FIGHTER.equals(type) ? ATTACK_SKILL_4 : ATTACK_SKILL_2;
            case ADVANCED:
                return PlayerType.FIGHTER.equals(type) ? ATTACK_SKILL_3 : ATTACK_SKILL_1;


        }

        throw new IllegalArgumentException("Unknown DifficultyLevel");

    }

    private int resolveDefenseSkills(DifficultyLevel level, PlayerType type) {

        switch (level) {
            case NOVICE:
                return PlayerType.MAGE.equals(type) ? DEFENSE_SKILL_5 : DEFENSE_SKILL_3;
            case MEDIUM:
                return PlayerType.MAGE.equals(type) ? DEFENSE_SKILL_4 : DEFENSE_SKILL_2;
            case ADVANCED:
                return PlayerType.MAGE.equals(type) ? DEFENSE_SKILL_3 : DEFENSE_SKILL_1;


        }

        throw new IllegalArgumentException("Unknown DifficultyLevel");

    }

}
