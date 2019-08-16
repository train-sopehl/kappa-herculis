package com.herculis.model;

import com.herculis.annotation.Field;

public class MerchantTest {

    @Field("MERCHANTUSER")
    private String username;

    @Field("MERCHANTPASSWORD")
    private String password;

    @Field("MERCHANT")
    private String merchantBusinessId;

    private String returnUrl;

    @Field(ignored = true)
    private String merchantIgnoredField;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMerchantBusinessId() {
        return merchantBusinessId;
    }

    public void setMerchantBusinessId(String merchantBusinessId) {
        this.merchantBusinessId = merchantBusinessId;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getMerchantIgnoredField() {
        return merchantIgnoredField;
    }

    public void setMerchantIgnoredField(String merchantIgnoredField) {
        this.merchantIgnoredField = merchantIgnoredField;
    }
}
