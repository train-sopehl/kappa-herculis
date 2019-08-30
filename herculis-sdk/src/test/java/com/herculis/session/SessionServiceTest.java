package com.herculis.session;

import com.herculis.constant.ResponseSet;
import com.herculis.model.*;
import com.herculis.model.request.PaymentSessionTokenRequest;
import com.herculis.model.response.PaymentSessionTokenResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class SessionServiceTest {

    private SessionService sessionService = new SessionService();

    private PaymentSessionTokenRequest paymentSessionToken;

    @Before
    public void init(){
        paymentSessionToken = new PaymentSessionTokenRequest();

        paymentSessionToken.setAmount(new BigDecimal("4.54"));
        paymentSessionToken.setCurrency(Currency.TRY);

        paymentSessionToken.setPayment(new Payment("XYZ" + UUID.randomUUID().toString().substring(0, 15)));

        Merchant merchant = new Merchant();
        merchant.setMerchantBusinessId("10000000");
        merchant.setPassword("Pluto321`");
        merchant.setUsername("apiuser@testmerchant.com");
        merchant.setReturnUrl("https://herculis-paratika4j.com/");
        paymentSessionToken.setMerchant(merchant);

        Customer customer = new Customer();
        customer.setCustomerEmail("customer@herculis.com");
        customer.setCustomerIdentifier("12345678901");
        customer.setCustomerIp("192.168.0.1");
        customer.setCustomerName("Herculis Hercule");
        customer.setCustomerPhone("905555555555");
        paymentSessionToken.setCustomer(customer);

        BillAddress billAddress = new BillAddress();
        billAddress.setCity("Istanbul");
        billAddress.setCountry("Turkey");
        billAddress.setLine("Road");
        billAddress.setPhone("905555555555");
        billAddress.setPostalCode("1103");
        paymentSessionToken.setBillAddress(billAddress);

        ShipAddress shipAddress = new ShipAddress();
        shipAddress.setCity("Ankara");
        shipAddress.setCountry("Turkey");
        shipAddress.setLine("Road");
        shipAddress.setPhone("905555555555");
        shipAddress.setPostalCode("1105");
        paymentSessionToken.setShipAddress(shipAddress);

        OrderItems orderItem = new OrderItems();
        orderItem.setQuantity(1);
        orderItem.setName("mp3 player");
        orderItem.setDescription("my mp3 player");
        orderItem.setCode("xyz3mp");
        orderItem.setAmount(new BigDecimal("4.54"));
        List<OrderItems> orders = Collections.singletonList(orderItem);
        paymentSessionToken.setOrderItems(orders);
    }

    @Test
    public void getPaymentSessionToken_withSuccess(){
        PaymentSessionTokenResponse paymentSessionTokenResponse = sessionService.getPaymentSessionToken(paymentSessionToken);

        Assert.assertEquals(ResponseSet.SUCCESS, paymentSessionTokenResponse.getResponseCode());
        Assert.assertNotNull(paymentSessionTokenResponse.getSessionToken());
    }

    @Test
    public void getPaymentSessionToken_withFail(){
        paymentSessionToken.setAmount(new BigDecimal("10"));
        PaymentSessionTokenResponse paymentSessionTokenResponse = sessionService.getPaymentSessionToken(paymentSessionToken);

        Assert.assertEquals(ResponseSet.DECLINED, paymentSessionTokenResponse.getResponseCode());
        Assert.assertNotNull(paymentSessionTokenResponse.getErrorCode());
    }

}
