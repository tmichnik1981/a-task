package com.me.presentation.command;


import com.me.presentation.window.Game;

public class LoadSavedGameCommand implements Command {

    private Game game;

    @Override
    public void execute() {

    }

    public void setGame(Game game) {
        this.game = game;
    }
}
