package com.example.db_rgr_server.network.endpoint;

import com.example.db_rgr_server.database.converter.KeywordDBConverter;
import com.example.db_rgr_server.network.converter.IdConverter;
import com.example.db_rgr_server.network.converter.JsonParser;
import com.example.db_rgr_server.network.converter.KeywordConverter;
import com.example.db_rgr_server.network.request.UnknownKeywordRequest;
import com.example.db_rgr_server.network.response.IdResponse;
import com.example.db_rgr_server.repository.Repository;
import com.example.db_rgr_server.database.model.Keyword;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateKeywordEndpoint extends BaseEndpoint {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String json = JsonParser.getInstance().parseRequest(request);
        UnknownKeywordRequest keywordRequest = new KeywordConverter().convertUnknownKeywordFromJson(json);
        Keyword keyword = new KeywordDBConverter().fromNetwork(keywordRequest);
        Repository.getInstance().createKeyword(keyword);
        IdConverter converter = new IdConverter();
        String output = converter.convertToJson(new IdResponse(keyword.getId()));
        sendResponse(response, output);
    }
}
