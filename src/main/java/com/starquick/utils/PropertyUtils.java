package com.starquick.utils;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Properties;

import com.starquick.constants.frameworkConstranst;

import com.starquick.enums.ConfigProperties;

public class PropertyUtils {
	
	private PropertyUtils() {
		
	}
	public static Properties property = new Properties();
	public static final Map<String, String> ConfigMap = new HashMap<String, String>();
	static {
		try(FileInputStream file = new  FileInputStream(frameworkConstranst.getConfigfilepath())) {
			
			property.load(file);
		
//		for(Object keys: property.keySet()) {
//			 ConfigMap.put(String.valueOf(entry.getKey()), String.valueOf(property.get(entry.getKey())));
//				
//		}
		 for (Entry<Object, Object> entry : property.entrySet()) {
			 ConfigMap.put(String.valueOf(entry.getKey()), String.valueOf(property.get(entry.getKey())).trim());
			  }
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static String get(String key) throws Exception {
		if(Objects.isNull(key)|| Objects.isNull(ConfigMap.get(key))) {
			throw new Exception("Property name"+key+"is not found Please Check config.properties");
		}
		return ConfigMap.get(key);
	}
	public static String getvalue(String key) throws Exception{
		if(Objects.isNull(property.getProperty(key)) || Objects.isNull(key)) {
			throw new Exception("Property name"+key+"is not found Please Check config.properties");
		}
		return property.getProperty(key);
		
	}
	
	public static String get(ConfigProperties key) throws Exception {
		if(Objects.isNull(key)|| Objects.isNull(ConfigMap.get(key.name().toLowerCase()))) {
			throw new Exception("Property name " +key+" is not found Please Check config.properties ");
		}
		return ConfigMap.get(key.name().toLowerCase());
	}

}
