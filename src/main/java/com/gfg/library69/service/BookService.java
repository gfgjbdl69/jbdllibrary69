package com.gfg.library69.service;

import com.gfg.library69.domain.Book;
import com.gfg.library69.domain.Review;

import java.util.List;
import java.util.Set;

public interface BookService {

    public void addBook(Book book);
    public Set<Book> getAllBooks();
    public Book getBook(String Id);

    public void deleteBook(String Id);
    public Book updateBook(String Id, Book book);

    public void addReview(String bookId, Review review);

}
