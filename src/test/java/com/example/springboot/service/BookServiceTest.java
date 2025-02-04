package com.example.springboot.service;

import com.example.springboot.model.Book;
import com.example.springboot.service.impl.BookServiceImpl;
import com.example.springboot.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    private Book testBook;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        testBook = new Book(null, "Spring Boot", "John Doe", "123456789", new BigDecimal("50.00"), "Description", null);
    }

    @Test
    void saveBook() {
        when(bookRepository.save(testBook)).thenReturn(testBook);
        Book savedBook = bookService.save(testBook);
        assertNotNull(savedBook);
        assertEquals("Spring Boot", savedBook.getTitle());
    }

    @Test
    void findAllBooks() {
        when(bookRepository.findAll()).thenReturn(List.of(testBook));
        List<Book> books = bookService.findAll();
        assertEquals(1, books.size());
    }
}