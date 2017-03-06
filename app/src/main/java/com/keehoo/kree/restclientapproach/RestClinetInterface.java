package com.keehoo.kree.restclientapproach;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by k on 06.03.17.
 */

public interface RestClinetInterface {


    @GET("/contacts")
    public void listContact(Callback<ContactListCallback> callback);

    @POST("/contact")
    public void addContact(@Body Contact contact, Callback<Void> callback,)

    class ContactListCallback {

        public List<Contact> getListOfContacts() {
            return listOfContacts;
        }

        public void setListOfContacts(List<Contact> listOfContacts) {
            this.listOfContacts = listOfContacts;
        }

        private List<Contact> listOfContacts;


    }
}
