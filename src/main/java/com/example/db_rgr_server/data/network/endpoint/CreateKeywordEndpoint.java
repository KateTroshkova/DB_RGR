package com.example.db_rgr_server.data.network.endpoint;

import com.example.db_rgr_server.data.database.converter.KeywordDBConverter;
import com.example.db_rgr_server.data.network.converter.IdConverter;
import com.example.db_rgr_server.data.network.converter.JsonParser;
import com.example.db_rgr_server.data.network.converter.KeywordConverter;
import com.example.db_rgr_server.data.network.request.UnknownKeywordRequest;
import com.example.db_rgr_server.data.network.response.IdResponse;
import com.example.db_rgr_server.data.repository.DBProtocol;
import com.example.db_rgr_server.domain.model.Keyword;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateKeywordEndpoint extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(200);
        String json = JsonParser.getInstance().parseRequest(request);
        UnknownKeywordRequest goodRequest = new KeywordConverter().convertUnknownKeywordFromJson(json);
        Keyword good = new KeywordDBConverter().fromNetwork(goodRequest);

        DBProtocol db = new DBProtocol();
        db.saveKeyword(good);
        System.out.println("Save keyword with id " + good.getId());

        ServletOutputStream out = response.getOutputStream();
        IdConverter converter = new IdConverter();
        String output = converter.convertToJson(new IdResponse(good.getId()));
        out.print(output);
        out.flush();
        out.close();
    }
}
