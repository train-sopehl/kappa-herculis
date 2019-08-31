package com.herculis.contract;

import com.herculis.GenericProperties;

public class AbstractTransaction {

    protected GenericProperties properties = GenericProperties.getInstance();

    protected String apiUrl = properties.getProperties("herculis.api.url");

}
