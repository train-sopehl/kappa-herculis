package com.herculis.util;

import com.herculis.GenericProperties;

import java.util.HashMap;
import java.util.Map;

public class CredentialUtils {

    public static Map<String, String> getCredentials() {
        Map<String, String> apiUserCredentials = new HashMap<String, String>();
        apiUserCredentials.put("MERCHANTUSER", GenericProperties.getApiMerchantUsername());
        apiUserCredentials.put("MERCHANTPASSWORD", GenericProperties.getApiMerchantPassword());
        apiUserCredentials.put("MERCHANT", GenericProperties.getApiMerchantBusinessId());
        apiUserCredentials.put("RETURNURL", GenericProperties.getApiReturnUrl());

        return apiUserCredentials;
    }

}
