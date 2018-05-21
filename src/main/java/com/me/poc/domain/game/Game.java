package com.me.poc.domain.game;

import com.me.poc.domain.game.location.LocationStatus;
import com.me.poc.domain.game.player.Player;

import java.io.Serializable;
import java.util.UUID;

public class Game implements Serializable {

    static final int FIRST_DAY = 1;

    private final UUID id;
    private final DifficultyLevel level;
    private final Player player;
    private int dayOfGame;
    private final GameMap gameMap;



    public UUID getId() {
        return id;
    }

    public DifficultyLevel getLevel() {
        return level;
    }

    public Player getPlayer() {
        return player;
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public int getDayOfGame() {
        return dayOfGame;
    }

    public Game(GameBuilder builder) {
        this.id = builder.id;
        this.level = builder.level;
        this.player = builder.player;
        this.dayOfGame = builder.dayOfGame;
        this.gameMap = builder.gameMap;
    }

    public static GameBuilder builder() {
        return new GameBuilder();
    }

    public void start() {
        gameMap.movePlayerOnStart(player);
    }

    public void movePlayerTo(int x, int y){
        LocationStatus statusAfterMove =  gameMap.movePlayerTo(x, y);
    }

    public void rest(){
        ++dayOfGame;
        //TODO:implement
    }


    static class GameBuilder {

        private UUID id;
        private DifficultyLevel level;
        private Player player;
        private GameMap gameMap;
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

        public GameBuilder withGameMap(GameMap gameMap) {
            this.gameMap = gameMap;
            return this;
        }

        public Game build() {
            return new Game(this);
        }

    }

}
