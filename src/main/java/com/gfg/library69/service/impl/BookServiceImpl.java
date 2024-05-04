package com.gfg.library69.service.impl;

import com.gfg.library69.domain.Book;
import com.gfg.library69.domain.Review;
import com.gfg.library69.repository.BookRepository;
import com.gfg.library69.repository.ReviewRepository;
import com.gfg.library69.service.BookService;
import com.gfg.library69.service.DBService;
import com.gfg.library69.service.resource.BookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.*;

@Service
public class BookServiceImpl implements BookService {



    BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }

    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    BookValidation bookValidation;

    public void setBookValidation(BookValidation bookValidation){
        this.bookValidation=bookValidation;
    }



    public void addBook(Book book){

        if(!bookValidation.validateBook(book)){

            throw new IllegalArgumentException("Book is not valid");
        }

        if(book.getTitle().contains("ABC"))
        {
            throw new IllegalStateException("Title cannot be ABC");
        }


        bookRepository.save(book);
    }


    // Manual ref for merging entities
//    public List<BookResponse> getAllBooks(){
//
//        List<Book> books=bookRepository.findAll();
//        List<BookResponse> bookResponses=new ArrayList<BookResponse>();
//        for(Book book:books){
//            List<Review> reviews=reviewRepository.findByBookId(book.getId());
//            bookResponses.add( BookResponse.builder().cost(book.getCost()).title(book.getTitle()).author(book.getAuthor()).rating(book.getRating()).reviewList(reviews).build());
//
//        }
//        // for each book, populate the reviews
//       return bookResponses;
//    }

    public List<Book> getAllBooks(){
        List<Book> bookList=bookRepository.findAll();
        // iterate all books. add top 10 rated books in redis via redistemplate.
        if(bookList.isEmpty()){
            throw new IllegalStateException("books list cannot be empty");
        }

        return bookList;
    }



    public Book getBook(Integer Id){

        //check redisTemplate.get("book"+Id). if found then return. else get from db

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


