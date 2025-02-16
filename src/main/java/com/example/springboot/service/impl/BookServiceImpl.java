package com.example.springboot.service.impl;

import com.example.springboot.dto.BookDto;
import com.example.springboot.dto.CreateBookRequestDto;
import com.example.springboot.mapper.BookMapper;
import com.example.springboot.model.Book;
import com.example.springboot.repository.BookRepository;
import com.example.springboot.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public List<BookDto> getAll() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(bookMapper::toDto).toList();
    }

    @Override
    public BookDto getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with ID: " + id));
        return bookMapper.toDto(book);
    }

    @Override
    public BookDto save(CreateBookRequestDto bookDto) {
        Book book = bookMapper.toEntity(bookDto);
        Book savedBook = bookRepository.save(book);
        return bookMapper.toDto(savedBook);
    }
}
