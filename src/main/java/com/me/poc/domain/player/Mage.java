package com.me.poc.domain.player;

public class Mage extends Player{
    public Mage(PlayerBuilder playerBuilder) {
        super(playerBuilder);
    }

    public Mage(String characterName) {
        super(characterName, PlayerType.MAGE);
    }
}
