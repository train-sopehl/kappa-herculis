package com.herculis;

import com.herculis.http.*;
import com.herculis.http.exception.HttpResponseException;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.logging.Logger;

public class GetRequestTest {

    private static final Logger LOGGER = Logger.getLogger(GetRequestTest.class.getName());

    private HerculisHttpCall httpCall = new HerculisHttpCall();

    @Test
    public void httpGetCall_withSuccess() {
        HttpRequest httpRequest = new HttpRequest();
        httpRequest.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");

        String url = "https://httpstat.us/200";

        HttpResponse response = this.httpCall.doAction(url, HttpMethod.GET, httpRequest);
        String actual = "responseStatus=200";
        Assert.assertThat(String.valueOf(response), CoreMatchers.containsString(actual));
    }

    @Test(expected = HttpResponseException.class)
    public void httpGetCall_withHttpResponseException() {
        HttpRequest httpRequest = new HttpRequest();
        httpRequest.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");

        String url = "https://httpstat.us/404";

        HttpResponse response = this.httpCall.doAction(url, HttpMethod.GET, httpRequest);
        LOGGER.info(String.valueOf(response));
    }

}
