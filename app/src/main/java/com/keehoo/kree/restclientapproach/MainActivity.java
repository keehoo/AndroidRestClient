package com.keehoo.kree.restclientapproach;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RestClinetInterface restClientImpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpInitialRecyclerView();
    }

    @Override
    protected void onResume() {
        super.onResume();

        restClientImpl = RestClinetInterface.retrofit.create(RestClinetInterface.class);
        Call<List<Contact>> getContacts = restClientImpl.listContact();
        getContacts.enqueue(new Callback<List<Contact>>() {
            @Override
            public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
                List<Contact> contacts = response.body();
                ContactAdapter adapter = new ContactAdapter(MainActivity.this, contacts);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Contact>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Unfortunately there's a failure with your call: "+call.toString()+"\n the excpetion detail bewlow : \n"+
                        t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setUpInitialRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
