package com.keehoo.kree.restclientapproach;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

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
                .setEndpoint("http://10.0.3.2:8080/api")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        RestClinetInterface restClinetInterface = restAdapter.create(RestClinetInterface.class);

        restClinetInterface.listContact(new Callback<RestClinetInterface.ContactResponse>() {

            @Override
            public void success(RestClinetInterface.ContactResponse contactResponse, Response response) {

                System.out.println("response" + response.getBody());
                System.out.println("reason: "+ response.getReason());
                System.out.println("additioanl: "+ response.toString());

                ContactAdapter contactAdapter = new ContactAdapter(MainActivity.this, contactResponse.getListOfContacts());
                recyclerView.setAdapter(contactAdapter);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("MainActivity", "response: "+error.getUrl()+"\n"+error.getMessage()+"\n"+error.getBody());
                Toast.makeText(MainActivity.this, "Blad", Toast.LENGTH_LONG).show();
            }
        });

    }
}
