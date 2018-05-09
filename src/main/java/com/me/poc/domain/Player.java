package com.me.poc.domain;

import java.io.Serializable;
import java.util.Objects;

public class Player implements Serializable {

    private static final long serialVersionUID = 6080870866779816934L;

    private String name;
    private int health = 100;
    private int attack = 1;
    private int defense = 1;
    private int experience;
    private int level = 1;

    public Player() {
    }

    Player(PlayerBuilder playerBuilder) {
        this.name = playerBuilder.name;
        this.health = playerBuilder.health;
        this.attack = playerBuilder.attack;
        this.defense = playerBuilder.defense;
        this.experience = playerBuilder.experience;
        this.level = playerBuilder.level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public static PlayerBuilder builder() {
        return new PlayerBuilder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return health == player.health &&
            attack == player.attack &&
            defense == player.defense &&
            experience == player.experience &&
            level == player.level &&
            Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, experience, level);
    }

    public   static class PlayerBuilder {
        private String name;
        private int health;
        private int attack;
        private int defense;
        private int experience;
        private int level;


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
            return new Player(this);
        }

    }


}
