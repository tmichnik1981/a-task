package com.me.poc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Scenario   implements Serializable {
    List<Step> steps = new ArrayList<>();

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }
}
