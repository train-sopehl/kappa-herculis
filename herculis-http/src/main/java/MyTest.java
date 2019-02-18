import com.herculis.http.*;

/**
 * dummy rest calls : http://dummy.restapiexample.com
 */
public class MyTest {

    public static void main(String[] args) {
        HerculisHttpCall httpCall = new HerculisHttpCall();

        System.out.println("---------------GET--------------");

        HttpRequest httpRequest = new HttpRequest();
        httpRequest.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        httpRequest.addParameters("asd", "adasd");

        HttpResponse response = httpCall.doAction("http://httpbin.org/get", HttpMethod.GET, httpRequest);
        System.out.println(response);

        System.out.println("-------------POST--------------");

        HttpRequest postRequest = new HttpRequest();
        postRequest.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");

        HttpResponse postResponse = httpCall.doAction("http://httpbin.org/post", HttpMethod.POST, postRequest);
        System.out.println(postResponse);

        System.out.println("---------------GET--------------");

        HttpRequest base64RequestGet = new HttpRequest();
        base64RequestGet.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");

        HttpResponse base64ResponseGet = httpCall.doAction("https://httpbin.org/base64/okan", HttpMethod.GET, base64RequestGet);
        System.out.println(base64ResponseGet);

        System.out.println("---------------POST--------------");

        HttpRequest createPostRequest = new HttpRequest();
        createPostRequest.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        createPostRequest.setBody("{\"name\":\"test\",\"salary\":\"123\",\"age\":\"23\"}");

        HttpResponse createPostResponse = httpCall.doAction("http://dummy.restapiexample.com/api/v1/create", HttpMethod.POST, createPostRequest);
        System.out.println(createPostResponse);
    }

}
