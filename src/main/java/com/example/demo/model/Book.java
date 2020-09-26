package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="book")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String bookName;

    @Column
    private String bookSubname;

    @Column
    private String bookSeriesName;

    @Column
    private String bookDescription;

    @Column
    private String isbn;

    @JoinColumn(name="author_book_id")
    @ManyToOne(optional = true,fetch =FetchType.LAZY)
    private Author author;

    @JoinColumn(name="publisher_book_id")
    @ManyToOne(optional = true,fetch =FetchType.LAZY)
    private Publisher publisher;


}
