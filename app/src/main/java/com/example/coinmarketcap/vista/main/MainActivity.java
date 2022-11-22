package com.example.coinmarketcap.vista.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.coinmarketcap.R;
import com.example.coinmarketcap.modelo.remoto.ClienteRetrofit;
import com.example.coinmarketcap.modelo.remoto.CoinMarket;
import com.example.coinmarketcap.modelo.remoto.CoinMarketResponse;
import com.example.coinmarketcap.modelo.remoto.ServicioCoinMarket;
import com.example.coinmarketcap.vista.detalles.DetallesActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerCoinAdapter adapter;
    private ClienteRetrofit cliente;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cliente=new ClienteRetrofit();

        recyclerView=findViewById(R.id.recyclerCoin);
        cargar();

    }
    private void cargar(){
        ServicioCoinMarket servicio=cliente.getRetrofit().create(ServicioCoinMarket.class);
        servicio.lastest().enqueue(new Callback<CoinMarketResponse>() {
            @Override
            public void onResponse(Call<CoinMarketResponse> call, Response<CoinMarketResponse> response) {
                adapter=new RecyclerCoinAdapter(MainActivity.this,response.body().data);
                adapter.setOnClickItem(new RecyclerCoinAdapter.OnClickItem() {
                    @Override
                    public void onClik(CoinMarket item) {
                        Intent intent=new Intent(MainActivity.this, DetallesActivity.class);
                        intent.putExtra("cmc_rank",item.cmc_rank);
                        intent.putExtra("coin_model",item.symbol +" "+item.name);
                        intent.putExtra("coin_price",item.quote.USD.price+"");
                        intent.putExtra("coin_market_cap",item.quote.USD.market_cap+"");
                        intent.putExtra("coin_max_supply",item.max_supply+"");
                        intent.putExtra("coin_circulating_supply",item.circulating_supply+"");
                        intent.putExtra("coin_percent_change_24h",item.quote.USD.percent_change_24h+"");
                        intent.putExtra("coin_percent_change_30d",item.quote.USD.percent_change_30d+"");
                        startActivity(intent);
                    }
                });
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setAdapter(adapter);
                Log.i("test ser", response.body().data.size()+"");
            }

            @Override
            public void onFailure(Call<CoinMarketResponse> call, Throwable t) {

            }
        });
    }
}