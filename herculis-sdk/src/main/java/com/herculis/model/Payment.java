package com.herculis.model;

import com.herculis.annotation.Field;

public class Payment {

    @Field("MERCHANTPAYMENTID")
    private String paymentId;

    public Payment() {
    }

    public Payment(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }
}
