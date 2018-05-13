package com.me.poc.domain.game;

import com.me.poc.domain.location.GameMap;
import com.me.poc.domain.location.MapFactory;
import com.me.poc.util.StringUtils;


import java.util.UUID;

public class GameFactory {

    private final PlayerFactory playerFactory;
    private final MapFactory mapFactory;

    public GameFactory(PlayerFactory playerFactory, MapFactory mapFactory) {
        this.playerFactory = playerFactory;
        this.mapFactory = mapFactory;

    }

    public Game create(DifficultyLevel level, String characterName , PlayerType type) {

        validateInput(level, characterName);

        Player player = playerFactory.create(level, characterName, type);

        GameMap gameMap = mapFactory.create(level);

        return Game.builder()
                .withDifficultyLevel(level)
                .withId(UUID.randomUUID())
                .withPlayer(player)
                .withGameMap(gameMap)
                .build();

    }

    private void validateInput(DifficultyLevel level, String characterName) {
        if (level == null) {
            throw new IllegalArgumentException("Required game level was not provided");
        }
        if (StringUtils.isBlank(characterName)) {
            throw new IllegalArgumentException("Required character's name was not provided");
        }
    }

}
