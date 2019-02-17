package com.herculis.http;

public class HttpResponse {

    private int responseStatus;

    private String responseMessage;

    private String body;

    private HttpResponseHeader responseHeader;

    public HttpResponse() {
    }

    public HttpResponse(int responseStatus, String responseMessage, String body) {
        this.responseStatus = responseStatus;
        this.responseMessage = responseMessage;
        this.body = body;
    }

    public HttpResponse(int responseStatus, String responseMessage, String body, HttpResponseHeader responseHeader) {
        this.responseStatus = responseStatus;
        this.responseMessage = responseMessage;
        this.body = body;
        this.responseHeader = responseHeader;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(int responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public HttpResponseHeader getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(HttpResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    @Override
    public String toString() {
        return "HttpResponse{" +
                "responseStatus=" + responseStatus +
                ", responseMessage='" + responseMessage + '\'' +
                ", body='" + body + '\'' +
                ", responseHeader=" + responseHeader +
                '}';
    }
}
