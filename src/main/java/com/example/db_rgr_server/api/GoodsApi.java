package com.example.db_rgr_server.api;

import com.example.db_rgr_server.model.Good;

import java.util.List;

public interface GoodsApi {

    List<Good> getAllGoods();

    void addGood(Good newGood);

    void updateGood(Good newGood);
}
