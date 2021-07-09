package com.gabriel.crud.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.util.Objects;

public class ComicItem {
    private String title;
    private String description;
    private String isbn;


    @JsonDeserialize(contentAs = Price.class)
    private ArrayList<Price> prices;

    private CreatorData creators;

    public ArrayList<Price> getPrices() {
        return prices;
    }

    public void setPrices(ArrayList<Price> prices) {
        this.prices = prices;
    }

    public CreatorData getCreators() {
        return creators;
    }

    public void setCreators(CreatorData creators) {
        this.creators = creators;
    }

    public ComicItem(String title, String description, String isbn) {
        this.title = title;
        this.description = description;
        this.isbn = isbn;
    }

    public ComicItem() {

    }

    @Override
    public String toString() {
        return "ComicItem{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComicItem comicItem = (ComicItem) o;
        return Objects.equals(title, comicItem.title) && Objects.equals(description, comicItem.description) && Objects.equals(isbn, comicItem.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, isbn);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
