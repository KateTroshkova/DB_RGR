package com.example.db_rgr_server.network.request;

import java.util.Objects;

public class BondRequest {

    private int goodId;

    private int keywordId;

    public BondRequest(int goodId, int keywordId) {
        this.goodId = goodId;
        this.keywordId = keywordId;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public int getKeywordId() {
        return keywordId;
    }

    public void setKeywordId(int keywordId) {
        this.keywordId = keywordId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BondRequest bond = (BondRequest) o;
        return goodId == bond.goodId && keywordId == bond.keywordId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodId, keywordId);
    }

    @Override
    public String toString() {
        return "BondRequest{" +
                "goodId=" + goodId +
                ", keywordId=" + keywordId +
                '}';
    }
}
