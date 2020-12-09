package com.example.db_rgr_server.data.database.converter;

import com.example.db_rgr_server.data.network.request.GoodRequest;
import com.example.db_rgr_server.data.network.request.UnknownGoodRequest;
import com.example.db_rgr_server.data.network.response.GoodResponse;
import com.example.db_rgr_server.domain.model.Good;
import com.example.db_rgr_server.domain.model.Keyword;

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
            System.out.println("!!!"+keyword+"!!!");
            response.addKeyword(keywordConverter.toNetwork(keyword));
        }
        return response;
    }
}
