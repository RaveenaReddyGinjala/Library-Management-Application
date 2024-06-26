package com.example.library_management.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "subject")
    private String subject;

    public Book() {

    }

}



