package com.me.presentation.window;


import com.me.presentation.command.Command;
import com.me.presentation.command.ExitGameCommand;
import com.me.presentation.command.LoadSavedGameCommand;
import com.me.presentation.command.OpenWindowCommand;
import com.me.presentation.exception.ExitingException;
import com.me.presentation.exception.UnKnownCommandException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ContinueGameWindow extends GameWindow {

    private static final String TITLE = "Continue saved game";

    private static final String MENU = "BACK (M1) EXIT (M2)";

    private final BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

    private final GameWindow previousWindow;

    private final Map<String, Command> windowCommands = new HashMap<>();

    private final LoadSavedGameCommand savedGameCommand = new LoadSavedGameCommand();

    private List<String> savedGames;
    private boolean keepWindowRunning;

    public ContinueGameWindow(GameWindow previousWindow) {
        this.previousWindow = previousWindow;

    }

    @Override
    public void run() {
        open();
    }

    @Override
    public void open() {
        windowCommands.put("M1", new OpenWindowCommand(this, previousWindow));
        windowCommands.put("M2", new ExitGameCommand());
        render();
    }

    @Override
    public void render() {
        eraseScreen();
        savedGames = getSavedGames();
        String errorMessage = "";


        do {

            renderTitle(TITLE);

            renderErrorMsg(errorMessage);

            renderMenu(MENU);

            if (!savedGames.isEmpty()) {
                System.out.println("List of saved games:");
                for (int k = 0; k < savedGames.size(); k++) {
                    System.out.println("- " + savedGames.get(k));
                }

            } else {
                System.out.println("You have no saved games");
            }

            try {
                renderCommand();

                handleInput(inputReader.readLine());

                errorMessage = "";
            } catch (ExitingException ex) {
                System.out.println("Bye!");
                keepWindowRunning = false;

            } catch (UnKnownCommandException ex) {
                eraseScreen();
                errorMessage = "Warning! " + ex.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                keepWindowRunning = false;

            }
        } while (keepWindowRunning);

    }

    @Override
    public void close() {
        keepWindowRunning = false;
    }

    private List<String> getSavedGames() {
        //TODO: list should come from the service
        return Arrays.asList("aa", "bbb");
    }


    public void handleInput(String key) {
        Optional<String> normalizedKeyOptional = normalizeKeyCommand(key);


        String normalizedKey = normalizedKeyOptional.orElseThrow(() -> new UnKnownCommandException("No command provided"));


        if (windowCommands.containsKey(normalizedKey)) {
            windowCommands.get(normalizedKey).execute();
        } else if (savedGames.contains(key)) {
         //   savedGameCommand.setGame(new Game(key));
            savedGameCommand.execute();
        } else {
            throw new UnKnownCommandException("Provided unknown command: " + key);
        }


    }


    protected Optional<String> normalizeKeyCommand(String key) {

        return key == null || key.isEmpty() ? Optional.empty() : Optional.of(key.trim().toUpperCase());
    }
}
