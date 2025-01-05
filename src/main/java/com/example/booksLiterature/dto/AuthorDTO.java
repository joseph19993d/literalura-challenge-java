package com.example.booksLiterature.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public record AuthorDTO(
    @JsonAlias("name") String nombre,
    @JsonAlias("birth_year") String fechaDeNacimiento,
    @JsonAlias("death_year") String fechaDeMuerte
    ) {
}
