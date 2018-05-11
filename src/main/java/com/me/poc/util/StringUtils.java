package com.me.poc.util;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class StringUtils {

    public static final String EMPTY = "";

    public static String trimToEmpty(final String str) {
                return str == null ? EMPTY : str.trim();
          }

    public static boolean isBlank(String inputValue) {
        throw new NotImplementedException();
    }

    public static boolean isNotBlank(String inputValue) {
        throw new NotImplementedException();
    }
}
