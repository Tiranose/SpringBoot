package com.example.springboot.service;

import com.example.springboot.model.Book;
import com.example.springboot.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    /**
     * Добавление книги в базу данных
     * @param book объект книги
     * @return сохраненная книга
     */
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    /**
     * Получение списка всех книг
     * @return список книг
     */
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
