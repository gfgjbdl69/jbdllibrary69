package com.gfg.library69.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reviews")
@Builder
public class Review {

    @Id
    @Column(name ="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String comment;
    private Double rating;
    //Review - Book
    // Many reviews can be on one book

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "book_id")  // classname _ the varaiable name of ID.
    private Book book;
}

/***
 * Assosiation
 *
 * 1. Unidirectional ->
 *          From one entity you can fetch the another entity.
 *          not true for vice versa.
 * 2. BiDirectional
 *          From one entity out of 2, anyone can fetch other entity
 *
 *
 * One to many
 * -> one entity can be mapped with multiple entities of other resource
 *
 * Many to one
 * Many entities can be mapped with one entity of other resource
 *
 * One to one
 * Exactly one entity can be mapped with one entity of another resource
 *
 * Many to many
 *
 * Multiple entities of resource can be mapped with multiple entity of another resource
 *
 *
 * Joins
 *
 * Inner join or join
 * Table A and Table B and a common attribute or reference.
 *
 * All the values of A and B which are mapped with reference. (Similar to where query)
 *
 * Outer join
 *
 * 1. Left
 * All the values of A and B which are mapped with reference. Plus the values left in A.
 *
 * 2. Right
 *  All the values of A and B which are mapped with reference. Plus the values left in B.
 *  *
 *
 *  Fetch types:
 *
 *  1. Eager
 *
 *  when the entity is fetched from database, the associated entities are also fetched at the same time
 *
 *  2. Lazy
 *
 *  when the entity is fetched from the database, the associated entities are not fetched right away and fetched only if getters are called.
 *
 *
 * Default fetch type
 * for OneToMany & ManyToMany -  Lazy
 *
 * for ManyToOne & OneToOne - Eager
 *
 *
 * Cascade type
 *
 *     ALL, -> perform all the operations on the reference table also.
 *     PERSIST, -> if a entity is persited, persist the reference entity also
 *                  if Book is created with review as data object of java and on saving book, it should save the reviews also.
 *     MERGE ->
 *     In case of any update or re-entry merge the entities back.
 *         if book gets deleted, the reviews wil not be deleted and will be orphan can be merged if same if found.
 *     REMOVE, - use carefully.
 *      - In case of delete, delete the references also.
 *          If book is deleted, delete the reviews of that book too.
 *          if One author, has multiple books, and if you delete the book, the author also gets deleted.
 *     REFRESH,
 *       In-case of refresh in parent or entity, the reference entity also gets refreshed.
 *
 *     DETACH;
            In-case of delete in parent entity, the reference is detached from the parent and kept as it is.
 *
 *
 *
 *
 *
 *
 * /
 *
 * */
