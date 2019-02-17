package com.herculis.http;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpResponseHeader {

    private Map<String, List<String>> header;

    public HttpResponseHeader() {
        this.header = new HashMap<String, List<String>>();
    }

    public HttpResponseHeader(Map<String, List<String>> header) {
        this.header = header;
    }

    public List<String> addResponseHeader(String key, List<String> value) {
        return this.header.put(key, value);
    }

    public List<String> getResponseHeader(String key) {
        return this.header.get(key);
    }

    @Override
    public String toString() {
        return "HttpResponseHeader{" +
                "header=" + header +
                '}';
    }
}
