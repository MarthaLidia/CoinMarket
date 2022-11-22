package com.example.coinmarketcap.vista.detalles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.coinmarketcap.R;

public class DetallesActivity extends AppCompatActivity {
    public TextView coin_rank,coin_name,coin_price,coin_market_cap,coin_max_supply,coin_circulating_supply,coin_percent_change_24h,coin_percent_change_30d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);
        coin_rank=findViewById(R.id.coin_rank);
        coin_name=findViewById(R.id.coin_name);
        coin_price=findViewById(R.id.coin_price);
        coin_market_cap=findViewById(R.id.coin_market_cap);
        coin_max_supply=findViewById(R.id.coin_max_supply);
        coin_circulating_supply=findViewById(R.id.coin_circulating_supply);
        coin_percent_change_24h=findViewById(R.id.coin_percent_change_24h);
        coin_percent_change_30d=findViewById(R.id.coin_percent_change_30d);

        coin_rank.setText(getIntent().getStringExtra("cmc_rank"));
        coin_name.setText(getIntent().getStringExtra("coin_model"));
        coin_price.setText(getIntent().getStringExtra("coin_price"));
        coin_market_cap.setText(getIntent().getStringExtra("coin_market_cap"));
        coin_max_supply.setText(getIntent().getStringExtra("coin_max_supply"));
        coin_circulating_supply.setText(getIntent().getStringExtra("coin_circulating_supply"));
        coin_percent_change_24h.setText(getIntent().getStringExtra("coin_percent_change_24h"));
        coin_percent_change_30d.setText(getIntent().getStringExtra("coin_percent_change_30d"));

    }
}