package com.example.db_rgr_server.data.database.converter;

import com.example.db_rgr_server.data.network.request.KeywordRequest;
import com.example.db_rgr_server.data.network.request.UnknownKeywordRequest;
import com.example.db_rgr_server.data.network.response.KeywordResponse;
import com.example.db_rgr_server.domain.model.Keyword;

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
