package com.me.poc.domain.game.enemy;

public enum EnemyType {
    ARCHER("Archer", 2, 6, 3, 2, 3, 10, 4), CAVALIER("Cavalier", 6, 15, 15, 15, 25, 100, 7),
    CHAMPION("Champion", 6, 16, 16, 20, 25, 100, 9), CRUSADER("Crusader", 4, 12, 12, 7, 10, 35, 6),
    GRIFFIN("Griffin", 3, 8, 8, 3, 6, 25, 6), HALBERDIER("Halberdier", 1, 6, 5, 2, 3, 10, 5),
    MARKSMAN("Marksman", 2, 6, 3, 2, 3, 10, 6), MONK("Monk", 5, 12, 7, 10, 12, 30, 5),
    PIKEMAN("Pikeman", 1, 4, 5, 1, 3, 10, 4), ROYAL_GRIFFIN("Royal Griffin", 3, 9, 9, 3, 6, 25, 9),
    SWORDSMAN("Swordsman", 4, 10, 12, 6, 9, 35, 5), ZEALOT("Zealot", 5, 12, 10, 10, 12, 30, 7),
    ROQUE("Roque", 2, 8, 3, 2, 4, 10, 6),PEASANT("Peasant", 1, 1, 1, 1, 1, 1, 3);

    private String name;
    private int level;
    private int attack;
    private int defense;
    private int minimumDamage;
    private int maximumDamage;
    private int health;
    private int speed;

    EnemyType(String name, int level, int attack, int defense, int minimumDamage, int maximumDamage, int health, int speed) {
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.defense = defense;
        this.minimumDamage = minimumDamage;
        this.maximumDamage = maximumDamage;
        this.health = health;
        this.speed = speed;
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
}
