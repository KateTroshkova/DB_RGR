package com.example.db_rgr_server.network.converter;

import com.example.db_rgr_server.network.request.GoodRequest;
import com.example.db_rgr_server.network.request.UnknownGoodRequest;
import com.example.db_rgr_server.network.response.GoodResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

public class GoodConverter {

    private final Gson gson;

    public GoodConverter() {
        gson = new GsonBuilder().create();
    }

    public UnknownGoodRequest convertUnknownGoodFromJson(String source) {
        return gson.fromJson(source, UnknownGoodRequest.class);
    }

    public GoodRequest convertGoodFromJson(String source) {
        return gson.fromJson(source, GoodRequest.class);
    }

    public String convertToJson(List<GoodResponse> cities) {
        JsonArray jarray = gson.toJsonTree(cities).getAsJsonArray();
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("goods", jarray);
        return jsonObject.toString();
    }
}
