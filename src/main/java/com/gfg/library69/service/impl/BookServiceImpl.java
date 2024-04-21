package com.gfg.library69.service.impl;

import com.gfg.library69.domain.Book;
import com.gfg.library69.domain.Review;
import com.gfg.library69.repository.BookRepository;
import com.gfg.library69.service.BookService;
import com.gfg.library69.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.*;

@Service
public class BookServiceImpl implements BookService {


    @Autowired
    BookRepository bookRepository;


    public void addBook(Book book){

        bookRepository.save(book);
    }

    public List<Book> getAllBooks(){

       return bookRepository.findAll();
    }

    public Book getBook(Integer Id){

        return bookRepository.findById(Id).orElse(null);
    }
    public void deleteBook(Integer id){

        bookRepository.deleteById(id);
    }

    public Book updateBook(Integer Id, Book book){
       Optional<Book> originalBook=bookRepository.findById(Id);
       if(originalBook.isPresent()){
           bookRepository.save(book);
       }
       return book;
    }

    @Override
    public void addReview(String bookId, Review review) {
//       Book book=bookMap.getOrDefault(bookId,null);
//
//       if(book!=null)
//       {
//         //  book.getReviewList().add(review);
//       }
//       bookMap.put(bookId,book);
    }

}


