import com.herculis.http.HerculisHttpCall;
import com.herculis.http.HttpMethod;
import com.herculis.http.HttpRequestParameter;
import com.herculis.http.HttpResponse;

public class MyTest {

    public static void main(String[] args) {
        HerculisHttpCall httpCall = new HerculisHttpCall();

        HttpRequestParameter parameter = new HttpRequestParameter();
        parameter.addParameter("callback", "showMyIP");

        HttpResponse response = httpCall.doAction("http://ip.jsontest.com/", HttpMethod.GET, parameter);
        System.out.println(response);
        System.out.println(response.getResponseHeader().getResponseHeader("Content-Length"));
        System.out.println(response.getResponseHeader().getResponseHeader("Date"));
        System.out.println(response.getResponseHeader().getResponseHeader("Content-Type"));
    }

}
