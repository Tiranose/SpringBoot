package com.example.springboot;

import com.example.springboot.model.Book;
import com.example.springboot.service.BookService;
import java.math.BigDecimal;
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
    public CommandLineRunner initData(BookService bookService) {
        return args -> {
            bookService.save(new Book(null, "The Catcher in the Rye",
                    "J.D. Salinger", "978-0-316-76948-0",
                    new BigDecimal("10.99"),
                    "A novel about adolescent alienation", "cover1.jpg"));

            bookService.save(new Book(null, "To Kill a Mockingbird",
                    "Harper Lee", "978-0-06-112008-4",
                    new BigDecimal("12.99"),
                    "A novel about racial injustice", "cover2.jpg"));
        };
    }
}
