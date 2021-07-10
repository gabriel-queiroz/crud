package com.gabriel.crud.service.impl;

import com.gabriel.crud.dto.ComicResultDTO;
import com.gabriel.crud.dto.CreateComicDTO;
import com.gabriel.crud.exception.ComicNotFoundException;
import com.gabriel.crud.http.ComicHttp;
import com.gabriel.crud.model.ComicModel;
import com.gabriel.crud.model.UserModel;
import com.gabriel.crud.repository.ComicRepository;
import com.gabriel.crud.service.ComicService;
import com.gabriel.crud.service.UserService;
import com.sun.istack.Nullable;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletionException;

@Service
public class ComicServiceImpl implements ComicService {


    @Autowired
    ComicRepository comicRepository;

    @Autowired
    private ComicHttp comicHttp;

    @Autowired
    private UserService userService;

    @Override
    public ComicModel save(CreateComicDTO createComicDTO) {
        try {
            UserModel user = this.userService.getUserById(createComicDTO.getUserId());
            Optional<ComicResultDTO> comic = Optional.ofNullable(this.comicHttp.getComicItemDetails(createComicDTO.getComicId()));
            if (comic.isEmpty()) {
                throw new ComicNotFoundException(createComicDTO.getComicId());
            }
            ComicModel comicModel = new ComicModel();
            comicModel.toComicModel(comic.get().getData().getResults().get(0));
            comicModel.setUser(user);
            return this.comicRepository.save(comicModel);

        } catch (FeignException e) {
            throw new ComicNotFoundException(createComicDTO.getComicId());
        }
    }

    @Override
    public List<ComicModel> getComics() {
        List<ComicModel> users = new ArrayList<>();
        this.comicRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public ComicModel getById(Long id) {
       Optional<ComicModel> comic = Optional.ofNullable(this.comicRepository.getById(id));
       if(comic.isEmpty()){
           throw new ComicNotFoundException(id);
       }
       return comic.get();
    }
}
