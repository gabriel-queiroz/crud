package com.gabriel.crud.service.impl;

import com.gabriel.crud.dto.ComicResultDTO;
import com.gabriel.crud.dto.CreateComicDTO;
import com.gabriel.crud.http.ComicHttp;
import com.gabriel.crud.model.ComicModel;
import com.gabriel.crud.model.UserModel;
import com.gabriel.crud.repository.ComicRepository;
import com.gabriel.crud.service.ComicService;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ComicServiceImpl implements ComicService {


    @Autowired
    ComicRepository comicRepository;

    @Autowired
    private ComicHttp comicHttp;

    @Override
    public ComicModel save(CreateComicDTO createComicDTO) {
        try {
            Optional<ComicResultDTO> comic = Optional.ofNullable(this.comicHttp.getComicItemDetails(createComicDTO.getComicId()));
            if (comic.isPresent()) {
                System.out.println(comic.get().getData().getResults().get(0).getPrices().get(0).getPrice());
                ComicModel comicModel = new ComicModel();
                comicModel.toComicModel(comic.get().getData().getResults().get(0));
                return this.comicRepository.save(comicModel);
            }
        } catch (FeignException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<ComicModel> getComics() {
        List<ComicModel> users = new ArrayList<>();
        this.comicRepository.findAll().forEach(users::add);
        return users;
    }
}
