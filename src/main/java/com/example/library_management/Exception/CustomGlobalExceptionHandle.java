package com.example.library_management.Exception;


import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class CustomGlobalExceptionHandle extends ResponseEntityExceptionHandler  {

    @ExceptionHandler(UserNotFoundException.class)
    public void springHandleNotFound(HttpServletResponse response ) throws IOException {

        response.sendError(HttpStatus .NOT_FOUND.value());
    }


    @ExceptionHandler(BookNotFoundException.class)
    public void springHandleNotFound2(HttpServletResponse response ) throws IOException {

        response.sendError(HttpStatus .NOT_FOUND.value());
    }


}
