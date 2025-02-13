package com.example.springboot;

import com.example.springboot.model.Book;
import com.example.springboot.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
public class BookStoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(BookService bookService) {
        return args -> {
            bookService.save(new Book(null,
                    "To Kill1 a Mockingbird",
                    "Harpe1r Lee",
                    "978-0-06-1112008-4",
                    new BigDecimal("112.99"),
                    "A novel abou1t racial injustice",
                    "cover2.jp1g"));

            List<Book> books = bookService.getAllBooks();
            books.forEach(System.out::println);
        };
    }
}
