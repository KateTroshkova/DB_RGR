package com.example.db_rgr_server.servlet;

import com.example.db_rgr_server.converter.GoodConverter;
import com.example.db_rgr_server.model.Good;
import com.example.db_rgr_server.repository.GoodRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.io.IOException;
import java.util.List;

public class GetGoods extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(200);

        ServletOutputStream out = response.getOutputStream();
        List<Good> cities = new GoodRepository().getAllGoods();
        GoodConverter converter = new GoodConverter();
        String output = converter.convertToJson(cities);
        out.print(output);
        out.flush();
        out.close();
    }
}
