package com.herculis.model;

import com.herculis.annotation.Field;

public class Merchant {

    @Field("MERCHANTUSER")
    private String username;

    @Field("MERCHANTPASSWORD")
    private String password;

    @Field("MERCHANT")
    private String merchantBusinessId;

    private String returnUrl;

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
}
