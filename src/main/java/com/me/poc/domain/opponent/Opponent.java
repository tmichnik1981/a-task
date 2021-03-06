package com.me.poc.domain.opponent;

import com.me.poc.domain.DuelMediator;

public abstract class Opponent {

    private final String name;
    private final int level;
    private final int attack;
    private final int defense;
    private final int minimumDamage;
    private final int maximumDamage;
    private int health;
    private final int speed;
    private DuelMediator duelMediator;

    public void setDuelMediator(DuelMediator duelMediator) {
        this.duelMediator = duelMediator;
    }

    public Opponent(OpponentType opponentType) {
        this.name = opponentType.getName();
        this.level = opponentType.getLevel();
        this.attack = opponentType.getAttack();
        this.defense = opponentType.getDefense();
        this.minimumDamage = opponentType.getMinimumDamage();
        this.maximumDamage = opponentType.getMaximumDamage();
        this.health = opponentType.getHealth();
        this.speed = opponentType.getSpeed();
    }

}
