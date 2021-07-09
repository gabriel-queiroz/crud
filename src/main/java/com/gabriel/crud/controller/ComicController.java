package com.gabriel.crud.controller;

import com.gabriel.crud.dto.CreateComicDTO;
import com.gabriel.crud.model.ComicModel;
import com.gabriel.crud.service.impl.ComicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/comics")
public class ComicController {


    @Autowired
    private ComicServiceImpl comicService;

    @PostMapping
    public ResponseEntity<ComicModel> save(@Valid @RequestBody CreateComicDTO comic){
        ComicModel comicModel =  this.comicService.save(comic);
        return new ResponseEntity<>(comicModel, HttpStatus.OK);
    }
}
