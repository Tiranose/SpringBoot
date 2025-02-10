package com.example.springboot;

import com.example.springboot.model.Book;
import com.example.springboot.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.math.BigDecimal;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookStoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(BookService bookService) {
        return args -> {
            bookService.addBook(new Book(null, "Effective Java",
                    "Joshua Bloch", "9780134685991",
                    new BigDecimal("40.0"), "Best Java book", null));
            bookService.addBook(new Book(null, "Clean Code",
                    "Robert C. Martin", "9780132350884",
                    new BigDecimal("35.0"), "Clean coding practices", null));
            bookService.getAllBooks().forEach(System.out::println);
        };
    }
}
