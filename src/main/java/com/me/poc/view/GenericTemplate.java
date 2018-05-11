package com.me.poc.view;

import com.me.poc.exception.ValidationException;
import com.me.poc.util.ANSII;
import com.me.poc.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GenericTemplate implements ViewTemplate {

    private final BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
    private boolean keepWindowRunning = true;


    public Map<String, String> render(ViewModel model) {
        eraseScreen();

        keepWindowRunning = true;
        String validationMessage = "";
        Map<String, String> results = new HashMap<>();


        do {


            renderTitle(model.getTitle());

            renderInfoMsg(model.getInfoMessage());

            renderErrorMsg(model.getErrorMessage());
            renderErrorMsg(validationMessage);

            renderMenu(model.getMenuText());

            renderUnFormattedText(model.getIntro());

            List<ViewCommand> viewCommands = model.getCommands();
            try {

                for (ViewCommand eachCommand : viewCommands) {

                    eachCommand.getTitle();
                    eachCommand.getBody()
                    eachCommand.getLabel()
                    renderCommand(eachCommand.getLabel());

                    String inputValue = results.get(eachCommand.getInputKey());

                    if (StringUtils.isBlank(inputValue)) {
                        inputValue = inputReader.readLine();
                        //validate
                        boolean valid = validateInput(inputValue, eachCommand.getAllowedValues(), eachCommand.getRegex());
                    } else {
                        renderUnFormattedText(inputValue);

                    }


                }
                if (viewCommand != null) {
                    renderCommand(model.getCommand().getText());
                    inputValue = inputReader.readLine();
                    validateInput(inputValue, eachCommand.getAllowedValues(), inputValue);
                }

            } catch (ValidationException ex) {
                eraseScreen();
                validationMessage = ex.getMessage();
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }

        } while (keepWindowRunning);
        results.put("input", inputValue);
        return results;
    }

//TODO: add special menu keys
    public boolean validateInput(String inputValue, Set<String> allowedValues, String regex) {

        String trimmedUpperKey = StringUtils.trimToEmpty(key).toUpperCase();

        if (allowedValues.contains(trimmedUpperKey)) {
            stopWindow();
        } else {
            return false;
           /* throw new ValidationException("Provided unknown command: " + key);*/
        }

        return true;
    }

    private void stopWindow() {
        this.keepWindowRunning = false;
    }

    protected void renderCommand(String commandText) {
        System.out.println("\n");
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
    }

}
