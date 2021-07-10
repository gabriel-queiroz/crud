package com.gabriel.crud.service.impl;

import com.gabriel.crud.exception.UserNotFoundException;
import com.gabriel.crud.http.ComicHttp;
import com.gabriel.crud.model.UserModel;
import com.gabriel.crud.repository.UserRepository;
import com.gabriel.crud.service.UserService;
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
      Optional<UserModel> user =  this.userRepository.findById(id);
       if(user.isEmpty()){
           throw new UserNotFoundException(id);
       }
      return user.get();
    }

    @Override
    public UserModel insert(UserModel user) {
        return this.userRepository.save(user);
    }

    @Override
    public boolean updateUser(Long id, UserModel user) {
        Optional<UserModel> userModelOptional = this.userRepository.findById(id);
        if (userModelOptional.isEmpty()) {
            throw new UserNotFoundException(id);
        }
        UserModel userFromDb = userModelOptional.get();
        userFromDb.setBirthDate(user.getBirthDate());
        userFromDb.setDocument(user.getDocument());
        userFromDb.setName(user.getName());
        userFromDb.setEmail(user.getEmail());
        this.userRepository.save(userFromDb);
        return true;

    }

    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }
}
