package com.gabriel.crud.service;

import com.gabriel.crud.dto.CreateComicDTO;
import com.gabriel.crud.model.ComicModel;

import java.util.List;

public interface ComicService {
    ComicModel save(CreateComicDTO comic);
    List<ComicModel> getComics();
}
