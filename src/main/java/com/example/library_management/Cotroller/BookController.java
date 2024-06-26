package com.example.library_management.Cotroller;
import com.example.library_management.Exception.BookNotFoundException;
import com.example.library_management.Model.Book;
import com.example.library_management.Repository.BookRepository;
import com.example.library_management.Util.BookValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.xml.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class BookController {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    BookValidator validator = new BookValidator();

    @Autowired
    private BookRepository repository;

    @Autowired
    BookRepository bookRepository;


    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    Book newBook(@RequestBody Book newBook){
        if(validator.isValid(newBook)){
             return repository.save(newBook);
        }
        else{
            LOGGER.severe("newBook is not valid");
            return null;
        }
    }

    @GetMapping("/books")
    List<Book> findAll(){
        LOGGER.info("get all books called");
        List<Book> list= new ArrayList<>();
        try{

            list=repository.findAll();
            if(list.size()==0){

                LOGGER.severe("Books not found");
                throw new BookNotFoundException(5);
            }
        }catch(BookNotFoundException exc){
            LOGGER.severe(exc.toString());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Book Found", exc);

        }
        return list;
    }



    @GetMapping(value = "/searchBooksByAuthor")
    public List<Book> searchBooksByAuthor(@RequestParam(value = "q") String author){
        List<Book> books = bookRepository.findAll();
        ArrayList<Book> list = new ArrayList<Book>();
        for(Book book : books){
            if(book.getAuthor().equals(author)) list.add(book);
        }
        return list;
    }

    @GetMapping(value = "/searchBooksBySubject")
    public List<Book> searchBooksBySubject(@RequestParam(value = "q") String subject){
        List<Book> books = bookRepository.findAll();
        ArrayList<Book> list = new ArrayList<Book>();
        for(Book book : books){
            if(book.getSubject().equals(subject)) list.add(book);
        }
        return list;
    }


}
