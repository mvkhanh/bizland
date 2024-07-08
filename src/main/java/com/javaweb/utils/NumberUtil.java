package com.javaweb.utils;

public class NumberUtil {
    public static boolean checkNumber(String s) {
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.getMessage();
            return false;
        }
        return true;
    }
}