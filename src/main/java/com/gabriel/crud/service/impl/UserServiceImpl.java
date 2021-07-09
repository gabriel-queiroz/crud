package com.gabriel.crud.service.impl;

import com.gabriel.crud.http.ComicHttp;
import com.gabriel.crud.dto.ComicResultDTO;
import com.gabriel.crud.model.UserModel;
import com.gabriel.crud.repository.UserRepository;
import com.gabriel.crud.service.UserService;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service()
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ComicHttp comicHttp;


    @Override
    public List<UserModel> getUsers() {
        List<UserModel> users = new ArrayList<>();
        this.userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public UserModel getUserById(Long id) {
        return this.userRepository.findById(id).get();
    }

    @Override
    public UserModel insert(UserModel user) {
        return this.userRepository.save(user);
    }

    @Override
    public void updateUser(Long id, UserModel user) {
        UserModel userFromDb = this.userRepository.findById(id).get();
        userFromDb.setBirthDate(user.getBirthDate());
        userFromDb.setDocument(user.getDocument());
        userFromDb.setName(user.getName());
        userFromDb.setEmail(user.getEmail());
        this.userRepository.save(userFromDb);
    }

    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }

    public void getComic() {
        try {
            Optional<ComicResultDTO> comic = Optional.ofNullable(this.comicHttp.getComicItemDetails());
            if(comic.isPresent()){
                System.out.println(comic.get().getData().getResults().get(0).getPrices().get(0).getPrice());
            }
        } catch (FeignException e) {
            System.out.println(e.getMessage());
        }
    }
}
