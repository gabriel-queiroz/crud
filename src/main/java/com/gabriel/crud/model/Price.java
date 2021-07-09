package com.gabriel.crud.model;

import java.util.Objects;

public class Price {
    private Double price;
    private String type;


    public Price() {
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price1 = (Price) o;
        return Objects.equals(price, price1.price) && Objects.equals(type, price1.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, type);
    }
}
