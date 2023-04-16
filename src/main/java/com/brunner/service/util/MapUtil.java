package com.brunner.service.util;

import java.util.HashMap;

import com.google.gson.JsonNull;
import com.google.gson.JsonObject;

public class MapUtil {
	public static Object getNullable(HashMap<String, Object> map, String key) {
        return map.containsKey(key) == false || map.get(key) == null ? null : map.get(key);
	}
	
	public static String getNullableString(HashMap<String, Object> map, String key) {
        return map.containsKey(key) == false || map.get(key) == null ? "" : map.get(key).toString();
	}

	public static String getNullableString(JsonObject jObj, String key) {
        return jObj.has(key) == false || jObj.get(key) == null || jObj.get(key).equals(JsonNull.INSTANCE) == true ? "" : jObj.get(key).getAsString(); 
	}
}
