package com.example.db_rgr_server.data.network.endpoint;

import com.example.db_rgr_server.data.database.converter.GoodDBConverter;
import com.example.db_rgr_server.data.network.converter.GoodConverter;
import com.example.db_rgr_server.data.network.converter.IdConverter;
import com.example.db_rgr_server.data.network.converter.JsonParser;
import com.example.db_rgr_server.data.network.request.UnknownGoodRequest;
import com.example.db_rgr_server.data.network.response.IdResponse;
import com.example.db_rgr_server.data.repository.DBProtocol;
import com.example.db_rgr_server.domain.model.Good;
import com.example.db_rgr_server.domain.model.Keyword;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateGoodEndpoint extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(200);
        String json = JsonParser.getInstance().parseRequest(request);
        UnknownGoodRequest goodRequest = new GoodConverter().convertUnknownGoodFromJson(json);
        Good good = new GoodDBConverter().fromNetwork(goodRequest);

        DBProtocol db = new DBProtocol();
        for (int keywordId:goodRequest.getKeywords()){
            Keyword keyword = db.loadBuId(keywordId);
            good.addKeyword(keyword);
        }
        db.saveGood(good);
        System.out.println("Save good with id " + good.getId());

        ServletOutputStream out = response.getOutputStream();
        IdConverter converter = new IdConverter();
        String output = converter.convertToJson(new IdResponse(good.getId()));
        out.print(output);
        out.flush();
        out.close();
    }
}
