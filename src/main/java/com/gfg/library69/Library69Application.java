package com.gfg.library69;

import com.gfg.library69.domain.Book;
import com.gfg.library69.domain.Genre;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class Library69Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Library69Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Book b=new Book();
		b.setId("1");
		b.setTitle("abc");
		b.setAuthor("xyz");
		b.setGenre(Genre.FICTION);
		b.setRating(5.0);
		b.setCost(200.0);
		b.setReviewList(null);
		b.setYear(2019);

		Book b1=new Book();
		b1.setId("1");
		b1.setTitle("abc");
		b1.setAuthor("xyz");
		b1.setGenre(Genre.FICTION);
		b1.setRating(5.0);
		b1.setCost(200.0);
		b1.setReviewList(null);
		b1.setYear(2019);

		Set<Book> bookSet=new HashSet<>();
		bookSet.add(b);
		bookSet.add(b1);
		bookSet.add(b);

		System.out.println(bookSet.size());


	}
}
