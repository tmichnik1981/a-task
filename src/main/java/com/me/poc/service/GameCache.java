package com.me.poc.service;

import com.me.poc.domain.Game;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GameCache {

    private final Map<String, Game> IdTogames = new HashMap<>();

    public Optional<Game> getGame(String id) {
        return Optional.ofNullable(IdTogames.get(id));
    }

    public void loadGame(Game game) {
        if (game == null || game.getId() == null) {
            throw new IllegalArgumentException("Game argument or its Id cannot be empty");
        }

        this.IdTogames.put(game.getId().toString(), game);
    }

    public static GameCache getInstance() {
        return GameCache.SingletonHelper.instance;
    }

    private static class SingletonHelper {
        private static final GameCache instance = new
                GameCache();
    }
}
