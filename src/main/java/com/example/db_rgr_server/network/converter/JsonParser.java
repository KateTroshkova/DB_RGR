package com.example.db_rgr_server.network.converter;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;

public class JsonParser {

    private static JsonParser instance;

    public static JsonParser getInstance() {
        if (instance == null) {
            instance = new JsonParser();
        }
        return instance;
    }

    private JsonParser() {
    }

    public String parseRequest(HttpServletRequest request) {
        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line);
        } catch (Exception ignored) {
        }
        return jb.toString();
    }
}
