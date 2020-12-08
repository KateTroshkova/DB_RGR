package com.example.db_rgr_server.data.network.endpoint;

import com.example.db_rgr_server.data.network.converter.BondConverter;
import com.example.db_rgr_server.data.network.converter.JsonParser;
import com.example.db_rgr_server.data.network.request.BondRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddKeywordEndpoint extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(200);
        String json = JsonParser.getInstance().parseRequest(request);
        BondRequest bond = new BondConverter().convertFromJson(json);
        System.out.println("Bond " + bond.toString());
        PrintWriter out = response.getWriter();
        out.close();
        out.flush();
    }
}
