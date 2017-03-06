package com.keehoo.kree.restclientapproach;

/**
 * Created by k on 03.03.17.
 */

class Contact {

    public Contact(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}
