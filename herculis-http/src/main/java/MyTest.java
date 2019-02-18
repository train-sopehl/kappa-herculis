import com.herculis.http.*;

public class MyTest {

    public static void main(String[] args) {
        HerculisHttpCall httpCall = new HerculisHttpCall();

        System.out.println("---------------GET--------------");

        HttpRequestHeader httpHeaders = new HttpRequestHeader();
        httpHeaders.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");

        HttpResponse response = httpCall.doAction("http://www.httpbin.org/get", HttpMethod.GET, httpHeaders);
        System.out.println(response);
        System.out.println(response.getResponseHeader().getResponseHeader("Content-Length"));
        System.out.println(response.getResponseHeader().getResponseHeader("Date"));
        System.out.println(response.getResponseHeader().getResponseHeader("Content-Type"));

        System.out.println("-------------POST--------------");

        HttpRequestHeader postHeader = new HttpRequestHeader();
        postHeader.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");

        HttpResponse postResponse = httpCall.doAction("http://www.httpbin.org/post", HttpMethod.POST, httpHeaders);
        System.out.println(postResponse);
    }

}
