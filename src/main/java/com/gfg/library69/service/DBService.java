package com.gfg.library69.service;

import com.gfg.library69.domain.Book;

import java.util.List;

public interface DBService {

    public Book addBook(Book book);

    public List<Book> getAllBook();


}
