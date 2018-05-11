package com.me.poc.view;

import java.util.Map;

public interface ViewTemplate {

    Map<String, String> render(ViewModel model);
}
