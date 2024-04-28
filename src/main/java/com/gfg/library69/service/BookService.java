package com.gfg.library69.service;

import com.gfg.library69.domain.Book;
import com.gfg.library69.domain.Review;
import com.gfg.library69.service.resource.BookResponse;

import java.util.List;
import java.util.Set;

public interface BookService {

    public void addBook(Book book);
    public List<Book> getAllBooks();
    public Book getBook(Integer Id);

    public void deleteBook(Integer Id);
    public Book updateBook(Integer Id, Book book);

    public void addReview(String bookId, Review review);

}
