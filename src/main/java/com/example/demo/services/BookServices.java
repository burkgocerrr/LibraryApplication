package com.example.demo.services;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookServices
{
    @Autowired
    BookRepository bookRepository;

    public boolean deleteBook(long id)
    {
        bookRepository.deleteById(id);
        return true;
    }

    public boolean updateBook(long id,String bookName,String publisherName,String authorName)
    {
        Book book=bookRepository.getOne(id);
        book.setBookName(bookName);
        book.getPublisher().setPublisherName(publisherName);
        book.getAuthor().setAuthorName(authorName);
        bookRepository.save(book);
        return true;
    }

    public Book getBook(long id)
    {
        Book book=bookRepository.findById(id).get();
        return book;
    }
    public List<Book> isbnFilter(String isbn)
    {
        List<Book> bookList=bookRepository.findByIsbn(isbn);
        return bookList;
    }

}
