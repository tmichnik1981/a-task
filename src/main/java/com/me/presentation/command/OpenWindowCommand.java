package com.me.presentation.command;

import com.me.presentation.window.GameWindow;

public class OpenWindowCommand implements Command {


    private final GameWindow toOpenWindow;
    private final GameWindow currentWindow;

    public OpenWindowCommand(GameWindow currentWindow, GameWindow toOpenWindow) {
        this.currentWindow = currentWindow;
        this.toOpenWindow = toOpenWindow;
    }

    @Override
    public void execute() {
        currentWindow.close();
        new Thread(toOpenWindow).start();
    }
}
