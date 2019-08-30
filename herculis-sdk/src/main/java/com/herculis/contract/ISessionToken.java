package com.herculis.contract;

import com.herculis.model.RequestPaymentSessionToken;
import com.herculis.model.ResponsePaymentSessionToken;

public interface ISessionToken {

    ResponsePaymentSessionToken getPaymentSessionToken(RequestPaymentSessionToken request);

}
