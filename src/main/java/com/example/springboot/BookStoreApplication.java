package com.example.springboot;

import com.example.springboot.model.Book;
import com.example.springboot.service.BookService;
import com.example.springboot.repository.BookRepository;
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
    public CommandLineRunner run(BookService bookService, BookRepository bookRepository) {
        return args -> {
            // Очистка таблицы перед вставкой тестовых данных (для тестов)
            bookRepository.deleteAll();

            try {
                bookService.addBook(new Book(null, "Effective Java", "Joshua Bloch", "9780134685991", 40.0, "Best Java book", null));
                bookService.addBook(new Book(null, "Clean Code", "Robert C. Martin", "9780132350884", 35.0, "Improve your coding skills", null));
            } catch (Exception e) {
                System.err.println("Ошибка при добавлении книг: " + e.getMessage());
            }

            final List<Book> books = bookService.getAllBooks();
            if (!books.isEmpty()) {
                System.out.println("First book in database: " + books.get(0));
            }

            System.exit(0);
        };
    }
}
