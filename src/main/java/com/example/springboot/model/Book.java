package com.example.springboot.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "books") // Указываем имя таблицы
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false, unique = true)
    private String isbn;

    @Column(nullable = false)
    private double price;

    private String description;
    private String coverImage;
}
