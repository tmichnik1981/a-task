package com.me.poc.view;

import com.me.poc.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ViewModel {

    private final String title;
    private final String infoMessage;
    private final String errorMessage;
    private final ViewMenu menu;
    private final String intro;
    private final List<ViewCommand> commands;

    public String getTitle() {
        return title;
    }

    public String getInfoMessage() {
        return infoMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }


    public String getIntro() {
        return intro;
    }

    public List<ViewCommand> getCommands() {
        return Collections.unmodifiableList(commands);
    }

    public ViewMenu getMenu() {
        return menu;
    }

    public ViewModel(ViewModelBuilder builder) {
        this.title = builder.title;
        this.infoMessage = builder.infoMessage;
        this.errorMessage = builder.errorMessage;
        this.intro = builder.intro;
        this.commands = builder.commands;
        this.menu = builder.menu;
    }

    public static ViewModelBuilder builder() {
        return new ViewModelBuilder();
    }

    public static class ViewModelBuilder {

        private String title;
        private String infoMessage = StringUtils.EMPTY;
        private String errorMessage = StringUtils.EMPTY;
        private String intro = StringUtils.EMPTY;
        private List<ViewCommand> commands = new ArrayList<>();
        private ViewMenu menu;

        public ViewModelBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public ViewModelBuilder withInfoMessage(String infoMessage) {
            this.infoMessage = infoMessage;
            return this;
        }

        public ViewModelBuilder withErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
            return this;
        }


        public ViewModelBuilder withIntro(String intro) {
            this.intro = intro;
            return this;
        }


        public ViewModelBuilder withMenu(ViewMenu menu) {
            this.menu = menu;
            return this;
        }

        public ViewModelBuilder withViewCommand(ViewCommand viewCommand) {
            this.commands.add(viewCommand);
            return this;
        }

        public ViewModel build() {
            return new ViewModel(this);
        }


    }

}
