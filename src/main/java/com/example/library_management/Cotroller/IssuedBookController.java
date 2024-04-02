package com.example.library_management.Cotroller;

import com.example.library_management.Model.IssuedBooks;
import com.example.library_management.Repository.IssuedBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class IssuedBookController {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
@Autowired
    IssuedBooksRepository repository;

@PostMapping("/issueBook")
@ResponseStatus(HttpStatus.CREATED )
public IssuedBooks issueBook(@RequestBody IssuedBooks issuedBooks) throws Exception {
    try{
//add validator here
       return repository.save(issuedBooks);

    }catch(Exception e){
        e.printStackTrace();
        throw new Exception();
    }
}

@GetMapping(value = "/issuedBooks")
    List<IssuedBooks> findAll(){
    //can add exception here
    return repository.findAll();
}

@GetMapping(value = "/searchIssuedBooksByUser")
    public List<IssuedBooks> searchIssuedBooksByUser(@RequestParam(value="q") String userId ){
    LOGGER.info("searchIssuedBooksByUser called with userId"+ userId);
    List<IssuedBooks > books= repository.findAll();
    ArrayList<IssuedBooks > list=new ArrayList<IssuedBooks>();
 for(IssuedBooks book:books){
     int id=Integer.parseInt(userId);

     if(book.getUser_id()==id){
         list.add(book);
     }
 }
return list;
}

}
