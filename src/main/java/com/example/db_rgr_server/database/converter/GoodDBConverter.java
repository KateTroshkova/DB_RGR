package com.example.db_rgr_server.database.converter;

import com.example.db_rgr_server.network.request.GoodRequest;
import com.example.db_rgr_server.network.request.UnknownGoodRequest;
import com.example.db_rgr_server.network.response.GoodResponse;
import com.example.db_rgr_server.database.model.Good;
import com.example.db_rgr_server.database.model.Keyword;

public class GoodDBConverter {

    public Good fromNetwork(UnknownGoodRequest request) {
        return new Good(request.getName(), request.getPrice());
    }

    public Good fromNetwork(GoodRequest request) {
        return new Good(request.getId(), request.getName(), request.getPrice());
    }

    public GoodResponse toNetwork(Good good){
        KeywordDBConverter keywordConverter = new KeywordDBConverter();
        GoodResponse response = new GoodResponse(good.getId(), good.getName(), good.getPrice());
        for(Keyword keyword:good.getKeywords()){
            response.addKeyword(keywordConverter.toNetwork(keyword));
        }
        return response;
    }
}
