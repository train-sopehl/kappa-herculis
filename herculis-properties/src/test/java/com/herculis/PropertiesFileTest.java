package com.herculis;

import org.junit.Assert;
import org.junit.Test;

public class PropertiesFileTest {

    @Test
    public void getPropertiesFileNameTest() {
        GenericPropertiesLoader propertiesLoader = new GenericPropertiesLoader();

        String propertiesFileName = propertiesLoader.getPropertiesFileName();
        String actualFileName = "herculis.prop";

        Assert.assertNotEquals(actualFileName, propertiesFileName);
    }

    @Test
    public void getDefaultPropertiesFileName() {
        GenericPropertiesLoader propertiesLoader = new GenericPropertiesLoader();

        String propertiesFileName = propertiesLoader.getPropertiesFileName();
        String actualFileName = "./herculis.properties";

        Assert.assertEquals(actualFileName, propertiesFileName);
    }

}
