package com.herculis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class GenericPropertiesLoader implements PropertiesLoader{

    private static final String DEFAULT_PROPERTIES_FILE_NAME = "./herculis.properties";

    private InputStream inputStream = null;

    private static final Logger LOGGER = Logger.getLogger(GenericPropertiesLoader.class.getName());

    private Properties properties = new Properties();

    @Override
    public Properties load() {
        String propertiesFileName = getPropertiesFileName();

        this.inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFileName);

        try {
            this.properties.load(this.inputStream);
        } catch (IOException e) {
            LOGGER.severe("Input reading problem. Details: " + e.getMessage());
        }

        return this.properties;
    }

    public String getPropertiesFileName() {
        String fileName = System.getProperty("properties.file.name");

        if (fileName == null || "".equals(fileName)) {
            return DEFAULT_PROPERTIES_FILE_NAME;
        }

        return fileName;
    }

    public Properties getProperties() {
        return this.properties;
    }

}
