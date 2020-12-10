package com.example.db_rgr_server.network.endpoint;

import com.example.db_rgr_server.network.converter.IdConverter;
import com.example.db_rgr_server.network.response.IdResponse;
import com.example.db_rgr_server.repository.Repository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoveGoodEndpoint extends BaseEndpoint {

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Repository.getInstance().removeGood(id);
        IdConverter converter = new IdConverter();
        String output = converter.convertToJson(new IdResponse(id));
        sendResponse(response, output);
    }
}
