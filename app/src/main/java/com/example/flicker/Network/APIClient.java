package com.example.flicker.Network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    public static final String BASEURL = "https://api.flickr.com/services/rest/";
    public static Retrofit retrofit;
    public APIClient(){}

    public static APIClientInterface getRetrofit(){

        if (retrofit == null){
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient okHttpClient = builder.addInterceptor(interceptor).build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();
        }


        return retrofit.create(APIClientInterface.class);
    }

}
