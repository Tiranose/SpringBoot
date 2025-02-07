package com.example.springboot;

import com.example.springboot.model.Book;
import com.example.springboot.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class BookStoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner testApplication(BookService bookService) {
        return args -> {
            // Добавляем книги в базу данных
            bookService.save(new Book(null, "Effective Java", "Joshua Bloch", "9780134685991", 40.00, "Best Java book", null));
            bookService.save(new Book(null, "Clean Code", "Robert C. Martin", "9780132350884", 35.00, "A guide to writing clean and maintainable code", null));

            // Получаем список всех книг
            List<Book> books = bookService.findAll();

            // Проверяем, есть ли книги, и выводим первую найденную
            if (!books.isEmpty()) {
                System.out.println("First book in database: " + books.get(0));
            } else {
                System.out.println("No books found in the database.");
            }
        };
    }
}
