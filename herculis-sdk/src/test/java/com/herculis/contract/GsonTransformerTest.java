package com.herculis.contract;

import com.herculis.model.OrderItems;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class GsonTransformerTest {

    private Transformable transformer = null;

    @Before
    public void init() {
        transformer = new GsonTransformer();
    }

    @Test
    public void fromObject_withSuccess(){
        OrderItems order = new OrderItems();
        order.setAmount(new BigDecimal("1.2"));
        order.setCode("123456");
        order.setDescription("test to transform");
        order.setName("my-order-name");
        order.setQuantity(1);

        List<OrderItems> orderItems = Collections.singletonList(order);

        String ordersAsString = transformer.toJson(orderItems);
        System.out.println(ordersAsString);

        Assert.assertThat(ordersAsString, CoreMatchers.containsString("123456"));
        Assert.assertThat(ordersAsString, CoreMatchers.containsString("test to transform"));
    }

    @Test
    public void toObject_withSuccess() {
        String rawJson = "[{\"name\":\"my-order-name12\",\"code\":\"111111\",\"amount\":1.3,\"quantity\":5,\"description\":\"convert to object\"}]";
        List orderItems = transformer.toObject(rawJson, List.class);
        String name = ((Map)orderItems.get(0)).get("name").toString();
        String code = ((Map)orderItems.get(0)).get("code").toString();
        System.out.println(name);

        Assert.assertEquals("my-order-name12", name);
        Assert.assertEquals("111111", code);
    }

}
