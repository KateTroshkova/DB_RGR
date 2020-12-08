package com.example.db_rgr_server.data.network.converter;

import com.example.db_rgr_server.data.network.request.KeywordRequest;
import com.example.db_rgr_server.data.network.request.UnknownKeywordRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
}
