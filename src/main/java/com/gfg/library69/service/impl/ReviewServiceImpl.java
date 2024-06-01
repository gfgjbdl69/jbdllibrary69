package com.gfg.library69.service.impl;

import com.gfg.library69.annotation.MethodInfo;
import com.gfg.library69.domain.Book;
import com.gfg.library69.domain.Review;
import com.gfg.library69.repository.BookRepository;
import com.gfg.library69.repository.ReviewRepository;
import com.gfg.library69.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {


    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    BookRepository bookRepository;
    @Override
    @MethodInfo(author = "meet", description = "add review")
    public void addReview(Review review) {

        Optional<Book> bookOptional=bookRepository.findById(review.getBook().getId());
        if(bookOptional.isEmpty()){
            throw new IllegalArgumentException("Book Id does not exist");
        }
        review.setBook(bookOptional.get());
        reviewRepository.save(review); //reviewRepository
    }


    /***
     *
     * ///Homework
     *
     *
     * when a review is added to a book,
     *
     * call a book service or update a book to change the rating.
     *
     * you book rating is average of all the review rating.
     *
     * */
}
