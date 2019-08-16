package com.herculis.http;

public class HerculisHttpCall extends AbstractHttpCall implements HttpCall {

    private static volatile HerculisHttpCall httpCall;

    private HerculisHttpCall(){

    }

    public static HerculisHttpCall getInstance(){
        if (httpCall == null) {
            synchronized (HerculisHttpCall.class){
                if(httpCall == null){
                    httpCall = new HerculisHttpCall();
                }
            }
        }
        return httpCall;
    }

    public HttpResponse get() {
        return null;
    }

    public HttpResponse post() {
        return null;
    }
}
