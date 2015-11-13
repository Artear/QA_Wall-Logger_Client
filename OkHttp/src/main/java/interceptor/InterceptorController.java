package interceptor;


import com.squareup.okhttp.OkHttpClient;

public class InterceptorController
{
    private final OkHttpClient client;

    public InterceptorController(final String urlRemote)
    {
        client = new OkHttpClient();
        client.interceptors().add(new QAWallInterceptor(urlRemote));

    }

    public OkHttpClient getOkHttpClient(){
        return client;
    }

}
