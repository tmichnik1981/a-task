package com.me.poc.domain.game.player;

import java.io.Serializable;
import java.util.UUID;

public abstract class Player implements Serializable {


    private final UUID id;
    private final String name;
    private int level;
    private int attack;
    private int defense;
    private int minimumDamage;
    private int maximumDamage;
    private int health;
    private int speed;
    private int experience;



    public Player(String characterName, PlayerType type) {
        this.id = UUID.randomUUID();
        this.name = characterName;
        this.level = type.getLevel();
        this.attack = type.getAttack();
        this.defense = type.getDefense();
        this.minimumDamage = type.getMinimumDamage();
        this.maximumDamage = type.getMaximumDamage();
        this.health = type.getHealth();
        this.speed = type.getSpeed();
        this.experience = type.getExperience();


    }

    Player(PlayerBuilder playerBuilder) {
        this.name = playerBuilder.name;
        this.health = playerBuilder.health;
        this.attack = playerBuilder.attack;
        this.defense = playerBuilder.defense;
        this.experience = playerBuilder.experience;
        this.level = playerBuilder.level;
        this.minimumDamage = playerBuilder.minimumDamage;
        this.maximumDamage = playerBuilder.maximumDamage;
        this.speed = playerBuilder.speed;
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getMinimumDamage() {
        return minimumDamage;
    }

    public int getMaximumDamage() {
        return maximumDamage;
    }

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }

    public int getExperience() {
        return experience;
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
        private int minimumDamage;
        private int maximumDamage;
        private int speed;

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

        public PlayerBuilder withMinimumDamage(int minimumDamage) {
            this.minimumDamage = minimumDamage;
            return this;
        }

        public PlayerBuilder withMaximumDamage(int maximumDamage) {
            this.maximumDamage = maximumDamage;
            return this;
        }

        public PlayerBuilder withSpeed(int speed) {
            this.speed = speed;
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
