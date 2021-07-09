package com.gabriel.crud.model;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ComicData {
    @JsonDeserialize(contentAs=ComicItem.class)
    private ArrayList<ComicItem> results;
    private Integer offset;

    public ArrayList<ComicItem> getResults() {
        return results;
    }

    public void setResults(ArrayList<ComicItem> results) {
        this.results = results;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public ArrayList<ComicItem> getResult() {
        return results;
    }

    public void setResult(ArrayList<ComicItem> result) {
        this.results = result;
    }

    public ComicData(ArrayList<ComicItem> results) {
        this.results = results;
    }

    public ComicData() {
    }

    @Override
    public String toString() {
        System.out.println(this.results);
        Optional<List<ComicItem>> list = Optional.ofNullable(this.results);
        String nome = "Gabriel";
        return nome;
    }
}
