package com.example.booksLiterature.dto;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookData(
    @JsonAlias("title") String title,
    @JsonAlias("authors") List<AuthorDTO> author,
    @JsonAlias("languages") List<String> idiom,
    @JsonAlias("download_count") Integer cantidaDeDescargas
) {
}
