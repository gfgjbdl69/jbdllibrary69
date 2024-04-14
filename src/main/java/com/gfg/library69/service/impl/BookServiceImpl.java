package com.gfg.library69.service.impl;

import com.gfg.library69.domain.Book;
import com.gfg.library69.domain.Review;
import com.gfg.library69.service.BookService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookServiceImpl implements BookService {

    Map<String,Book> bookMap = new HashMap<>();

    public void addBook(Book book){

        Integer Id=new Random().nextInt(1,3);
        book.setId(String.valueOf(Id));
        bookMap.put(book.getId(),book);

    }

    public Set<Book> getAllBooks(){

        return new HashSet<>(bookMap.values());
    }

    public Book getBook(String Id){

        return bookMap.getOrDefault(Id,null);
    }
    public void deleteBook(String id){
      bookMap.remove(id);
    }

    public Book updateBook(String Id, Book book){
       if(bookMap.containsKey(Id))
       {
           bookMap.put(Id,book);
       }
       return book;
    }

    @Override
    public void addReview(String bookId, Review review) {
       Book book=bookMap.getOrDefault(bookId,null);

       if(book!=null)
       {
           book.getReviewList().add(review);
       }
       bookMap.put(bookId,book);
    }
}


