package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String publisherName;

    @Column
    private String publisherDescription;

    @JsonIgnore
    @JoinColumn(name ="publisher_book_id" )
    @OneToMany(fetch = FetchType.LAZY)
    private List<Book> bookList;
}
