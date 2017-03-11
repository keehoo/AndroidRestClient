package com.keehoo.kree.restclientapproach;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;



public interface RestClinetInterface {

    @GET("contacts")
    Call<List<Contact>> listContact();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.0.3.2:8080/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
