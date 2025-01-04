package com.example.booksLiterature.model;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="book")
public class Book {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String title;

    @ElementCollection
    private List<String> authors;

    @ElementCollection
    private List<String> idioma;
    //Automatic Getters & Setters

    private Integer cantidaDeDescargas;

    public List<String> getIdioma() {
        return idioma;
    }

    public void setIdioma(List<String> idioma) {
        this.idioma = idioma;
    }

    public Integer getCantidaDeDescargas() {
        return cantidaDeDescargas;
    }

    public void setCantidaDeDescargas(Integer cantidaDeDescargas) {
        this.cantidaDeDescargas = cantidaDeDescargas;
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

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }


}
