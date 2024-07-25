package com.gfg.library69.controller;

import com.gfg.library69.domain.Book;
import com.gfg.library69.service.BookService;
import com.gfg.library69.service.resource.BookRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;

@RestController

public class AdminController {




    /***
     * 3 ways to inject the dependency
     *
     * 1. by declaring the instance with Autowired. - Field injection.
     * @Autowired
     *     BookService bookService;
     *
     * 2. With help of constructor - construtor injection
     * @Autowired
     *     public AdminController(BookService bookService, DummyServiceImpl dummyService) {
     *         this.bookService = bookService;
     *         this.dummyService=dummyService;
     *
     *     }
     *
     *
     * 3. With help of setters.  - method/ setter injection
     * @Autowired
     *     public void setBookService(BookService bookService){
     *         this.bookService=bookService;
     *     }
     * */

    @Autowired
    BookService bookService;


    @PostMapping("/admin/book")
    public ResponseEntity<Book> createBook(@RequestBody @Valid BookRequest bookRequest){
        bookService.addBook(bookRequest.getBook());
        return  new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping("admin/book")
    public ResponseEntity<Book> updateBook(@RequestParam("bookId") Integer id,@RequestBody Book book){
System.out.println("Hi creating some change");
        System.out.println("Hi creating some change2");
        return new ResponseEntity<>(bookService.updateBook(id, book),HttpStatus.OK);

    }

    @DeleteMapping("admin/book")
    public ResponseEntity<Book> deleteBook(@RequestParam("bookId") Integer id){
        //ex: /admin/book/?bookId=1
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
