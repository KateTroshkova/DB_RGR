package com.example.db_rgr_server.data.network.request;

import java.util.Objects;

public class UnknownGoodRequest {

    private String name;
    private float price;
    private int[] keywords;

    public UnknownGoodRequest(String name, float price, int[] keywords) {
        this.name = name;
        this.price = price;
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

    public int[] getKeywords() {
        return keywords;
    }

    public void setKeywords(int[] keywords) {
        this.keywords = keywords;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnknownGoodRequest that = (UnknownGoodRequest) o;
        return Float.compare(that.price, price) == 0 && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "GoodRequest{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
