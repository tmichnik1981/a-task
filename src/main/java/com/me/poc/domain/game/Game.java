package com.me.poc.domain.game;

import com.me.poc.domain.location.GameMap;
import com.me.poc.domain.location.Location;

import java.io.Serializable;
import java.util.UUID;

public class Game implements Serializable {

    static final int FIRST_DAY = 1;

    private UUID id;
    private DifficultyLevel level;
    private Player player;
    private GameMap map;
    private int dayOfGame;

    public UUID getId() {
        return id;
    }

    public DifficultyLevel getLevel() {
        return level;
    }

    public Player getPlayer() {
        return player;
    }

    public GameMap getMap() {
        return map;
    }

    public int getDayOfGame() {
        return dayOfGame;
    }

    public Game(GameBuilder builder) {
        this.id = builder.id;
        this.level = builder.level;
        this.player = builder.player;
        this.map = builder.map;
        this.dayOfGame = builder.dayOfGame;
    }

    public static GameBuilder builder() {
        return new GameBuilder();
    }

    static class GameBuilder {
        private UUID id;
        private DifficultyLevel level;
        private Player player;
        private GameMap map;
        private int dayOfGame = FIRST_DAY;

        public GameBuilder withId(UUID id) {
            this.id = id;
            return this;
        }

        public GameBuilder withDifficultyLevel(DifficultyLevel level) {
            this.level = level;
            return this;
        }

        public GameBuilder withPlayer(Player player) {
            this.player = player;
            return this;
        }

        public GameBuilder withDayOfGame(int dayOfGame) {
            this.dayOfGame = dayOfGame;
            return this;
        }

        public GameBuilder withGameMap(GameMap map) {
            this.map = map;
            return this;
        }

        public Game build() {
            return new Game(this);
        }

    }


}
