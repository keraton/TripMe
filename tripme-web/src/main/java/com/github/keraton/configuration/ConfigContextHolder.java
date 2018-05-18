package com.github.keraton.configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Configuration Context holding thread local striping parameters
 */
public class ConfigContextHolder {

    private static final ThreadLocal<Map<String, String>> configContextHolder = new InheritableThreadLocal<Map<String, String>>() {
        @Override
        protected Map<String, String> initialValue() {
            return new HashMap<>();
        }
    };

    /**
     * @return Map<String,String> striping parameters in the current request context (thread-local)
     */
    public static Map<String, String> getStripingParameters() {
        return configContextHolder.get();
    }

    /**
     * Add a striping parameter for the current request context (thread-local)
     *
     * @param stripingParamName
     * @param stripingParamValue
     */
    public static void addStripingParameter(String stripingParamName, String stripingParamValue) {
        configContextHolder.get().put(stripingParamName, stripingParamValue);
    }

    /**
     * Clears the context
     */
    public static void clearContext() {
        configContextHolder.remove();
    }

}
