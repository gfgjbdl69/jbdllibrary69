package com.gfg.library69.service.impl;

import com.gfg.library69.domain.Book;
import com.gfg.library69.domain.Genre;
import com.gfg.library69.service.DBService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class DBServiceImpl {
//
//
//    @Autowired
//    Connection mySqlConnection;
//
//    private PreparedStatement addBookStatement=null;
//
//    @PostConstruct
//    public void init(){
//        log.info("MySql Connection is "+mySqlConnection);
//        log.info("creating table if not exists");
//        String query="create table if not exists book(id int primary key auto_increment,title varchar(100),author varchar(100),genre varchar(10),rating double,cost double,year int)";
//        try(Statement statement=mySqlConnection.createStatement()){
//            statement.execute(query);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        try {
//            addBookStatement=mySqlConnection.prepareStatement("insert into book(title,author,genre,rating,cost,year) values(?,?,?,?,?,?)");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
////    @Override
////    public Book addBook(Book book) {
////        String query="insert into book(title,author,genre,rating,cost,year) values('"+book.getTitle()+"','"+book.getAuthor()+"','"+book.getGenre()+"','"+book.getRating()+"','"+book.getCost()+"','"+book.getYear()+"')";
////        try(Statement statement=mySqlConnection.createStatement()){
////            statement.execute(query);
////            return book;
////        } catch (SQLException e) {
////            log.error("Error adding book to DB: {}",e.getMessage());
////
////        }
////        return null;
////    }
//
//    @Override
//    public Book addBook(Book book) {
//       try{
//           addBookStatement.setString(1,book.getTitle());
//           addBookStatement.setString(2,book.getAuthor());
//           addBookStatement.setString(3,book.getGenre().name());
//           addBookStatement.setDouble(4,book.getRating());
//           addBookStatement.setDouble(5,book.getCost());
//           addBookStatement.setInt( 6,book.getYear());
//           addBookStatement.execute();
//            return book;
//        } catch (SQLException e) {
//            log.error("Error adding book to DB: {}",e.getMessage());
//
//        }
//        return null;
//    }
//
//    @Override
//    public List<Book> getAllBook() {
//        String query="select * from book";
//        try(Statement statement=mySqlConnection.createStatement()){
//            ResultSet resultSet=statement.executeQuery(query);
//            List<Book> books=new ArrayList<>();
//            while(resultSet.next()){
//                Book book=new Book();
//                book.setId(resultSet.getString("id"));
//                book.setTitle(resultSet.getString("title"));
//                book.setAuthor(resultSet.getString("author"));
//                book.setGenre(Genre.valueOf(resultSet.getString("genre")));
//                book.setRating(resultSet.getDouble("rating"));
//                book.setCost(resultSet.getDouble("cost"));
//                book.setYear(resultSet.getInt("year"));
//                books.add(book);
//            }
//            return books;
//        } catch (SQLException e) {
//            log.error("Error getting book from DB: {}",e.getMessage());
//        }
//        return null;
//    }
}


/**
 * DDL  - Data definition language
 * create table, create view, create join table
 *
 *
 * DML -  Data manipulation language
 * - insert into, update, delete select
 *
 * DCL - Data control language
 * - grant, revoke
 *
 * TCL - Transaction control language
 * - start transaction, commit transaction, rollback
 *
 * https://www.geeksforgeeks.org/sql-ddl-dml-tcl-dcl/
 *
 *
 * types of execute
 *
 * 1. execute() -> execute query -> returns true for success of result-set, false for failure
 * 2. executeUpdate() -> update query -> returns the number of rows affected
 * 3. executeQuery() -> select query -> returns the result set of data
 *
 *
 * JPA -> Java persistence API
 *
 * ORM -> Object relational mapping -> ORM framework 0-> Hibernate or Open JPA.
 *
 * */
