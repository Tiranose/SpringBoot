package com.example.springboot.service;

import com.example.springboot.model.Book;
import java.util.List;

public interface BookService {
    void addBook(Book book);
    List<Book> getAllBooks();
    void deleteBook(Long id);
}
