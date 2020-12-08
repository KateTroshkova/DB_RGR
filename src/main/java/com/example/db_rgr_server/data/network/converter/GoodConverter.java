package com.example.db_rgr_server.data.network.converter;

import com.example.db_rgr_server.data.network.request.UnknownGoodRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GoodConverter {

    private final Gson gson;

    public GoodConverter() {
        gson = new GsonBuilder().create();
    }

    public UnknownGoodRequest convertFromJson(String source) {
        return gson.fromJson(source, UnknownGoodRequest.class);
    }
}
