package com.example.booksLiterature.model;
import com.example.booksLiterature.dto.BookData;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String title;
    @Column(name = "idiom")
    private String idiom;
    private Integer cantidaDeDescargas;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "author_id")
    private Author author;


    public Book() {
    }

    public Book(BookData bookData) {
        this.title = bookData.title();
        this.idiom = String.valueOf( bookData.idiom().get(0));
        this.cantidaDeDescargas= bookData.cantidaDeDescargas();
        this.author= new Author(bookData.author().get(0));

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIdiom() {
        return idiom;
    }

    public void setIdiom(List<String> idiom) {
        this.idiom = String.valueOf( idiom.get(0));
    }

    public Integer getCantidaDeDescargas() {
        return cantidaDeDescargas;
    }

    public void setCantidaDeDescargas(Integer cantidaDeDescargas) {
        this.cantidaDeDescargas = cantidaDeDescargas;
    }

    @Override
    public String toString() {
        return
                "------------ Libro ------------"+
                        "\ntitulo='" + title + '\'' +
                ",\nautor= " + author.getName() +'\''+
               ",\nidioma= " + idiom +'\''+
                ",\ncantida De Descargas= " + cantidaDeDescargas +'\''+
                        "\n \n-------------------------"
                ;
    }
}
