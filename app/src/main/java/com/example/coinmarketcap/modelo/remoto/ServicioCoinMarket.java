package com.example.coinmarketcap.modelo.remoto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ServicioCoinMarket {
    @Headers({"X-CMC_PRO_API_KEY: 1276dec7-5445-4bc4-9029-a052f3c160ee"})
    @GET("v1/cryptocurrency/listings/latest")
    public Call<CoinMarketResponse> lastest();
}
