package com.me.poc.view;

import com.me.poc.util.StringUtils;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ViewCommand {
    private final String title;
    private final String body;
    private final String label;
    private final String inputKey;
    private final Set<String> allowedValues;
    private final String regex;

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
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

    public String getRegex() {
        return regex;
    }

    public ViewCommand(ViewCommandBuilder builder) {
        this.title = builder.title;
        this.body = builder.body;
        this.label = builder.label;
        this.inputKey = builder.inputKey;
        this.allowedValues = builder.allowedValues;
        this.regex = builder.regex;
    }

    public static ViewCommandBuilder builder() {
        return new ViewCommandBuilder();
    }

    public static class ViewCommandBuilder {

        private String title = StringUtils.EMPTY;
        private String body  = StringUtils.EMPTY;
        private String label;
        private String inputKey;
        private Set<String> allowedValues = new HashSet<>();
        private String regex  = StringUtils.EMPTY;


        public ViewCommandBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public ViewCommandBuilder withBody(String body) {
            this.body = body;
            return this;
        }

        public ViewCommandBuilder withLabel(String label) {
            this.label = label;
            return this;
        }

        public ViewCommandBuilder withInputKey(String inputKey) {
            this.inputKey = inputKey;
            return this;
        }

        public ViewCommandBuilder withAllowedValue(String allowedValue) {
            this.allowedValues.add(allowedValue);
            return this;
        }

        public ViewCommandBuilder withRegex(String regex) {
            this.regex = regex;
            return this;
        }
    }


}
