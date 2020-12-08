package com.example.db_rgr_server.data.network.endpoint;

import com.example.db_rgr_server.data.network.converter.GoodConverter;
import com.example.db_rgr_server.data.network.converter.KeywordConverter;
import com.example.db_rgr_server.db.DBProtocol;
import com.example.db_rgr_server.model.Good;
import com.example.db_rgr_server.model.Keyword;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetKeywordsEndpoint extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(200);

        ServletOutputStream out = response.getOutputStream();
        List<Keyword> cities = new DBProtocol().loadAllkeywords();
        KeywordConverter converter = new KeywordConverter();
        String output = converter.convertToJson(cities);
        out.print(output);
        out.flush();
        out.close();
    }
}