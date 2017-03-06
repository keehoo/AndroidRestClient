package com.keehoo.kree.restclientapproach;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://localhost:8080/api/contacts")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        RestClinetInterface restClinetInterface = restAdapter.create(RestClinetInterface.class);

        restClinetInterface.listContact(new Callback<RestClinetInterface.ContactListCallback>() {
            @Override
            public void success(RestClinetInterface.ContactListCallback contactListCallback, Response response) {
                ContactAdapter contactAdapter = new ContactAdapter(MainActivity.this, )
                        //TODO: continue with the code... :(
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });

    }
}
