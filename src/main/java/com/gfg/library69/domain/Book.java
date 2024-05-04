package com.gfg.library69.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")
@Entity
@Builder
public class Book  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String author;
    @Enumerated(value = EnumType.STRING)
    private Genre genre;
    private Double rating;
    private Double cost;
    private Integer year;
    private String authorEmail;

    // Book - Review
    // One book can have multiple reviews
    @OneToMany(mappedBy = "book",fetch = FetchType.EAGER,cascade= CascadeType.DETACH)
    @JsonIgnoreProperties("book")
    private List<Review> reviewList;


    public List<Review> getReviewList() {
       return reviewList;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre=" + genre +
                ", rating=" + rating +
                ", cost=" + cost +
                ", year=" + year +
                ", authorEmail='" + authorEmail + '\'' +
                ", reviewList=" + reviewList +
                '}';
    }
}


/***
 * Types of ID generation
 *
 *     TABLE -> keeping a separate table for the Id generation.
 *     SEQUENCE -> where the last sequence is identified and IDs are updated . -> postgres
 *     IDENTITY -> which is supported by the under-laying database. eg: mysql, sql server.
 *     UUID -> generate a unique identifer, randomly generated.
 *     AUTO -> which will the framwork to support the one by the under-laying data or go forward with Identity.
 * */