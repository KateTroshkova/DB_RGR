package com.example.db_rgr_server.database.converter;

import com.example.db_rgr_server.network.request.KeywordRequest;
import com.example.db_rgr_server.network.request.UnknownKeywordRequest;
import com.example.db_rgr_server.network.response.KeywordResponse;
import com.example.db_rgr_server.database.model.Keyword;

public class KeywordDBConverter {

    public Keyword fromNetwork(UnknownKeywordRequest request) {
        return new Keyword(request.getKey(), request.getValue());
    }

    public Keyword fromNetwork(KeywordRequest request) {
        return new Keyword(request.getId(), request.getKey(), request.getValue());
    }

    public KeywordResponse toNetwork(Keyword keyword){
        return new KeywordResponse(keyword.getId(), keyword.getKey(), keyword.getValue());
    }
}
