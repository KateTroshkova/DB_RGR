package com.example.db_rgr_server.network.endpoint;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BaseEndpoint extends HttpServlet {

    protected void sendEmptyResponse(HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(200);
        PrintWriter out = response.getWriter();
        out.flush();
        out.close();
    }

    protected void sendResponse(HttpServletResponse response, String json)throws ServletException, IOException{
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(200);
        ServletOutputStream out = response.getOutputStream();
        out.print(json);
        out.flush();
        out.close();
    }
}
