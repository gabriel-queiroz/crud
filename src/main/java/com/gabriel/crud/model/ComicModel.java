package com.gabriel.crud.model;

import com.gabriel.crud.dto.ComicItemDTO;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class ComicModel {

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private Long id;

    private String title;
    private String description;
    private String isbn;
    private double price;
    @OneToMany
    private List<CreatorModel> creators;
    @OneToOne
    private UserModel user;

    public ComicModel() {

    }

    public ComicModel toComicModel(ComicItemDTO comicItem){
        ComicModel comic = new ComicModel();
        comic.setCreators(comicItem.getCreators().getItems().stream().map(item -> {
            CreatorModel creatorModel = new CreatorModel();
            creatorModel.toCreator(item);
            return creatorModel;
        } ).collect(Collectors.toList()));
        comic.setIsbn(comic.getIsbn());
        comic.setDescription(comicItem.getDescription());
        comic.setTitle(comicItem.getTitle());
        comic.setPrice(comicItem.getPrices().get(1).getPrice());
        return comic;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<CreatorModel> getCreators() {
        return creators;
    }

    public void setCreators(List<CreatorModel> creators) {
        this.creators = creators;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ComicModel(Long id, String title, String description, String isbn, double price, List<CreatorModel> creators) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.isbn = isbn;
        this.price = price;
        this.creators = creators;
    }



}
