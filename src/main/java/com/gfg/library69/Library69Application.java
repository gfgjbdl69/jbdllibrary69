package com.gfg.library69;

import com.gfg.library69.annotation.MethodInfo;
import com.gfg.library69.domain.Book;
import com.gfg.library69.domain.Genre;
import com.gfg.library69.domain.Review;
import com.gfg.library69.repository.BookRepository;
import com.gfg.library69.service.impl.BookCascadeSampleImpl;
import com.gfg.library69.service.impl.ReviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

import java.util.*;

@SpringBootApplication
public class Library69Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Library69Application.class, args);
	}

	@Autowired
	ApplicationContext context;

	@Autowired
	BookRepository bookRepository;






	@Override
	public void run(String... args) throws Exception {

		ReviewServiceImpl impl=new ReviewServiceImpl();

		MethodInfo methodInfo=impl.getClass().getMethod("addReview",Review.class).getAnnotation(MethodInfo.class);

		System.out.println(methodInfo.author());
		System.out.println(methodInfo.description());




//		Book book=new Book();
//		book.setTitle("Hp-4");
//		book.setAuthor("JK Rowling");
//		book.setGenre(Genre.FANTASY);
//		book.setRating(5.0);
//		book.setCost(500.0);
//		book.setYear(2000);
//		List<Review> reviews=new ArrayList<>();
//		reviews.add(new Review());
//
//
//		redisTemplate.opsForValue().set("myJavaKey","myJavaValue");
//		System.out.println(redisTemplate.opsForValue().get("myJavaKey"));
//
//		redisTemplate.opsForList().rightPush("list",1);
//		redisTemplate.opsForList().rightPush("list",2);
//		redisTemplate.opsForList().rightPush("list",3);
//		redisTemplate.opsForList().rightPush("list",4);
//
//		System.out.println(redisTemplate.opsForList().leftPop("list"));
//		System.out.println(redisTemplate.opsForList().rightPop("list"));
//
//		redisTemplate.opsForHash().put("book",book.getTitle(),book);






	}

	/***
	 *
	 * Steps for hibernate:
	 * 1. add the spring data jpa maven dependency.
	 * 2. add the configurations of url,username,password in application.properties.
	 * 3. Annotate you domain with @Table and @Entity annotation.
	 * 4. Add an iD to the domain with desired ID generation type.
	 * 5. Create repository for each domain and let it extend the JPARepository.
	 * 6. write your custom queries to the interface.
	 * 7. Start using the repository for DB related task in the service layer.
	 *
	 *
	 *
	 * */

	/***
	 * Assignments
	 *
	 * update all the controllers to accept resource
	 * check all the functionality
	 * create some custom methods in repository
	 * implement the users functionality
	 * 	create a user
	 * 	create a domain for user
	 * 	CRUD for user.
	 * 	Proper exception handling
	 *
	 *
	 * */
}
