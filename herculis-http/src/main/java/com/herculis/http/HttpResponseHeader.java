package com.herculis.http;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpResponseHeader {

    private Map<String, List<String>> responseHeader;

    public HttpResponseHeader() {
        this.responseHeader = new HashMap<String, List<String>>();
    }

    public HttpResponseHeader(Map<String, List<String>> responseHeader) {
        this.responseHeader = responseHeader;
    }

    public List<String> addResponseHeader(String key, List<String> value) {
        return this.responseHeader.put(key, value);
    }

    public List<String> getResponseHeader(String key) {
        return this.responseHeader.get(key);
    }

    @Override
    public String toString() {
        return "HttpResponseHeader{" +
                "responseHeader=" + responseHeader +
                '}';
    }
}
