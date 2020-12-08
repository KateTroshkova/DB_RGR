package com.example.db_rgr_server.data.network.endpoint;

import com.example.db_rgr_server.data.database.converter.GoodDBConverter;
import com.example.db_rgr_server.data.database.converter.KeywordDBConverter;
import com.example.db_rgr_server.data.network.converter.JsonParser;
import com.example.db_rgr_server.data.network.converter.KeywordConverter;
import com.example.db_rgr_server.data.network.request.KeywordRequest;
import com.example.db_rgr_server.db.DBProtocol;
import com.example.db_rgr_server.model.Good;
import com.example.db_rgr_server.model.Keyword;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UpdateKeywordEndpoint extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(200);
        String json = JsonParser.getInstance().parseRequest(request);
        KeywordRequest goodRequest = new KeywordConverter().convertKeywordFromJson(json);
        Keyword good = new KeywordDBConverter().fromNetwork(goodRequest);

        DBProtocol db = new DBProtocol();
        db.updateKeyword(good);
        System.out.println("Update keyword with id " + good.getId());

        PrintWriter out = response.getWriter();
        out.flush();
        out.close();
    }
}
