package com.herculis;

public class GenericProperties {

    private static GenericProperties genericProperties = null;

    private GenericPropertiesLoader genericPropertiesLoader;

    private GenericProperties() {
        this.genericPropertiesLoader = new GenericPropertiesLoader();
        this.genericPropertiesLoader.load();
    }

    public static GenericProperties getInstance() {
        if (genericProperties == null) {
            genericProperties = new GenericProperties();
        }

        return genericProperties;
    }

    public String getProperties(String propName) {
        return genericPropertiesLoader.getProperties().getProperty(propName);
    }

}
