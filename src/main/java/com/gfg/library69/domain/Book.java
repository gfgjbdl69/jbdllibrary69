package com.gfg.library69.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")
@Entity
@Builder
public class Book {
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