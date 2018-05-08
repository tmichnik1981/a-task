package com.me.poc;

public class ViewModel {


    private String title="";
    private String infoMessage="";
    private String errorMessage="";
    private String menu="";
    private String description="";
    private ViewCommand command;

    public String getTitle() {
        return title;
    }

    public String getInfoMessage() {
        return infoMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }


    public String getMenu() {
        return menu;
    }


    public String getDescription() {
        return description;
    }

    public ViewCommand getCommand() {
        return command;
    }

    public void setCommand(ViewCommand command) {
        this.command = command;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setInfoMessage(String infoMessage) {
        this.infoMessage = infoMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
