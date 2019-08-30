package com.herculis.model.request;

import com.herculis.model.CreditCard;

public class SaleRequest extends PaymentSessionTokenRequest{

    private CreditCard creditCard;

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }
}
