package com.example.db_rgr_server.servlet;

import com.example.db_rgr_server.converter.GoodConverter;
import com.example.db_rgr_server.model.Good;
import com.example.db_rgr_server.repository.GoodRepository;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class GetGoods extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS,PUT,DELETE");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
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
