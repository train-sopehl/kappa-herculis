package com.herculis.model.response;

public class PaymentSessionTokenResponse {

    private String responseCode;

    private String responseMsg;

    private String errorCode;

    private String errorMsg;

    private String violatorParam;

    private String sessionToken;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getViolatorParam() {
        return violatorParam;
    }

    public void setViolatorParam(String violatorParam) {
        this.violatorParam = violatorParam;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    @Override
    public String toString() {
        return "PaymentSessionTokenResponse{" +
                "responseCode='" + responseCode + '\'' +
                ", responseMsg='" + responseMsg + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                ", violatorParam='" + violatorParam + '\'' +
                ", sessionToken='" + sessionToken + '\'' +
                '}';
    }
}
