package com.me.presentation.window;

import com.me.presentation.command.Command;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class NewGameWindow extends GameWindow {

    private static final String TITLE = "New Game";

    private static final String MENU = "BACK (M1) EXIT (M2)";

    private final BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

    private final GameWindow previousWindow;

    private final Map<String, Command> windowCommands = new HashMap<>();


    private boolean keepWindowRunning;

    public NewGameWindow(GameWindow previousWindow) {
        this.previousWindow = previousWindow;
    }


    @Override
    public void open() {

    }

    @Override
    public void render() {

    }

    @Override
    public void close() {

    }


    @Override
    public void run() {

    }

    protected Optional<String> normalizeKeyCommand(String key) {

        return key == null || key.isEmpty() ? Optional.empty() : Optional.of(key.trim().toUpperCase());
    }
}
