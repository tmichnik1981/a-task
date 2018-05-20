package com.me.poc.domain.game.player;

public enum PlayerType {

    FIGHTER(4, 10, 12, 6, 9, 35, 5, 100), MAGE(4, 12, 9, 7, 9, 30, 7, 100);

    private int level;
    private int attack;
    private int defense;
    private int minimumDamage;
    private int maximumDamage;
    private int health;
    private int speed;
    private int experience;


    PlayerType(int level, int attack, int defense, int minimumDamage, int maximumDamage, int health, int speed, int experience) {
        this.level = level;
        this.attack = attack;
        this.defense = defense;
        this.minimumDamage = minimumDamage;
        this.maximumDamage = maximumDamage;
        this.health = health;
        this.speed = speed;
        this.experience = experience;
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
}
