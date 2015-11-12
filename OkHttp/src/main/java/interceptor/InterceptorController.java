package interceptor;


import com.squareup.okhttp.OkHttpClient;

public class InterceptorController
{
    private final OkHttpClient client;

    public InterceptorController()
    {
        client = new OkHttpClient();
        client.interceptors().add(new QAWallInterceptor());

    }

    public OkHttpClient getOkHttpClient(){
        return client;
    }

}
