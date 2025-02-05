package com.example.springboot;

import com.example.springboot.model.Book;
import com.example.springboot.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.math.BigDecimal;

@SpringBootApplication
public class BookStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(BookService bookService) {
        return args -> {
            bookService.save(new Book(null, "Effective Java", "Joshua Bloch", "9780134685991", new BigDecimal("40.00"), "Best Java book for professionals", null));
            bookService.save(new Book(null, "Clean Code", "Robert C. Martin", "9780132350884", new BigDecimal("35.00"), "A guide to writing clean and maintainable code", null));
            bookService.save(new Book(null, "Spring Boot in Action", "Craig Walls", "9781617292545", new BigDecimal("45.99"), "A practical guide to Spring Boot framework", null));
            bookService.save(new Book(null, "Java Concurrency in Practice", "Brian Goetz", "9780321349606", new BigDecimal("50.99"), "A deep dive into Java concurrency", null));
            bookService.save(new Book(null, "Head First Design Patterns", "Eric Freeman", "9780596007126", new BigDecimal("48.99"), "A fun and practical guide to design patterns", null));
        };
    }
}
