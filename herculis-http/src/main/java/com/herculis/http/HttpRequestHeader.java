package com.herculis.http;

import java.util.HashMap;
import java.util.Map;

public class HttpRequestHeader {

    private Map<String, String> httpHeaders;

    public HttpRequestHeader() {
        this.httpHeaders = new HashMap<String, String>();
    }

    public HttpRequestHeader(Map<String, String> httpHeaders) {
        this.httpHeaders = httpHeaders;
    }

    public Map<String, String> getHttpHeaders() {
        return httpHeaders;
    }

    public void setHttpHeaders(Map<String, String> httpHeaders) {
        this.httpHeaders = httpHeaders;
    }

    public String addHeader(String key, String value) {
        return this.httpHeaders.put(key, value);
    }
}
