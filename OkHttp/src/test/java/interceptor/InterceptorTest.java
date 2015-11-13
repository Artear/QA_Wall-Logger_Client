package interceptor;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class InterceptorTest
{

    private static final String URL_TEST = "http://192.168.15.67:9188";

    private OkHttpClient client;

    @Test
    public void interceptorTest() {

        // QAWallInterceptor is tested

        client = new OkHttpClient();
        client.interceptors().add(new QAWallInterceptor(URL_TEST));

        Request request = new Request.Builder()
                .url("http://www.publicobject.com/helloworld.txt")
                .header("User-Agent", "OkHttp Example")
                .build();

        Response response = null;

        try
        {
            response = client.newCall(request).execute();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.message());
        Assert.assertNotNull(response.body());

        System.out.println("Message: " + response.message() + ", Code:" + response.code());
    }


}
