package com.example.db_rgr_server.data.network.converter;

import com.example.db_rgr_server.data.network.request.KeywordRequest;
import com.example.db_rgr_server.data.network.request.UnknownKeywordRequest;
import com.example.db_rgr_server.domain.model.Keyword;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

public class KeywordConverter {

    private final Gson gson;

    public KeywordConverter() {
        gson = new GsonBuilder().create();
    }

    public UnknownKeywordRequest convertUnknownKeywordFromJson(String source) {
        return gson.fromJson(source, UnknownKeywordRequest.class);
    }

    public KeywordRequest convertKeywordFromJson(String source) {
        return gson.fromJson(source, KeywordRequest.class);
    }

    public String convertToJson(List<Keyword> cities) {
        JsonArray jarray = gson.toJsonTree(cities).getAsJsonArray();
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("keywords", jarray);
        return jsonObject.toString();
    }
}
