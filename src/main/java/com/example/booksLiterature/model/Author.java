package com.example.booksLiterature.model;

import com.example.booksLiterature.dto.AuthorDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String birth_year;
    private String death_year;
    @OneToOne(mappedBy = "author",cascade = CascadeType.ALL, orphanRemoval = true)
    private Book books;

    public Author() {}

    public Author(AuthorDTO authorDTO) {

        this.name = authorDTO.name();
        this.birth_year = authorDTO.birth_year();
        this.death_year = authorDTO.death_year();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(String birth_year) {
        this.birth_year = birth_year;
    }

    public String getDeath_year() {
        return death_year;
    }

    public void setDeath_year(String death_year) {
        this.death_year = death_year;
    }

    public Book getBooks() {
        return books;
    }

    public void setBooks(Book books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return
                "\n \n-----------Autor:-----------"+
                "\n nombre= '" + name + '\'' +
                ",\n fechaDeNacimiento= '" + birth_year + '\'' +
                ",\n fechaDeMuerte= '" + death_year + '\''+
                "\n libros= '" + books.getTitle() + '\''
                ;
    }
}
