package com.herculis.tags;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class InputTest {

    @Test
    public void inputHtmlGenerationTest(){
        String creditCard = "4342558146566662";
        Input input = new Input("hidden", "pan", creditCard);
        String inputHtml = input.toString();
        System.out.println(inputHtml);
        Assert.assertThat(inputHtml, CoreMatchers.containsString("value=\""+creditCard+"\""));
        Assert.assertThat(inputHtml, CoreMatchers.containsString("type=\"hidden\""));
        Assert.assertThat(inputHtml, CoreMatchers.containsString("name=\"pan\""));
    }

}
