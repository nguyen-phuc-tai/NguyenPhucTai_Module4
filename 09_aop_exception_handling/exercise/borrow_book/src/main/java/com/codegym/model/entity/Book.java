package com.codegym.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer id;

    private String name;

    private String author;

    private Integer quantity;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private Set<CodeBook> codeSet;
}