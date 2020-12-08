package com.example.db_rgr_server.data.database.converter;

import com.example.db_rgr_server.data.network.request.GoodRequest;
import com.example.db_rgr_server.data.network.request.UnknownGoodRequest;
import com.example.db_rgr_server.domain.model.Good;

public class GoodDBConverter {

    public Good fromNetwork(UnknownGoodRequest request) {
        return new Good(request.getName(), request.getPrice());
    }

    public Good fromNetwork(GoodRequest request) {
        return new Good(request.getId(), request.getName(), request.getPrice());
    }
}
