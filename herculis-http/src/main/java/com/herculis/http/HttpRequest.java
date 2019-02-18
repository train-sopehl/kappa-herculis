package com.herculis.http;

import java.util.HashMap;
import java.util.Map;

public class HttpRequest {

    private Map<String, String> httpHeaders;

    private String body = "";

    private HttpRequestParameter parameters;

    public HttpRequest() {
        this.httpHeaders = new HashMap<String, String>();
        this.parameters = new HttpRequestParameter();
    }

    public HttpRequest(Map<String, String> httpHeaders) {
        this.httpHeaders = httpHeaders;
    }

    public HttpRequest(Map<String, String> httpHeaders, String body, HttpRequestParameter parameters) {
        this.httpHeaders = httpHeaders;
        this.body = body;
        this.parameters = parameters;
    }

    public Map<String, String> getHttpHeaders() {
        return httpHeaders;
    }

    public void setHttpHeaders(Map<String, String> httpHeaders) {
        this.httpHeaders = httpHeaders;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public HttpRequestParameter getParameters() {
        return parameters;
    }

    public void setParameters(HttpRequestParameter parameters) {
        this.parameters = parameters;
    }

    public String addHeader(String key, String value) {
        return this.httpHeaders.put(key, value);
    }

    public HttpRequestParameter addParameters(String key, String value) {
        this.parameters.addParameter(key, value);
        return this.parameters;
    }

    public String getRawData() {
        String rawData = this.parameters.formRequestParameter();

        if (!"".equals(rawData)) {
            return rawData;
        }

        return this.body;
    }
}
