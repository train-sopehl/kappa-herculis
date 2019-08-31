package com.herculis.service;

import com.herculis.contract.GsonTransformer;
import com.herculis.contract.IFinancialTransaction;
import com.herculis.model.PGTransaction;
import com.herculis.model.request.SaleRequest;
import com.herculis.model.request.VoidRequest;
import com.herculis.session.SessionService;
import com.herculis.support.DummyUtils;
import org.junit.Before;
import org.junit.Test;

public class VoidTransactionTest {

    private SaleRequest saleRequest;

    private IFinancialTransaction<com.herculis.model.request.SaleRequest, String> saleTransaction;

    private IFinancialTransaction<VoidRequest, String> voidTransaction;

    @Before
    public void setup() {
        saleRequest = DummyUtils.createSaleRequest();

        saleTransaction = new SaleTransaction(new SessionService(), new GsonTransformer());
        voidTransaction = new VoidTransaction();
    }

    @Test
    public void saleTransactionTest_success() {
        VoidRequest voidRequest = new VoidRequest();
        voidRequest.setPgTransaction(new PGTransaction("19243IzlD11201"));
        voidTransaction.doTransaction(voidRequest);
    }


}
