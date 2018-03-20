package com.example.alber.appmartes.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.alber.appmartes.R;
import com.example.alber.appmartes.models.MarketModel;

import java.util.List;

/**
 * Created by alber on 19/3/2018.
 */

public class MarketAdapter extends RecyclerView.Adapter<MarketAdapter.ViewHolder> {

    private List<MarketModel> marketModels;

    public MarketAdapter(List<MarketModel>marketModels)
    {
        this.marketModels=marketModels;
    }
    @Override
    public MarketAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MarketAdapter.ViewHolder holder, int position) {

        MarketModel marketModel = marketModels.get(position);
//        holder.id.setText(marketModel.getId());
        holder.name.setText(marketModel.getName());
        holder.address.setText(marketModel.getAddress());
        holder.ubication.setText(marketModel.getUbication());

    }

    @Override
    public int getItemCount() {
        return marketModels.size();
    }

   public class ViewHolder extends RecyclerView.ViewHolder
   {
       TextView id;
       TextView name;
       TextView address;
       TextView ubication;
       //Button modificar;
       public ViewHolder(View intemView)
       {
           super(intemView);
           name = intemView.findViewById(R.id.EdiName);
           address = intemView.findViewById(R.id.EdiAdrress);
           ubication = intemView.findViewById(R.id.Ubication);
           //modificar = intemView.findViewById(R.id.Update);
       }
   }
}
