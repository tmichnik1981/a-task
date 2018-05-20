package com.me.poc.domain.game;

import com.me.poc.domain.game.gamemap.GameMap;
import com.me.poc.domain.game.gamemap.GameMapFactory;
import com.me.poc.domain.game.gamemap.location.Location;
import com.me.poc.domain.game.player.Player;
import com.me.poc.domain.game.player.PlayerFactory;
import com.me.poc.domain.game.player.PlayerType;
import com.me.poc.util.StringUtils;

import java.util.UUID;

public class GameFactory {

    private final PlayerFactory playerFactory;
    private final GameMapFactory gameMapFactory;

    public GameFactory(PlayerFactory playerFactory, GameMapFactory gameMapFactory) {
        this.playerFactory = playerFactory;
        this.gameMapFactory = gameMapFactory;

    }

    public Game create(DifficultyLevel level, String characterName, PlayerType type) {

        validateInput(level, characterName);

        Player player = playerFactory.create(characterName, type);

        GameMap gameMap = gameMapFactory.create();

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
