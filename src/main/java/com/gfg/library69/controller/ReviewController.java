package com.gfg.library69.controller;

import com.gfg.library69.service.ReviewService;
import com.gfg.library69.service.resource.ReviewRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @PostMapping
    public ResponseEntity<?> addReview(@RequestBody @Valid ReviewRequest reviewRequest){
        reviewService.addReview(reviewRequest.toReview());
        System.out.println("just practice to create pull request");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
