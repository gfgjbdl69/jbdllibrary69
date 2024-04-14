package com.gfg.library69.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private String id; // not a part of request
    private String title;
    private String author;
    private Genre genre;
    private Double rating; // not a part of request
    private Double cost;
    private List<Review> reviewList; // not a part of request
    private Integer year;


//    @Override
//    public boolean equals(Object o){
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Book book = (Book) o;
//        return Objects.equals(getId(), book.getId());
//    }

    @Override
    public int hashCode() {
        return Integer.valueOf(getId());
    }
}
