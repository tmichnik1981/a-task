package com.me.poc.domain.game.enemy;

public abstract class Enemy {

    private final String name;
    private final int level;
    private final int attack;
    private final int defense;
    private final int minimumDamage;
    private final int maximumDamage;
    private int health;
    private final int speed;

    public Enemy(EnemyType enemyType) {
        this.name = enemyType.getName();
        this.level = enemyType.getLevel();
        this.attack = enemyType.getAttack();
        this.defense = enemyType.getDefense();
        this.minimumDamage = enemyType.getMinimumDamage();
        this.maximumDamage = enemyType.getMaximumDamage();
        this.health = enemyType.getHealth();
        this.speed = enemyType.getSpeed();
    }

}
