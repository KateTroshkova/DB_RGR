package com.example.db_rgr_server.data.database.converter;

import com.example.db_rgr_server.data.network.request.UnknownGoodRequest;
import com.example.db_rgr_server.model.Good;

public class GoodDBConverter {

    public Good fromNetwork(UnknownGoodRequest request){
        return new Good(request.getName(), request.getPrice());
    }
}
