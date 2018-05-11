package com.me.poc.view;

import com.me.poc.util.StringUtils;

import java.util.Collections;
import java.util.Set;

public class ViewMenu {

    private static final String LABEL = ">";
    public static final String INPUT_KEY = "_menu_";
    public static final String QUIT = "Q";

    private final String text;
    private final Set<String> allowedValues;
    private final String label = LABEL;
    private final String inputKey = INPUT_KEY;

    public ViewMenu(String text, Set<String> allowedValues) {
        this.text = text;
        this.allowedValues = allowedValues;
    }

    public String getText() {
        return text;
    }


    public String getLabel() {
        return label;
    }

    public String getInputKey() {
        return inputKey;
    }

    public Set<String> getAllowedValues() {
        return Collections.unmodifiableSet(allowedValues);
    }

    public boolean isMenuCommand(String inputValue) {

        String notNullInput = StringUtils.trimToEmpty(inputValue).toUpperCase();

        return allowedValues.contains(notNullInput);
    }
}
