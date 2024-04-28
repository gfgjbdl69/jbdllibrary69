package com.gfg.library69.service.impl;

import com.gfg.library69.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookCascadeSampleImpl {

    @Autowired
    BookRepository bookRepository;

    public void testCascade(Integer id){

        bookRepository.deleteById(id);


    }
}
