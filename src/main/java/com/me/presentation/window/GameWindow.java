package com.me.presentation.window;

import com.me.presentation.ANSII;

public abstract class GameWindow implements Runnable{

    public abstract void open();
    public abstract void close();
    public abstract void render();

    protected void renderCommand() {
        System.out.print("Command:" + ANSII.NORMAL);
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
