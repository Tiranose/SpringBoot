package com.example.springboot.service;

import com.example.springboot.dto.BookDto;
import com.example.springboot.dto.CreateBookRequestDto;
import java.util.List;

public interface BookService {

    List<BookDto> getAll();

    BookDto getBookById(Long id);

    BookDto save(CreateBookRequestDto bookDto);

}
