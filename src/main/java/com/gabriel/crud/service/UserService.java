package com.gabriel.crud.service;

import com.gabriel.crud.model.UserModel;

import java.util.List;

public interface UserService {

    List<UserModel> getUsers();

    UserModel getUserById(Long id);

    UserModel insert(UserModel user);

    boolean updateUser(Long id, UserModel user);

    void deleteUser(Long userId);
}
