package com.example.db_rgr_server.network.endpoint;

import com.example.db_rgr_server.database.converter.KeywordDBConverter;
import com.example.db_rgr_server.network.converter.KeywordConverter;
import com.example.db_rgr_server.network.response.KeywordResponse;
import com.example.db_rgr_server.repository.Repository;
import com.example.db_rgr_server.database.model.Keyword;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetKeywordsEndpoint extends BaseEndpoint {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Keyword> keywords = Repository.getInstance().getKeywords();
        List<KeywordResponse> responses = new ArrayList<>();
        KeywordConverter converter = new KeywordConverter();
        KeywordDBConverter dbConverter = new KeywordDBConverter();
        for(Keyword good:keywords){
            responses.add(dbConverter.toNetwork(good));
        }
        String output = converter.convertToJson(responses);
        sendResponse(response, output);
    }
}