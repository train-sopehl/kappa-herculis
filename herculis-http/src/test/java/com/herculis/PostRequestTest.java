package com.herculis;

import com.herculis.http.*;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class PostRequestTest {

    private HerculisHttpCall httpCall = HerculisHttpCall.getInstance();

    @Test
    public void httpGetCall_withSuccess() {
        HttpRequest createPostRequest = new HttpRequest();
        createPostRequest.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        createPostRequest.setBody("{\"name\":\"test\",\"salary\":\"123\",\"age\":\"23\"}");

        HttpResponse createPostResponse = httpCall.doAction("http://dummy.restapiexample.com/api/v1/create", HttpMethod.POST, createPostRequest);
        String actual = "responseStatus=200";
        Assert.assertThat(String.valueOf(createPostResponse), CoreMatchers.containsString(actual));
    }
}
