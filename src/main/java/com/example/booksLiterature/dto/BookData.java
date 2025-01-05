package com.example.booksLiterature.dto;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookData(
    @JsonAlias("title")  String title,
    @JsonAlias("authors") List<AuthorDTO> authors,
    @JsonAlias("languages") List<String> idioma,
    @JsonAlias("download_count") Integer cantidaDeDescargas
) {
}
