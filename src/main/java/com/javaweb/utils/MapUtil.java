package com.javaweb.utils;

import java.util.Map;

public class MapUtil {
    public static <T> T getObject(Map<String, Object> search, String key, Class<T> tClass) {
        Object obj = search.getOrDefault(key, null);
        if(obj != null) {
            if(tClass.getName().equals("java.lang.Integer")) {
                obj = obj != "" ? Integer.valueOf(obj.toString()) : null;
            }
            else if(tClass.getName().equals("java.lang.Double")) {
                obj = obj != "" ? Double.valueOf(obj.toString()) : null;
            }
            else if(tClass.getName().equals("java.lang.String") && obj.equals("")) obj = null;
        }
        return tClass.cast(obj);
    }
}
