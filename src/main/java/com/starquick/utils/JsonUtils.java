package com.starquick.utils;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.starquick.constants.FrameworkConstranst;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.starquick.enums.ConfigProperties;
import com.starquick.exceptions.FrameworkException;

@SuppressWarnings("unchecked")
public class JsonUtils {
	
	private JsonUtils() {
		
	}
	
	protected static Map<String, String> configMap = new HashMap<>();
	
	static {
		try {
			FileInputStream file = new  FileInputStream(FrameworkConstranst.getJsonfilepath());
			configMap = new ObjectMapper().readValue(file, HashMap.class);		  
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String get(String key)  {
		if(Objects.isNull(key)|| Objects.isNull(configMap.get(key))) {
			throw new FrameworkException("Property name"+key+"is not found Please Check config.properties");
		}
		return configMap.get(key);
	}

	
	public static String get(ConfigProperties key) {
		if(Objects.isNull(key)|| Objects.isNull(configMap.get(key.name().toLowerCase()))) {
			throw new FrameworkException("Property name"+key+"is not found Please Check config.properties");
		}
		return configMap.get(key.name().toLowerCase());
	}

}
