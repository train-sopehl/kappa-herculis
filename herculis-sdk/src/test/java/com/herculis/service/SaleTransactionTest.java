package com.herculis.service;

import com.herculis.contract.GsonTransformer;
import com.herculis.contract.IFinancialTransaction;
import com.herculis.model.request.SaleRequest;
import com.herculis.session.SessionService;
import com.herculis.support.DummyUtils;
import org.junit.Before;
import org.junit.Test;

public class SaleTransactionTest {

    private SaleRequest saleRequest;

    private IFinancialTransaction<SaleRequest, String> financialTransaction;

    @Before
    public void setup() {
        saleRequest = DummyUtils.createSaleRequest();

        financialTransaction = new SaleTransaction(new SessionService(), new GsonTransformer());
    }

    @Test
    public void saleTransactionTest_success() {
        System.out.println(financialTransaction.doTransaction(saleRequest));
    }

}
