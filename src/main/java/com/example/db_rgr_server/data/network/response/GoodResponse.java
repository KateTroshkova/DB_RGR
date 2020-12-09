package com.example.db_rgr_server.data.network.response;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GoodResponse {

    private int id;
    private String name;
    private float price;
    List<KeywordResponse> keywords = new ArrayList<>();

    public GoodResponse(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void addKeyword(KeywordResponse keyword){
        keywords.add(keyword);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodResponse good = (GoodResponse) o;
        return id == good.id && price == good.price && name.equals(good.name);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.price);
        return hash;
    }
}
