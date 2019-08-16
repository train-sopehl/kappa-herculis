package com.herculis.commission;

import org.junit.Test;

public class CommissionServiceTest {

    @Test
    public void getMerchantCommissionService_withSuccess(){
        CommissionService commissionService = new CommissionService();

        String merchantCommission = commissionService.getMerchantCommission();
        System.out.println(merchantCommission);
    }

}
