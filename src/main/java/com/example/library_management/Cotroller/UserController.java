package com.example.library_management.Cotroller;


import com.example.library_management.Exception.UserNotFoundException;
import com.example.library_management.Model.User;
import com.example.library_management.Repository.UserRepository;
import com.example.library_management.Util.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class UserController {
  private final static Logger LOGGER =Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
  @Autowired
  private UserRepository repository;


@PostMapping ("/users")
@ResponseStatus(HttpStatus.CREATED )
User newUser(@RequestBody User newUser) throws Exception {

if (UserValidator.isValidUser(newUser))
     return repository.save(newUser) ;
else throw new Exception() ;
}


  @GetMapping("/getusers")
  List<User> findAll(){
    return repository.findAll();
  }

  @GetMapping("/users/{id}")
  User findOne(@PathVariable int id){
  LOGGER.info("/users/{id} called with id"+ id);

  return repository.findById(id)
          .orElseThrow(()-> new UserNotFoundException(id));
  }
}
