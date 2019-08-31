package com.herculis.service;

import com.herculis.GenericProperties;
import com.herculis.contract.IFinancialTransaction;
import com.herculis.contract.ISessionToken;
import com.herculis.contract.Transformable;
import com.herculis.http.HerculisHttpCall;
import com.herculis.http.HttpMethod;
import com.herculis.http.HttpRequest;
import com.herculis.http.HttpResponse;
import com.herculis.model.request.SaleRequest;
import com.herculis.model.response.PaymentSessionTokenResponse;
import com.herculis.transform.JsoniterTransformer;
import com.herculis.util.FieldMapper;

public class SaleTransaction implements IFinancialTransaction<SaleRequest, String> {

    private ISessionToken sessionToken;

    private GenericProperties properties = GenericProperties.getInstance();

    private String apiUrl = properties.getProperties("herculis.api.url");

    private Transformable transformable;

    public SaleTransaction(ISessionToken sessionToken) {
        this.sessionToken = sessionToken;
        this.transformable = new JsoniterTransformer();
    }

    public SaleTransaction(ISessionToken sessionToken, Transformable transformable) {
        this.sessionToken = sessionToken;
        this.transformable = transformable;
    }

    @Override
    public String doTransaction(SaleRequest saleRequest) {
        PaymentSessionTokenResponse paymentSessionToken = sessionToken.getPaymentSessionToken(saleRequest);

        HerculisHttpCall httpCall = HerculisHttpCall.getInstance();
        HttpRequest httpRequest = new HttpRequest();

        httpRequest.addParameter("ACTION", "SALE");
        httpRequest.addParameter(FieldMapper.mapObjectFields(saleRequest.getCreditCard()));
        httpRequest.addParameter("SESSIONTOKEN", paymentSessionToken.getSessionToken());

        HttpResponse saleResponse = httpCall.doAction(apiUrl, HttpMethod.POST, httpRequest);

        return saleResponse.getBody();
    }
}
