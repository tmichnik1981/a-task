package com.me.poc.view;

import com.me.poc.util.StringUtils;

import java.util.Collection;
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
    private final boolean required;

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

    public boolean isRequired() {
        return required;
    }

    public ViewCommand(ViewCommandBuilder builder) {
        this.title = builder.title;
        this.body = builder.body;
        this.label = builder.label;
        this.inputKey = builder.inputKey;
        this.allowedValues = builder.allowedValues;
        this.regex = builder.regex;
        this.required = builder.required;
    }

    public Set<ValidationStatus> validateInputCommand(String input) {

        Set<ValidationStatus> statuses = new HashSet<>();
        String notNullInput;

        if (required && StringUtils.isBlank(input)) {
            statuses.add(ValidationStatus.NULL_OR_EMPTY);
            return statuses;
        }
        notNullInput = StringUtils.trimToEmpty(input);

        if (!allowedValues.isEmpty() && !allowedValues.contains(notNullInput)) {
            statuses.add(ValidationStatus.NOT_ALLOWED);
        }
        if (StringUtils.isNotBlank(regex) && !notNullInput.matches(regex)) {
            statuses.add(ValidationStatus.DOES_NOT_MATCH);
        }

        if (statuses.isEmpty()) {
            statuses.add(ValidationStatus.VALID);
        }

        return statuses;
    }


    public static ViewCommandBuilder builder() {
        return new ViewCommandBuilder();
    }

    public static class ViewCommandBuilder {

        private String title = StringUtils.EMPTY;
        private String body = StringUtils.EMPTY;
        private String label;
        private String inputKey;
        private Set<String> allowedValues = new HashSet<>();
        private String regex = StringUtils.EMPTY;
        private boolean required = true;


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

        public ViewCommandBuilder withAllowedValues(Collection<String> allowedValues) {
            this.allowedValues.addAll(allowedValues);
            return this;
        }

        public ViewCommandBuilder withRegex(String regex) {
            this.regex = regex;
            return this;
        }

        public ViewCommandBuilder withRequired(boolean required) {
            this.required = required;
            return this;
        }

        public ViewCommand build() {
            return new ViewCommand(this);
        }
    }

    public enum ValidationStatus {
        VALID("Value is valid"), NOT_ALLOWED("Provided not allowed value"), DOES_NOT_MATCH("Provided value does not meet requirements"), NULL_OR_EMPTY("Value cannot be empty");

        private String defaultMessage;

        ValidationStatus(String message) {
            this.defaultMessage = message;
        }

        public String getDefaultMessage() {
            return defaultMessage;
        }
    }

}

