package com.gfg.library69.service.impl;

import com.gfg.library69.domain.Book;
import com.gfg.library69.repository.BookRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.*;
import org.mockito.Spy;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class BookServiceImplTest {



    List<Book> bookList = new ArrayList<>();
    @BeforeEach
    public void setup(){
        System.out.println("in the start");
        Book book = new Book();
        bookList.add(book);
    }


    @AfterEach()
    public void atTheLastOfEveryTestCase(){
        System.out.println("aftet each test");
    }

    @Test
    void getAllBooks() {
        BookServiceImpl bookService=new BookServiceImpl();
        //mocking
        BookRepository bookRepository=mock(BookRepository.class);
        bookService.setBookRepository(bookRepository);

        //stubbing

        when(bookRepository.findAll()).thenReturn(bookList);
        assertEquals(bookList.size(),1);
        bookService.getAllBooks();

    }

    @Test()
    public void testGetAllBooks_EmptyTitle(){
        BookServiceImpl bookService=new BookServiceImpl();
        //mocking
        BookRepository bookRepository=mock(BookRepository.class);
        bookService.setBookRepository(bookRepository);

        //stubbing
        List<Book> bookList = new ArrayList<>();
        when(bookRepository.findAll()).thenReturn(bookList);

        assertThrows(IllegalStateException.class,()->bookService.getAllBooks());
    }

    @Test()
    public void testGetAllBooks_EmptyTitle2(){
        BookServiceImpl bookService=new BookServiceImpl();
        //mocking
        BookRepository bookRepository=mock(BookRepository.class);
        bookService.setBookRepository(bookRepository);

        //stubbing
        List<Book> bookList = new ArrayList<>();
        when(bookRepository.findAll()).thenReturn(bookList);

        assertThrows(IllegalStateException.class,()->bookService.getAllBooks());
    }

    @Test
    public void testAddBook(){
        BookServiceImpl bookService=new BookServiceImpl();
        BookValidation bookValidation=mock(BookValidation.class);

        Book book=spy(new Book());
       // book.setTitle("PQR");
        bookService.setBookValidation(bookValidation);
        when(bookValidation.validateBook(any(Book.class))).thenReturn(true);
        when(any(Book.class).getTitle()).thenReturn("ABC");
        // bookService.addBook(book);
        BookRepository bookRepository=mock(BookRepository.class);
        bookService.setBookRepository(bookRepository);

        bookService.addBook(book);
    }

    @Test
    public void testAddBook_InvalidBook(){
        BookServiceImpl bookService=new BookServiceImpl();
        BookValidation bookValidation=mock(BookValidation.class);

        Book book=new Book();
        bookService.setBookValidation(bookValidation);
        when(bookValidation.validateBook(any(Book.class))).thenReturn(false);
       // bookService.addBook(book);
        assertThrows(IllegalArgumentException.class,()->bookService.addBook(book));
    }

    @Test
    public void testAddBook_InvalidBookWithSpy(){
        BookServiceImpl bookService=spy(new BookServiceImpl()); //new BookServiceImpl();
        BookValidation bookValidation=spy(new BookValidation());
        ValidationService validationService=new ValidationService();
        bookValidation.setValidationService(validationService);

        Book book=new Book();
        bookService.setBookValidation(bookValidation);
        doReturn(false).when(bookValidation).validateBook(any(Book.class));
       // when(bookValidation.validateBook(book)).thenReturn(false);
        // bookService.addBook(book);
        assertThrows(IllegalArgumentException.class,()->bookService.addBook(book));
    }

    @Test
    public void testAddBook_WithABCTitle(){
        BookServiceImpl bookService=new BookServiceImpl();
        BookValidation bookValidation=mock(BookValidation.class);

        Book book=new Book();
        book.setTitle("ABC");
        bookService.setBookValidation(bookValidation);
        when(bookValidation.validateBook(any(Book.class))).thenReturn(true);
        // bookService.addBook(book);
        assertThrows(IllegalStateException.class,()->bookService.addBook(book));
    }


}


/***
 * Unit testing -> Testing of the code blocks a developer write. It covers all the scenarios of the method.
 *      Developer should be writing this cases.
 *      Code - coverage to the build is determined by the number of lines covered by the test cases.
 *            - 100% code coverage is Ideal.
 *
 *
 *            Mockito -> Library helps in mocking the objects or beans.
 *
 *            1. Mock -> we mock the object here in the test case
 *
 *                -ex : for bookService, we mock the bookRepository so that output of the bookRepository can be controlled.
 *                      the dependent bean is also handled in the mock.
 *
 *
 *            2. Stub -> we mock the behavior of the object when the methods are called.
 *
 *                 -ex: for bookService the mocked bookRepository, get a custom output of specific method.
 *
 *            3. Spy  -> To help stubbing when the object is not mocked.
 *
 *                  -Ex: for non-mocked objects, we can spy for them to call a method which are stubbed and give stubbed output to them.
 *
 *
 *
 * Asserts
 * -> if a= 5
 *
 * assert(5,a) -> pass
 * assert(10,a) -> fail
 *
 * for Junit<5, the expections are tested with the expected keyword in the annotation with the value as type of the Exception
 * For Junit5> it has to be tested along with asserts itself.
 *
 *Functional testing -> Testing of the functionality. where the entire operation of the entity or resource are tested with real scenarios.
 *
 *
 * */