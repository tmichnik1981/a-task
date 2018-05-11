package com.me.poc.view;

import com.me.poc.util.ANSII;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

public class NewGameTemplate implements ViewTemplate {

    private final BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
    private boolean keepWindowRunning;
    private ViewModel model;

    public Map<String, String> render(ViewModel model) {

        return null;
    }


    public void validateInput(String key) {


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
