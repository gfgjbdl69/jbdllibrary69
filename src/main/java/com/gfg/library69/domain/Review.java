package com.gfg.library69.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    private String id;
    private String comment;
    private String reviewer;
    private Double rating;
    private String bookId;
}
