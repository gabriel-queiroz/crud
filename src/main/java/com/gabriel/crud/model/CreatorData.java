package com.gabriel.crud.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;
import java.util.Objects;

public class CreatorData {

    @JsonDeserialize(contentAs = CreatorItem.class)
    private List<CreatorItem> items;

    public List<CreatorItem> getItems() {
        return items;
    }

    public void setItems(List<CreatorItem> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreatorData that = (CreatorData) o;
        return Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }
}
