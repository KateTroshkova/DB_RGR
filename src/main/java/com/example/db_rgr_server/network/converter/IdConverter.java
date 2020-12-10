package com.example.db_rgr_server.network.converter;

import com.example.db_rgr_server.network.response.IdResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class IdConverter {

    private final Gson gson;

    public IdConverter() {
        gson = new GsonBuilder().create();
    }

    public String convertToJson(IdResponse response) {
        return gson.toJson(response);
    }
}
