package com.example.db_rgr_server.network.endpoint;

import com.example.db_rgr_server.database.converter.GoodDBConverter;
import com.example.db_rgr_server.network.converter.GoodConverter;
import com.example.db_rgr_server.network.converter.JsonParser;
import com.example.db_rgr_server.network.request.GoodRequest;
import com.example.db_rgr_server.repository.Repository;
import com.example.db_rgr_server.database.model.Good;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateGoodEndpoint extends BaseEndpoint {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String json = JsonParser.getInstance().parseRequest(request);
        GoodRequest goodRequest = new GoodConverter().convertGoodFromJson(json);
        Good good = new GoodDBConverter().fromNetwork(goodRequest);
        Repository.getInstance().updateGood(good, goodRequest.getKeywords());
        sendEmptyResponse(response);
    }
}
