package com.example.db_rgr_server.data.network.endpoint;

import com.example.db_rgr_server.data.database.converter.GoodDBConverter;
import com.example.db_rgr_server.data.network.converter.GoodConverter;
import com.example.db_rgr_server.data.network.converter.JsonParser;
import com.example.db_rgr_server.data.network.request.GoodRequest;
import com.example.db_rgr_server.data.repository.DBProtocol;
import com.example.db_rgr_server.domain.model.Good;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UpdateGoodEndpoint extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(200);
        String json = JsonParser.getInstance().parseRequest(request);
        GoodRequest goodRequest = new GoodConverter().convertGoodFromJson(json);
        Good good = new GoodDBConverter().fromNetwork(goodRequest);

        DBProtocol db = new DBProtocol();
        db.updateGood(good);
        System.out.println("Update good with id " + good.getId());

        PrintWriter out = response.getWriter();
        out.flush();
        out.close();
    }
}
