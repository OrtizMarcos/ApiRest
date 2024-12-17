package com.roshka.ApiRest.exception;

public class PostulanteNoEncontradoException extends RuntimeException {
    // Constructor que acepta el mensaje de error
    public PostulanteNoEncontradoException(String message) {
        super(message);
    }
}
