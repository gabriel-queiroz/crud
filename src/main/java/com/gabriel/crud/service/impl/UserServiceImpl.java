package com.gabriel.crud.service.impl;

import com.gabriel.crud.model.UserModel;
import com.gabriel.crud.repository.UserRepository;
import com.gabriel.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service()
public class UserServiceImpl implements UserService {

    @Autowired()
    private UserRepository userRepository;


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
}
