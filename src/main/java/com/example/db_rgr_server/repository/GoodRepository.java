package com.example.db_rgr_server.repository;

import com.example.db_rgr_server.api.GoodsApi;
import com.example.db_rgr_server.model.Good;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GoodRepository implements GoodsApi {
    @Override
    public List<Good> getAllGoods() {
        List<Good> goods = new ArrayList<>();
        HashSet<String> keywords = new HashSet<String>();
        keywords.add("Россия");
        goods.add(new Good("Matreshka", 42));
        goods.add(new Good("Veer", 43));
        goods.add(new Good("Magnit", 44));
        return goods;
    }

    @Override
    public void addGood(Good newGood) {

    }

    @Override
    public void updateGood(Good newGood) {

    }
}
