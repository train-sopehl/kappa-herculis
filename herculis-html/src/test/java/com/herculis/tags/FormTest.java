package com.herculis.tags;

import com.herculis.html.FormMethod;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class FormTest {

    @Test
    public void formHtmlGenerationTest() {
        String action = "http://herculis-kappa-paratika4j.com/";

        Form form = Form.FormBuilder.getInstance()
                .addMethod(FormMethod.POST)
                .addAction(action)
                .addInput(new Input("cardOwner", "Paratika 4J"))
                .addInput(new Input("pan", "4342558146566662"))
                .addInput(new Input("expiryMonth", "12"))
                .addInput(new Input("expiryYear", "2020"))
                .addInput(new Input("cvv", "000"))
                .build();

        String formHtml = form.toString();
        System.out.println(formHtml);

        Assert.assertThat(formHtml, CoreMatchers.containsString("action=\"" + action + "\""));
        Assert.assertThat(formHtml, CoreMatchers.containsString("method=\"" + FormMethod.POST + "\""));
        Assert.assertThat(formHtml, CoreMatchers.containsString("</form>"));
    }

}
