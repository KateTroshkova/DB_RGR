package com.example.db_rgr_server;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class WelcomeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>РПБД РГР</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Выполнили: Берсенев Е.Б., Трошкова Е.Л.</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
