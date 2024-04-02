package com.example.library_management.Exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(int id){
        super ("User is not found: "+id);
    }

}
