package com.example.demo.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@Getter
public class BlogAPIException extends RuntimeException{

    private HttpStatus status;
    private String message;

    public BlogAPIException(HttpStatus httpStatus, String message) {
        this.status = httpStatus;
        this.message = message;
    }

    public BlogAPIException(String message, HttpStatus httpStatus, String message1) {
        super(message);
        this.status = httpStatus;
        this.message = message1;
    }

}
