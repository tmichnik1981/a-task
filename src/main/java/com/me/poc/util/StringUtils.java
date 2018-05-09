package com.me.poc.util;

public class StringUtils {

    public static final String EMPTY = "";

    public static String trimToEmpty(final String str) {
                return str == null ? EMPTY : str.trim();
          }
}
