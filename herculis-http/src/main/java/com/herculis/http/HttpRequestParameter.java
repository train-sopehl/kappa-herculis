package com.herculis.http;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HttpRequestParameter {

    private Map<String, String> parameters;

    private static final Logger LOGGER = Logger.getLogger(HttpRequestParameter.class.getName());

    public HttpRequestParameter() {
        this.parameters = new HashMap<String, String>();
    }

    public HttpRequestParameter(Map<String, String> parameters){
        this.parameters = parameters;
    }

    public String addParameter(String key, String value) {
        return this.parameters.put(key, value);
    }

    public String formRequestParameter() {
        StringBuilder requestParameters = new StringBuilder();

        for (Map.Entry<String, String> entry : this.parameters.entrySet()) {
            try {
                requestParameters.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                requestParameters.append("=");
                requestParameters.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                requestParameters.append("&");
            } catch (UnsupportedEncodingException e) {
                LOGGER.log(Level.SEVERE, e.getMessage());
            }
        }
        String resultAsString = String.valueOf(requestParameters);
        return resultAsString.length() > 0 ? resultAsString.substring(0, resultAsString.length() - 1) : resultAsString;
    }
}
