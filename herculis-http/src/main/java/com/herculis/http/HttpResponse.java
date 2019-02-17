package com.herculis.http;

public class HttpResponse {

    private int responseStatus;

    private String responseMessage;

    private String body;

    public HttpResponse() {
    }

    public HttpResponse(int responseStatus, String responseMessage, String body) {
        this.responseStatus = responseStatus;
        this.responseMessage = responseMessage;
        this.body = body;
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

    @Override
    public String toString() {
        return "HttpResponse{" +
                "responseStatus=" + responseStatus +
                ", responseMessage='" + responseMessage + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
