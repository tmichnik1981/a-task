package com.me.poc.domain.game.player;

import java.io.Serializable;

public abstract class Player implements Serializable {

    protected String name;
    protected int health;
    protected int attack;
    protected int defense;
    protected int experience;
    protected int level;

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }


    public int getExperience() {
        return experience;
    }

    public int getLevel() {
        return level;
    }

    Player(PlayerBuilder playerBuilder) {
        this.name = playerBuilder.name;
        this.health = playerBuilder.health;
        this.attack = playerBuilder.attack;
        this.defense = playerBuilder.defense;
        this.experience = playerBuilder.experience;
        this.level = playerBuilder.level;
    }

    public static PlayerBuilder builder() {
        return new PlayerBuilder();
    }


    public static class PlayerBuilder {
        private String name;
        private int health;
        private int attack;
        private int defense;
        private int experience;
        private int level;
        private PlayerType playerType;


        public PlayerBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public PlayerBuilder withHealth(int health) {
            this.health = health;
            return this;
        }

        public PlayerBuilder withAttack(int attack) {
            this.attack = attack;
            return this;
        }

        public PlayerBuilder withDefense(int defense) {
            this.defense = defense;
            return this;
        }

        public PlayerBuilder withExperience(int experience) {
            this.experience = experience;
            return this;
        }

        public PlayerBuilder withLevel(int level) {
            this.level = level;
            return this;
        }


        public Player build() {

            return PlayerType.FIGHTER.equals(playerType) ? new Fighter(this) : new Mage(this);
        }

        public PlayerBuilder withPlayerType(PlayerType playerType) {
            this.playerType = playerType;
            return this;
        }
    }


}
