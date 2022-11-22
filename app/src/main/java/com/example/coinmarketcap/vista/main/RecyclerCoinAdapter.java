package com.example.coinmarketcap.vista.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coinmarketcap.R;
import com.example.coinmarketcap.modelo.remoto.CoinMarket;

import java.util.List;

public class RecyclerCoinAdapter extends RecyclerView.Adapter<RecyclerCoinAdapter.ViewHolder> {
    private List<CoinMarket> list;
    private OnClickItem onClickItem;

    public void setOnClickItem(OnClickItem onClickItem) {
        this.onClickItem = onClickItem;
    }

    public List<CoinMarket> getList() {
        return list;
    }

    public RecyclerCoinAdapter(Context context, List<CoinMarket> list){
        this.list=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_coin_market, parent, false);
        final ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CoinMarket coinMarket=list.get(position);
        holder.coinRank.setText(coinMarket.cmc_rank+"");
        holder.coin_name.setText(coinMarket.symbol+" "+coinMarket.name);
        holder.coin_price.setText(coinMarket.quote.USD.price+"");
        holder.coin_market_cap.setText(coinMarket.quote.USD.market_cap+"");
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItem.onClik(coinMarket);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView coinRank,coin_name,coin_price,coin_market_cap;
        public LinearLayout linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            coinRank=itemView.findViewById(R.id.coin_rank);
            coin_name=itemView.findViewById(R.id.coin_name);
            coin_price=itemView.findViewById(R.id.coin_price);
            coin_market_cap=itemView.findViewById(R.id.coin_market_cap);
            linearLayout=itemView.findViewById(R.id.linearlItemCoin);

        }
    }

    public interface OnClickItem{
        public void onClik(CoinMarket item);
    }
}
