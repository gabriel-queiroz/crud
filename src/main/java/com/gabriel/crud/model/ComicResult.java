package com.gabriel.crud.model;

public class ComicResult {
    private ComicData data;
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public ComicResult(ComicData data) {
        this.data = data;
    }

    public ComicResult() {
    }

    @Override
    public String toString() {
        return "ComicResult{" +
                "data=" + data.toString() +
                '}';
    }

    public ComicData getData() {
        return data;
    }

    public void setData(ComicData data) {
        this.data = data;
    }
}
