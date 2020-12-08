package com.example.db_rgr_server.data.network.endpoint;

import com.example.db_rgr_server.data.network.converter.IdConverter;
import com.example.db_rgr_server.data.network.response.IdResponse;
import com.example.db_rgr_server.db.DBProtocol;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoveKeywordEndpoint extends HttpServlet {

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(200);

        int id = Integer.parseInt(request.getParameter("id"));
        DBProtocol db = new DBProtocol();
        id = db.deleteKeyword(id);
        System.out.println("Delete keyword with id " + id);

        ServletOutputStream out = response.getOutputStream();
        IdConverter converter = new IdConverter();
        String output = converter.convertToJson(new IdResponse(id));
        out.print(output);
        out.flush();
        out.close();
    }
}
