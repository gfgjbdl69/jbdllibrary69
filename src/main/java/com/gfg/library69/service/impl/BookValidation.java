package com.gfg.library69.service.impl;

import com.gfg.library69.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookValidation {

    @Autowired
    ValidationService validationService;

    public void setValidationService(ValidationService validationService){
        this.validationService=validationService;
    }

    public boolean validateBook(Book book){
        return validationService.validate(book);
    }
}
