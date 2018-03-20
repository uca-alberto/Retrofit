package com.example.alber.appmartes;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.alber.appmartes.activity.MainSendMarket;
import com.example.alber.appmartes.activity.MainUpdateMarket;
import com.example.alber.appmartes.adapters.MarketAdapter;
import com.example.alber.appmartes.api.Api;
import com.example.alber.appmartes.models.MarketModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Button modificar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initViews();
        configureRecyclerView();
        getMarket();

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent = new Intent(MainActivity.this, MainUpdateMarket.class);
                startActivity(intent);
            }
        });
    }
    private void initViews() {
        recyclerView= findViewById(R.id.recycler);

    }
    /**
     * To configure the RecyclerView
     */
    private void configureRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    public void getMarket()
    {
        Call<List<MarketModel>> call = Api.instance().getMarkets();
        call.enqueue(new Callback<List<MarketModel>>() {
            @Override
            public void onResponse(Call<List<MarketModel>> call, Response<List<MarketModel>> response) {
                MarketAdapter marketAdapter = new MarketAdapter(response.body());
                recyclerView.setAdapter(marketAdapter);

            }

            @Override
            public void onFailure(Call<List<MarketModel>> call, Throwable t) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
