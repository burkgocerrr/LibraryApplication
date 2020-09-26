package com.example.demo.controller;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.Publisher;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainControl {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    PublisherRepository publisherRepository;

    @GetMapping("/index")
    public String index(Model model)
    {
        ArrayList<Book> bookList=new ArrayList<Book>();
        ArrayList<Publisher> publisherList=new ArrayList<Publisher>();
        ArrayList<Author> authorList=new ArrayList<Author>();

        Author a1=new Author();
        a1.setAuthorName("Yaşar Kemal");
        a1.setAuthorDescription("XX");
        Author a2=new Author();
        a2.setAuthorName("Halid Ziya Uşaklıgil");
        a2.setAuthorDescription("XX");
        authorList.add(a1);
        authorList.add(a2);

        Publisher p1=new Publisher();
        p1.setPublisherName("Yapı Kredi Yayınları");
        p1.setPublisherDescription("YY");
        Publisher p2=new Publisher();
        p2.setPublisherName("Özgür Yayınları");
        p2.setPublisherDescription("YY");
        publisherList.add(p1);
        publisherList.add(p2);


        Book b1=new Book();
        b1.setBookName("Kuşlar da Gitti");
        b1.setBookSubname("Kitap Alt Adı");
        b1.setBookSeriesName("Kitap Seri Adı");
        b1.setBookDescription("ZZ");
        b1.setIsbn("ISBN Numarası");
        b1.setAuthor(a1);
        b1.setPublisher(p1);
        Book b2=new Book();
        b2.setBookName("Aşkı Memnu");
        b2.setBookSubname("Kitap Alt Adı");
        b2.setBookSeriesName("Kitap Seri Adı");
        b2.setBookDescription("ZZ");
        b2.setIsbn("ISBN Numarası");
        b2.setAuthor(a2);
        b2.setPublisher(p2);
        bookList.add(b1);
        bookList.add(b2);

        authorRepository.saveAll(authorList);
        publisherRepository.saveAll(publisherList);
        bookRepository.saveAll(bookList);


        model.addAttribute("bookList",bookList);

        return "index";
    }
}
