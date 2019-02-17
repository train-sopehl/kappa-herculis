import com.herculis.http.HerculisHttpCall;
import com.herculis.http.HttpMethod;
import com.herculis.http.HttpRequestParameter;
import com.herculis.http.HttpResponse;

public class MyTest {

    public static void main(String[] args) {
        HerculisHttpCall httpCall = new HerculisHttpCall();
        HttpResponse response = httpCall.doAction("http://ip.jsontest.com/?callback=showMyIP", HttpMethod.GET, null);
        System.out.println(response);

        HttpRequestParameter parameter = new HttpRequestParameter();
        parameter.addParameter("callback", "showMyIP");
        HttpResponse response2 = httpCall.doAction("http://ip.jsontest.com/", HttpMethod.GET, parameter);
        System.out.println(response2);
    }

}
