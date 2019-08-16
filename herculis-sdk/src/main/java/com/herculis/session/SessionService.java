package com.herculis.session;

import com.herculis.GenericProperties;
import com.herculis.contract.Transformable;
import com.herculis.http.HerculisHttpCall;
import com.herculis.http.HttpMethod;
import com.herculis.http.HttpRequest;
import com.herculis.http.HttpResponse;
import com.herculis.model.RequestPaymentSessionToken;
import com.herculis.model.ResponsePaymentSessionToken;
import com.herculis.transform.JsoniterTransform;
import com.herculis.util.FieldMapper;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SessionService {

    private GenericProperties properties = GenericProperties.getInstance();

    private String apiUrl = properties.getProperties("herculis.api.url");

    private Transformable transformable;

    private static final Logger LOGGER = Logger.getLogger(FieldMapper.class.getName());

    public SessionService(){
        this.transformable = new JsoniterTransform();
    }

    public SessionService(Transformable transformable){
        this.transformable = transformable;
    }

    public ResponsePaymentSessionToken getPaymentSessionToken(RequestPaymentSessionToken request) {
        HerculisHttpCall httpCall = HerculisHttpCall.getInstance();

        HttpRequest httpRequest = new HttpRequest();
        httpRequest.addParameter("ACTION", "SESSIONTOKEN");
        httpRequest.addParameter("AMOUNT", String.valueOf(request.getAmount()));
        httpRequest.addParameter("CURRENCY", request.getCurrency().name());
        httpRequest.addParameter(FieldMapper.mapObjectFields(request.getPayment()));
        httpRequest.addParameter(FieldMapper.mapObjectFields(request.getMerchant()));
        httpRequest.addParameter(FieldMapper.mapObjectFields(request.getCustomer()));
        httpRequest.addParameter(FieldMapper.mapObjectFields(request.getBillAddress()));
        httpRequest.addParameter(FieldMapper.mapObjectFields(request.getShipAddress()));
        httpRequest.addParameter("SESSIONTYPE", "PAYMENTSESSION");
        try {
            httpRequest.addParameter("ORDERITEMS", URLEncoder.encode(transformable.toJson(request.getOrderItems()), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            LOGGER.log(Level.SEVERE, String.valueOf(e));
        }

        HttpResponse httpResponse = httpCall.doAction(apiUrl, HttpMethod.POST, httpRequest);
        String httpResponseBody = httpResponse.getBody();
        return transformable.toObject(httpResponseBody, ResponsePaymentSessionToken.class);
    }

}
