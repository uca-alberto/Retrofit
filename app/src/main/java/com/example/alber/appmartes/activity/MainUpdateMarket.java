package com.example.alber.appmartes.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.example.alber.appmartes.MainActivity;
import com.example.alber.appmartes.R;
import com.example.alber.appmartes.api.Api;
import com.example.alber.appmartes.models.MarketModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainUpdateMarket extends AppCompatActivity {
    EditText name;
    EditText address;
    EditText ubication;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_update_market);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        name = findViewById(R.id.EditNamer);
        address = findViewById(R.id.EditAdrress);
        ubication = findViewById(R.id.Editubication);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                //UpdateMarket();
                deleteMarket();
                Intent intent = new Intent(MainUpdateMarket.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void UpdateMarket()
    {
        String id="1";

        MarketModel marketModel = new MarketModel();
        marketModel.setName(name.getText().toString());
        marketModel.setAddress(address.getText().toString());
        marketModel.setUbication(ubication.getText().toString());

        Call<MarketModel> call = Api.instance().update(id,marketModel);
        call.enqueue(new Callback<MarketModel>() {
            @Override
            public void onResponse(retrofit2.Call<MarketModel> call, Response<MarketModel> response) {

            }

            @Override
            public void onFailure(retrofit2.Call<MarketModel> call, Throwable t) {

            }
        });
    }
    public  void deleteMarket()
    {

        String id="1";
        Call<MarketModel> call = Api.instance().deleteMarket(id);
        call.enqueue(new Callback<MarketModel>() {
            @Override
            public void onResponse(Call<MarketModel> call, Response<MarketModel> response) {

            }

            @Override
            public void onFailure(Call<MarketModel> call, Throwable t) {

            }
        });

    }

}
