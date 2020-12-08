package com.example.db_rgr_server.servlet;

import com.example.db_rgr_server.converter.GoodConverter;
import com.example.db_rgr_server.db.DBProtocol;
import com.example.db_rgr_server.model.Good;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class AddGood extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setHeader("Access-Control-Allow-Origin", "*");
        //response.setHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS,PUT,DELETE");
        //response.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
        response.setContentType("text/plain");
        response.setStatus(204);
        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line);
        } catch (Exception e) { /*report an error*/ }
        Good good = new GoodConverter().convertFromJson(jb.toString());
        DBProtocol db = new DBProtocol();
        db.connect();
        db.saveGood(good);
        System.out.println("Get good with id" + good.getId());
        PrintWriter out = response.getWriter();
        out.close();
        out.flush();
    }
}
