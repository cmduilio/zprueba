package com.samit.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SimpleJson {
	
	Map<String,String> map = new HashMap<>();

	public SimpleJson() {
	}
	
	public String toJson() {
		String json = "{";
		Iterator<String> iterator = map.keySet().iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			String value = map.get(key);
			json += "\"" + key + "\":\"" + value + "\"";
			if(iterator.hasNext()) {
				json += ",";
			}
		}
		
		json+= "}";
		
		return json;
	}
	
	public void put(String key, String value) {
		map.put(key, value);
	}
	
	public Boolean contains(String key) {
		return map.containsKey(key);
	}
}
