package com.me.presentation.command;

import com.me.presentation.exception.ExitingException;

public class ExitGameCommand implements Command {
    @Override
    public void execute() {
        throw new ExitingException("Exiting");
    }
}
