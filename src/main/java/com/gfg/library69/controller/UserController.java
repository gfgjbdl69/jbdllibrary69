package com.gfg.library69.controller;


import com.gfg.library69.domain.Book;
import com.gfg.library69.domain.Review;
import com.gfg.library69.service.BookService;
import com.gfg.library69.service.UserService;
import com.gfg.library69.service.resource.BookResponse;
import com.gfg.library69.service.resource.UserRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class UserController {

    @Autowired
    BookService bookService;

    @Autowired
    UserService userService;

    @GetMapping("/book")
    public ResponseEntity<List<Book>> getAllBooks(){
        return new ResponseEntity<>(bookService.getAllBooks(),HttpStatus.OK);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") Integer bookId){

        return new ResponseEntity<>(bookService.getBook(bookId), HttpStatus.OK);
    }

    @PostMapping("{bookId}/review")
    //@RequestMapping(method = RequestMethod.POST,path = "{bookId}/review")
    public ResponseEntity<Book> addReview(@PathVariable("bookId") String bookId, @RequestBody Review review){

        bookService.addReview(bookId,review);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PostMapping("register")
    public ResponseEntity<?> register(@RequestBody @Valid UserRequest userRequest){

        userService.addUser(userRequest.toUser());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }



    // add an api for add user
    /***
     * Store the user in map
     * check if the email is proper, if not throw 400
     * if any internal issues, handle 500
     *
     * */

    // add an API for get user.

    /**
     * user profile
     * */

}


/***
 * Two ways to read from the Get API
 *
 * 1. Query param
 *
 * ones which are after the ? symbol on the URL and has key as variable name and value as value.
 * e.x -> book?bookId=1
 *
 * @RequestParam -> should be used in the parameters of method to map the values of URL to Java variables.
 *
 * 2. Path param
 *
 * ones which are part of the URL itself.
 *
 * E.x -> book/1 , book/43
 * where 1 is the ID of the book.
 *
 * @PathVariable -> should be used in the  part of the URL  to map the values of Java variables.
 *
 * */