package com.example.booksLiterature;

import jakarta.persistence.Index;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.security.Principal;

@SpringBootApplication
public class BooksLiteratureApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(BooksLiteratureApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello World");
		Inicial inicial = new Inicial();
		inicial.desplegarOpciones();
	}
}
