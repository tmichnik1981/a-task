package com.me.poc.domain.player;

public class Fighter extends Player {
    public Fighter(PlayerBuilder playerBuilder) {
        super(playerBuilder);
    }

    public Fighter(String characterName) {
        super(characterName, PlayerType.FIGHTER);
    }
}

