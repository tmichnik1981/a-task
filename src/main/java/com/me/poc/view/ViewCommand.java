package com.me.poc.view;

import java.util.Set;

public class ViewCommand {
    private String text;
    private Set<String> allowedValues;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Set<String> getAllowedValues() {
        return allowedValues;
    }

    public void setAllowedValues(Set<String> allowedValues) {
        this.allowedValues = allowedValues;
    }


}
