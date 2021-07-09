package com.gabriel.crud.dto;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ComicDataDTO {

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonDeserialize(contentAs= ComicItemDTO.class)
    private ArrayList<ComicItemDTO> results;
    private Integer offset;

    public ArrayList<ComicItemDTO> getResults() {
        return results;
    }

    public void setResults(ArrayList<ComicItemDTO> results) {
        this.results = results;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public ArrayList<ComicItemDTO> getResult() {
        return results;
    }

    public void setResult(ArrayList<ComicItemDTO> result) {
        this.results = result;
    }

    public ComicDataDTO(ArrayList<ComicItemDTO> results) {
        this.results = results;
    }

    public ComicDataDTO() {
    }

    @Override
    public String toString() {
        System.out.println(this.results);
        Optional<List<ComicItemDTO>> list = Optional.ofNullable(this.results);
        String nome = "Gabriel";
        return nome;
    }
}
