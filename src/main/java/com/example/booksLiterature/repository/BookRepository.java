package com.example.booksLiterature.repository;

import com.example.booksLiterature.model.Author;
import com.example.booksLiterature.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository  extends JpaRepository<Book, Integer> {

    @Query("SELECT a FROM Author a")
    List<Author> listAllAuthors();

    @Query("SELECT a FROM Author a WHERE :fecha BETWEEN a.birth_year AND a.death_year")
    List<Author> findByAnios(String fecha);

    @Query("SELECT b FROM Book b  WHERE b.idiom = :searchidiom")
    List<Book> findByIdioma(@Param("searchidiom") String searchidiom);
}
