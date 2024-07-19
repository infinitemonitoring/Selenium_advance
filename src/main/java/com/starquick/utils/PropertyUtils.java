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

/**
 * Utility class for handling properties files.
 * <p>
 * This class provides methods to read properties from a configuration file and access them using keys.
 * The properties file should be located at the path specified in {@link FrameworkConstants#getConfigfilepath()}.
 * </p>
 * 
 * @author Faraz Dasurkar
 * @version 1.0
 * @since 2024
 */
public class PropertyUtils {

    private PropertyUtils() {
        // Private constructor to prevent instantiation
    }

    protected static Properties property = new Properties();
    protected static final Map<String, String> ConfigMap = new HashMap<>();

    static {
        try (FileInputStream file = new FileInputStream(FrameworkConstants.getConfigfilepath())) {
            property.load(file);

            for (Entry<Object, Object> entry : property.entrySet()) {
                ConfigMap.put(String.valueOf(entry.getKey()), String.valueOf(property.get(entry.getKey())).trim());
            }
        } catch (Exception e) {
            System.exit(0); 
            throw new FrameworkException("Some issue occurred while loading the properties file.");
        }
    }

    /**
     * Retrieves the value associated with the specified key from the configuration map.
     * <p>
     * This method looks up the key in the loaded properties map and returns the associated value.
     * </p>
     * 
     * @param key the key whose associated value is to be returned.
     * @return the value associated with the specified key.
     * @throws FrameworkException if the key is not found in the configuration map.
     */
    public static String get(String key) {
        if (Objects.isNull(key) || Objects.isNull(ConfigMap.get(key))) {
            throw new FrameworkException("Property name " + key + " is not found. Please check the configuration properties file.");
        }
        return ConfigMap.get(key);
    }

    /**
     * Retrieves the value associated with the specified key from the properties object.
     * <p>
     * This method looks up the key in the loaded properties object and returns the associated value.
     * </p>
     * 
     * @param key the key whose associated value is to be returned.
     * @return the value associated with the specified key.
     * @throws FrameworkException if the key is not found in the properties object.
     */
    public static String getvalue(String key) {
        if (Objects.isNull(property.getProperty(key)) || Objects.isNull(key)) {
            throw new FrameworkException("Property name " + key + " is not found. Please check the configuration properties file.");
        }
        return property.getProperty(key);
    }

    /**
     * Retrieves the value associated with the specified {@link ConfigProperties} enum key from the configuration map.
     * <p>
     * This method converts the enum name to lowercase and uses it to look up the key in the loaded properties map.
     * </p>
     * 
     * @param key the {@link ConfigProperties} enum key whose associated value is to be returned.
     * @return the value associated with the specified enum key.
     * @throws FrameworkException if the key is not found in the configuration map.
     */
    public static String get(ConfigProperties key) {
        if (Objects.isNull(key) || Objects.isNull(ConfigMap.get(key.name().toLowerCase()))) {
            throw new FrameworkException("Property name " + key + " is not found. Please check the configuration properties file.");
        }
        return ConfigMap.get(key.name().toLowerCase());
    }

    /**
     * Sets the class name in the configuration map.
     * <p>
     * This method adds or updates the "Classname" entry in the configuration map with the provided value.
     * </p>
     * 
     * @param classname the class name to be set in the configuration map.
     */
    public static void setProperty(String classname) {
        ConfigMap.put("Classname", classname);
    }
}
