package com.herculis.contract;

import com.herculis.model.request.PaymentSessionTokenRequest;
import com.herculis.model.response.PaymentSessionTokenResponse;

public interface ISessionToken {

    PaymentSessionTokenResponse getPaymentSessionToken(PaymentSessionTokenRequest request);

}
