package com.example.springboot;

import com.example.springboot.model.Book;
import com.example.springboot.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookStoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(BookService bookService) {
        return args -> {
            bookService.save(new Book(null, "Effective Java", "Joshua Bloch", "9780134685991", 40.0, "Best Java book", null));
            bookService.save(new Book(null, "Clean Code", "Robert C. Martin", "9780132350884", 35.0, "Clean coding practices", null));
            bookService.findAll().forEach(System.out::println);
        };
    }
}
