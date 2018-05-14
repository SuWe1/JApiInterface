package com.swy.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * created by Swy on 5/14/2018
 */
public class GsonUtil {

    private static Gson gson = new GsonBuilder().create();

    public static String bean2Json(Object object) {
        return gson.toJson(object);
    }

    public static <T> T json2Bean(String jsonStr, Class<T> objectClass) {
        return gson.fromJson(jsonStr, objectClass);
    }

    public static String jsonFormater(String uglyJsonStr) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(uglyJsonStr);
        return gson.toJson(je);
    }
}
