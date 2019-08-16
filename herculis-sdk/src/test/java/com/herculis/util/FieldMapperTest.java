package com.herculis.util;

import com.herculis.model.MerchantTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class FieldMapperTest {

    @Test
    public void mapDeclaredFields_byFieldAnnotation_success() {
        MerchantTest merchant = new MerchantTest();
        merchant.setMerchantBusinessId("10000000");
        merchant.setPassword("herculis123456.");
        merchant.setReturnUrl("http://herculis-return.com/my/path");
        merchant.setUsername("herculis-username");
        merchant.setMerchantIgnoredField("Ignored field");

        Map<String, String> mappedMerchantFields = FieldMapper.mapObjectFields(merchant);
        System.out.println(mappedMerchantFields);

        Assert.assertNotNull(mappedMerchantFields.get("MERCHANTPASSWORD"));
        Assert.assertNotNull(mappedMerchantFields.get("MERCHANT"));
        Assert.assertNotNull(mappedMerchantFields.get("MERCHANTUSER"));
        Assert.assertNotNull(mappedMerchantFields.get("RETURNURL"));

        Assert.assertNull(mappedMerchantFields.get("USERNAME"));

        Assert.assertNull(mappedMerchantFields.get("MERCHANTIGNOREDFIELD"));

    }

}
