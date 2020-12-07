package com.example.db_rgr_server.converter;

import com.example.db_rgr_server.model.Good;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.List;

public class GoodConverter {

    private final Gson gson;

    public GoodConverter() {

        gson = new GsonBuilder().create();
    }

    public String convertToJson(List<Good> cities) {
        JsonArray jarray = gson.toJsonTree(cities).getAsJsonArray();
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("goods", jarray);
        return jsonObject.toString();
    }

    public Good convertFromJson(String source) {
        return gson.fromJson(source, Good.class);
    }
}
