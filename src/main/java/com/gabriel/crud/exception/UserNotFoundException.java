package com.gabriel.crud.exception;

public class UserNotFoundException extends EntityNotFoundException {

    public UserNotFoundException(Long userId) {
        super("User with id: "+ userId + " Not found");
    }
}
