package com.example.db_rgr_server.data.network.endpoint;

import com.example.db_rgr_server.data.network.converter.GoodConverter;
import com.example.db_rgr_server.data.repository.DBProtocol;
import com.example.db_rgr_server.domain.model.Good;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetGoodsEndpoint extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(200);

        ServletOutputStream out = response.getOutputStream();
        List<Good> cities = new DBProtocol().loadAllGoods();
        GoodConverter converter = new GoodConverter();
        String output = converter.convertToJson(cities);
        out.print(output);
        out.flush();
        out.close();
    }
}
