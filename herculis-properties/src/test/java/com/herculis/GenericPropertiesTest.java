package com.herculis;

import org.junit.Assert;
import org.junit.Test;

public class GenericPropertiesTest {

    public GenericProperties genericProperties = GenericProperties.getInstance();

    @Test
    public void getPropertiesValue_appName() {
        String appName = genericProperties.getProperties("app.name");

        Assert.assertEquals("Herculis App", appName);
    }

}
