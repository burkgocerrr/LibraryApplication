package com.example.demo.restApi;

import com.example.demo.model.Book;
import com.example.demo.services.BookServices;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookRestApi
{
    @Autowired
    BookServices bookServices;

    @GetMapping("/getBook/{id}")
    public ResponseEntity<Object> getBook(@PathVariable long id)
    {
        Book book=bookServices.getBook(id);
        JSONObject obj=new JSONObject();
        obj.put("id",book.getId());
        obj.put("bookName",book.getBookName());
        obj.put("bookSubname",book.getBookSubname());
        obj.put("bookSeriesName",book.getBookSeriesName());
        obj.put("bookDescription",book.getBookDescription());
        obj.put("isbn",book.getIsbn());
        obj.put("authorName",book.getAuthor().getAuthorName());
        obj.put("publisherName",book.getPublisher().getPublisherName());

        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/deleteBook/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable long id)
    {
        boolean status=bookServices.deleteBook(id);
        JSONObject obj=new JSONObject();
        obj.put("status","Başarılı");
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    @PostMapping("/updateBook/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable long id,@RequestParam(name="authorName") String authorName,@RequestParam(name="publisherName") String publisherName,@RequestParam(name="bookName") String bookName)
    {
        boolean status=bookServices.updateBook(id,bookName,publisherName,authorName);
        JSONObject obj=new JSONObject();
        obj.put("status","Başarılı");
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    @PostMapping("/isbnFilter")
    public ResponseEntity<Object> isbnFilter(@RequestParam(name="isbn") String isbn )
    {
        List<Book> bookList=bookServices.isbnFilter(isbn);
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

}
