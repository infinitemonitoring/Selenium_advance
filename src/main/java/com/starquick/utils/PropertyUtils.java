package com.starquick.utils;

import com.starquick.constants.FrameworkConstants;
import com.starquick.enums.ConfigProperties;
import com.starquick.exceptions.FrameworkException;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Properties;

public class PropertyUtils {

	private PropertyUtils() {

	}
	protected static Properties property = new Properties();
	protected static final Map<String, String> ConfigMap = new HashMap<String, String>();
	static {
		try(FileInputStream file = new  FileInputStream(FrameworkConstants.getConfigfilepath())) {

			property.load(file);

			//		for(Object keys: property.keySet()) {
			//			 ConfigMap.put(String.valueOf(entry.getKey()), String.valueOf(property.get(entry.getKey())));
			//				
			//		}
			for (Entry<Object, Object> entry : property.entrySet()) {
				ConfigMap.put(String.valueOf(entry.getKey()), String.valueOf(property.get(entry.getKey())).trim());
			}
		}catch(Exception e) {
			System.exit(0); 
			throw new FrameworkException("Some Issue While Loading Properties File");
		}
	}


	public static String get(String key) {
		if(Objects.isNull(key)|| Objects.isNull(ConfigMap.get(key))) {
			throw new FrameworkException("Property name"+key+"is not found Please Check config.properties");
		}
		return ConfigMap.get(key);
	}
	public static String getvalue(String key){
		if(Objects.isNull(property.getProperty(key)) || Objects.isNull(key)) {
			throw new FrameworkException("Property name"+key+"is not found Please Check config.properties");
		}
		return property.getProperty(key);

	}

	public static String get(ConfigProperties key)  {
		if(Objects.isNull(key)|| Objects.isNull(ConfigMap.get(key.name().toLowerCase()))) {
			throw new FrameworkException("Property name " +key+" is not found Please Check config.properties ");
		}
		return ConfigMap.get(key.name().toLowerCase());
	}
	public static  void setProperty(String classname){
		ConfigMap.put("Classname", classname);

	}
}
