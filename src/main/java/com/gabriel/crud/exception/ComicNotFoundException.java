package com.gabriel.crud.exception;

public class ComicNotFoundException extends EntityNotFoundException {

    public ComicNotFoundException(Long comicId) {
        super("Comic with comicId: "+ comicId + " Not found");
    }

    public ComicNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
