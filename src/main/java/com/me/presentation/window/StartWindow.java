package com.me.presentation.window;

import com.me.presentation.command.Command;
import com.me.presentation.command.ExitGameCommand;
import com.me.presentation.command.OpenWindowCommand;
import com.me.presentation.exception.ExitingException;
import com.me.presentation.exception.UnKnownCommandException;
import com.me.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class StartWindow extends GameWindow {

    private static final String TITLE = "Start Window";

    private static final String MENU = "NEW GAME (M1)  CONTINUE (M2)  EXIT (M3)";

    private final BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

    private final Map<String, Command> windowCommands = new HashMap<>();

    private boolean keepWindowRunning;


    @Override
    public void run() {
        open();
    }

    @Override
    public void open() {
        windowCommands.put("M1", new OpenWindowCommand(this, new NewGameWindow(this)));
        windowCommands.put("M2", new OpenWindowCommand(this, new ContinueGameWindow(this)));
        windowCommands.put("M3", new ExitGameCommand());
        keepWindowRunning = true;
        render();
    }


    @Override
    public void render() {
        eraseScreen();
        String errorMessage = "";

        do {

            renderTitle(TITLE);

            renderErrorMsg(errorMessage);

            renderMenu(MENU);

            renderCommand();

            try {
                handleInputCommand(inputReader.readLine());

            }  catch (UnKnownCommandException ex) {
                eraseScreen();
                errorMessage = ex.getMessage();
            } catch (IOException  | ExitingException e) {
                System.out.println(e.getMessage());
                keepWindowRunning = false;
            }
        } while (keepWindowRunning);

    }

    @Override
    public void close() {
        keepWindowRunning = false;
    }


    public void handleInputCommand(String key) {

        String trimmedUpperKey = StringUtils.trimToEmpty(key).toUpperCase();

        if (windowCommands.containsKey(trimmedUpperKey)) {
            windowCommands.get(trimmedUpperKey).execute();
        } else {
            throw new UnKnownCommandException("Provided unknown command: " + key);
        }


    }

}
