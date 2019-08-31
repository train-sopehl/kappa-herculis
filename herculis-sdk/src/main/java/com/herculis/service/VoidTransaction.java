package com.herculis.service;

import com.herculis.contract.AbstractTransaction;
import com.herculis.contract.IFinancialTransaction;
import com.herculis.http.HerculisHttpCall;
import com.herculis.http.HttpMethod;
import com.herculis.http.HttpRequest;
import com.herculis.http.HttpResponse;
import com.herculis.model.request.VoidRequest;
import com.herculis.util.CredentialUtils;
import com.herculis.util.FieldMapper;

public class VoidTransaction extends AbstractTransaction implements IFinancialTransaction<VoidRequest, String> {

    @Override
    public String doTransaction(VoidRequest voidRequest) {
        HerculisHttpCall httpCall = HerculisHttpCall.getInstance();
        HttpRequest httpRequest = new HttpRequest();

        httpRequest.addParameter("ACTION", "VOID");
        httpRequest.addParameter(CredentialUtils.getCredentials());
        httpRequest.addParameter(FieldMapper.mapObjectFields(voidRequest.getPgTransaction()));

        HttpResponse saleResponse = httpCall.doAction(super.apiUrl, HttpMethod.POST, httpRequest);

        return saleResponse.getBody();
    }
}
