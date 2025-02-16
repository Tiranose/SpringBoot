package com.example.springboot.mapper;

import com.example.springboot.dto.BookDto;
import com.example.springboot.dto.CreateBookRequestDto;
import com.example.springboot.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDto toDto(Book book);
    Book toEntity(CreateBookRequestDto bookDto);
}
