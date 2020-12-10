package com.example.db_rgr_server.network.endpoint;

import com.example.db_rgr_server.database.converter.KeywordDBConverter;
import com.example.db_rgr_server.network.converter.JsonParser;
import com.example.db_rgr_server.network.converter.KeywordConverter;
import com.example.db_rgr_server.network.request.KeywordRequest;
import com.example.db_rgr_server.repository.Repository;
import com.example.db_rgr_server.database.model.Keyword;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateKeywordEndpoint extends BaseEndpoint {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String json = JsonParser.getInstance().parseRequest(request);
        KeywordRequest goodRequest = new KeywordConverter().convertKeywordFromJson(json);
        Keyword keyword = new KeywordDBConverter().fromNetwork(goodRequest);
        Repository.getInstance().updateKeyword(keyword);
        sendEmptyResponse(response);
    }
}
