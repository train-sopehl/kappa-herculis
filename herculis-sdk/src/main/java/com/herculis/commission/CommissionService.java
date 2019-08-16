package com.herculis.commission;

import com.herculis.http.*;

public class CommissionService {

    private HerculisHttpCall httpCall = HerculisHttpCall.getInstance();

    public String getMerchantCommission() {
        String action = "QUERYMERCHANTCOMMISSION";
        String merchantUser = "apiuser@testmerchant.com";
        String merchantPassword = "Pluto321`";
        String merchant = "10000000";

        HttpRequest createPostRequest = new HttpRequest();
        createPostRequest.addParameter("ACTION", action);
        createPostRequest.addParameter("MERCHANTUSER", merchantUser);
        createPostRequest.addParameter("MERCHANTPASSWORD", merchantPassword);
        createPostRequest.addParameter("MERCHANT", merchant);

        HttpResponse createPostResponse = httpCall.doAction("https://test.paratika.com.tr/paratika/api/v2/", HttpMethod.POST, createPostRequest);
        return createPostResponse.getBody();
    }

}
