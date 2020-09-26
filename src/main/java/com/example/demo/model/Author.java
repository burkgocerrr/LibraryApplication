package com.example.demo.model;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String authorName;

    @Column
    private String authorDescription;

    @JsonIgnore
    @JoinColumn(name ="author_book_id" )
    @OneToMany(fetch = FetchType.LAZY)
    private List<Book> bookList;
}
