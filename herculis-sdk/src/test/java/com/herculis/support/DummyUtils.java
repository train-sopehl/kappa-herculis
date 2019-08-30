package com.herculis.support;

import com.herculis.model.*;
import com.herculis.model.request.PaymentSessionTokenRequest;
import com.herculis.model.request.SaleRequest;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class DummyUtils {

    public static SaleRequest createSaleRequest() {
        SaleRequest saleRequest = new SaleRequest();

        saleRequest.setAmount(new BigDecimal("4.54"));
        saleRequest.setCurrency(Currency.TRY);

        saleRequest.setPayment(new Payment("XYZ" + UUID.randomUUID().toString().substring(0, 15)));

        Merchant merchant = new Merchant();
        merchant.setMerchantBusinessId("10000000");
        merchant.setPassword("Pluto321`");
        merchant.setUsername("apiuser@testmerchant.com");
        merchant.setReturnUrl("https://herculis-paratika4j.com/");
        saleRequest.setMerchant(merchant);

        Customer customer = new Customer();
        customer.setCustomerEmail("customer@herculis.com");
        customer.setCustomerIdentifier("12345678901");
        customer.setCustomerIp("192.168.0.1");
        customer.setCustomerName("Herculis Hercule");
        customer.setCustomerPhone("905555555555");
        saleRequest.setCustomer(customer);

        BillAddress billAddress = new BillAddress();
        billAddress.setCity("Istanbul");
        billAddress.setCountry("Turkey");
        billAddress.setLine("Road");
        billAddress.setPhone("905555555555");
        billAddress.setPostalCode("1103");
        saleRequest.setBillAddress(billAddress);

        ShipAddress shipAddress = new ShipAddress();
        shipAddress.setCity("Ankara");
        shipAddress.setCountry("Turkey");
        shipAddress.setLine("Road");
        shipAddress.setPhone("905555555555");
        shipAddress.setPostalCode("1105");
        saleRequest.setShipAddress(shipAddress);

        OrderItems orderItem = new OrderItems();
        orderItem.setQuantity(1);
        orderItem.setName("mp3 player");
        orderItem.setDescription("my mp3 player");
        orderItem.setCode("xyz3mp");
        orderItem.setAmount(new BigDecimal("4.54"));
        List<OrderItems> orders = Collections.singletonList(orderItem);
        saleRequest.setOrderItems(orders);

        CreditCard creditCard = new CreditCard("5456165456165454", "12.2020", "Kappa Herculis");
        creditCard.setCvv("000");
        saleRequest.setCreditCard(creditCard);

        return saleRequest;
    }

    public static PaymentSessionTokenRequest createPaymentSessionTokenRequest() {
        return createSaleRequest();
    }
}
