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
        goods.add(new Good(1L, "Matreshka", 42, keywords));
        goods.add(new Good(2L, "Veer", 43, keywords));
        goods.add(new Good(3L, "Magnit", 44, keywords));
        return goods;
    }

    @Override
    public void addGood(Good newGood) {

    }

    @Override
    public void updateGood(Good newGood) {

    }
}
