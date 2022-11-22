package com.example.coinmarketcap.modelo.remoto;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class ClienteRetrofit {
    private Retrofit retrofit;
    public ClienteRetrofit(){
        //Llamado de Retrofit para realizar peticiones al API REST.
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor)
                .readTimeout(360, TimeUnit.SECONDS)
                .connectTimeout(20,TimeUnit.SECONDS)
                .writeTimeout(360,TimeUnit.SECONDS)
                .build();


        retrofit = new Retrofit.Builder()
                .baseUrl("https://pro-api.coinmarketcap.com/")
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create().asLenient())
                .build();
    }
    //Metodo que retorna cliente.
    public Retrofit getRetrofit() {
        return retrofit;
    }
}
