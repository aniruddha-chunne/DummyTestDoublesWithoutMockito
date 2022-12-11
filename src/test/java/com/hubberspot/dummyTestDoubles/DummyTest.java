package com.hubberspot.dummyTestDoubles;

import com.hubberspot.dummyTestDoubles.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DummyTest
{

    @Test
    public void testFake()
    {
//        BookRepository bookRepository = (BookRepository) new FakeBookRepository();

        BookRepository bookRepository = new FakeBookRepository();

        EmailSerivce emailSerivce = new DummyEmailService();

        BookService bookService  = new BookService(bookRepository, emailSerivce );

        bookService.addBook(new Book("1234", "Mockito in Action", 250, LocalDate.now()));
        bookService.addBook(new Book("12345", "Junit5 in Action", 200, LocalDate.now()));

        assertEquals(2, bookService.findNumberOfBooks());

    }

}
