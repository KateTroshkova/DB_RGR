package com.example.db_rgr_server.network.converter;

import com.example.db_rgr_server.network.request.BondRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BondConverter {

    private final Gson gson;

    public BondConverter() {
        gson = new GsonBuilder().create();
    }

    public BondRequest convertFromJson(String source) {
        return gson.fromJson(source, BondRequest.class);
    }
}
