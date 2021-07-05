package com.gabriel.crud.controller;

import com.gabriel.crud.model.UserModel;
import com.gabriel.crud.service.UserService;
import com.gabriel.crud.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired()
    private UserServiceImpl userService;


    @GetMapping
    public ResponseEntity<List<UserModel>> getAll() {
        return new ResponseEntity<>(this.userService.getUsers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserModel> save(@Valid @RequestBody UserModel user) {
        UserModel newUser = this.userService.insert(user);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    @PutMapping({"/{userId}"})
    public ResponseEntity<UserModel> update(@PathVariable("userId") Long userId, @RequestBody UserModel user) {
        this.userService.updateUser(userId, user);
        UserModel userUpdated = this.userService.getUserById(userId);
        return new ResponseEntity<>(userUpdated, HttpStatus.OK);
    }

    @DeleteMapping({"/{userId}"})
    public ResponseEntity<UserModel> delete(@PathVariable("userId")Long userId){
        this.userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
