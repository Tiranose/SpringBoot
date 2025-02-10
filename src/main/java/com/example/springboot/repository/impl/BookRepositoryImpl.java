package com.example.springboot.repository.impl;

import com.example.springboot.model.Book;
import com.example.springboot.repository.BookRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {
    private final List<Book> books = new ArrayList<>();

    @Override
    public void save(Book book) {
        books.add(book);
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books);
    }

    @Override
    public void deleteById(Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }
}
