package com.example.db_rgr_server.domain.repository;

import com.example.db_rgr_server.domain.model.Good;

import java.util.List;

public interface GoodsApi {

    List<Good> getAllGoods();

    void addGood(Good newGood);

    void updateGood(Good newGood);
}
