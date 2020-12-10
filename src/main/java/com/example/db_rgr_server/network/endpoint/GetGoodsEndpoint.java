package com.example.db_rgr_server.network.endpoint;

import com.example.db_rgr_server.database.converter.GoodDBConverter;
import com.example.db_rgr_server.network.converter.GoodConverter;
import com.example.db_rgr_server.network.response.GoodResponse;
import com.example.db_rgr_server.repository.Repository;
import com.example.db_rgr_server.database.model.Good;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetGoodsEndpoint extends BaseEndpoint {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Good> goods = Repository.getInstance().getGoods();
        List<GoodResponse> responses = new ArrayList<>();
        GoodConverter converter = new GoodConverter();
        GoodDBConverter dbConverter = new GoodDBConverter();
        for (Good good : goods) {
            responses.add(dbConverter.toNetwork(good));
        }
        String output = converter.convertToJson(responses);
        sendResponse(response, output);
    }
}
