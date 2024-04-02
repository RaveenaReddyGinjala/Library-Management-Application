package com.example.library_management.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class IssuedBooks {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private int id;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "book_id")
    private int book_id;

    @Column(name = "status")
    private String status;

    public IssuedBooks () {

    }
}
