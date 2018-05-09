package com.me.poc.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Game implements Serializable {
    private LocalDateTime startDateTime;
    private Scenario scenario;
    private DifficultyLevel level;
    private Player player;

    public Game() {
    }

    public Game(GameBuilder builder) {
        this.startDateTime = builder.startDateTime;
        this.scenario = builder.scenario;
        this.level = builder.level;
        this.player = builder.player;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Scenario getScenario() {
        return scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    public DifficultyLevel getLevel() {
        return level;
    }

    public void setLevel(DifficultyLevel level) {
        this.level = level;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    class GameBuilder {
        private LocalDateTime startDateTime;
        private Scenario scenario;
        private DifficultyLevel level;
        private Player player;

        public GameBuilder withStartDateTime(LocalDateTime startDateTime) {
            this.startDateTime = startDateTime;
            return this;
        }

        public GameBuilder withScenario(Scenario scenario) {
            this.scenario = scenario;
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

        public Game build(){
            return new Game(this);
        }

    }


}
