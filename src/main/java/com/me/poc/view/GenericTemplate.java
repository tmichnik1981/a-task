package com.me.poc.view;

import com.me.poc.util.ANSII;
import com.me.poc.exception.UnKnownCommandException;
import com.me.poc.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

public class GenericTemplate {


    private final BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
    private boolean keepWindowRunning;
    private ViewModel model;

    public String render(ViewModel model) {
        keepWindowRunning = true;
        String validationMessage = "";
        this.model = model;
        String inputValue = "";
        do {


            renderTitle(model.getTitle());

            renderInfoMsg(model.getInfoMessage());

            renderErrorMsg(model.getErrorMessage());
            renderErrorMsg(validationMessage);

            renderMenu(model.getMenu());

            renderUnFormattedText(model.getDescription());


            try {
                ViewCommand viewCommand = model.getCommand();
                if (viewCommand != null) {
                    renderCommand(model.getCommand().getText());
                    inputValue = inputReader.readLine();
                    validateInput(inputValue);
                }

            } catch (UnKnownCommandException ex) {
                eraseScreen();
                validationMessage = ex.getMessage();
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }

        } while (keepWindowRunning);

        return inputValue;
    }


    public void validateInput(String key) {

        Set<String> allowedCommands = model.getCommand().getAllowedValues();

        String trimmedUpperKey = StringUtils.trimToEmpty(key).toUpperCase();

        if (allowedCommands.contains(trimmedUpperKey)) {
            keepWindowRunning = false;
        } else {
            throw new UnKnownCommandException("Provided unknown command: " + key);
        }


    }

    protected void renderCommand(String commandText) {
        System.out.println("\n\n\n");
        System.out.print(commandText + " " + ANSII.NORMAL);
    }

    protected void renderUnFormattedText(String text) {
        System.out.println(text);
    }

    protected void eraseScreen() {
        System.out.println(ANSII.ERASE_SCREEN);
    }

    protected void renderTitle(String title) {
        System.out.println(ANSII.BACKGROUND_CYAN + title + ANSII.NORMAL);
    }

    protected void renderErrorMsg(String errorMessage) {
        if (!errorMessage.isEmpty()) {
            System.out.println(ANSII.BACKGROUND_RED + errorMessage + ANSII.NORMAL);

        }
    }

    protected void renderInfoMsg(String infoMessage) {
        if (!infoMessage.isEmpty()) {
            System.out.println(ANSII.BACKGROUND_GREEN + infoMessage + ANSII.NORMAL);

        }
    }

    protected void renderMenu(String menu) {
        System.out.println(ANSII.BLUE + menu + ANSII.NORMAL);
        System.out.print("\n\n\n");
    }

}
