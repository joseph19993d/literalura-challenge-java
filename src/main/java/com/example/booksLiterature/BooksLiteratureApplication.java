package com.example.booksLiterature;

import com.example.booksLiterature.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.security.Principal;

@SpringBootApplication
public class BooksLiteratureApplication implements CommandLineRunner {

	@Autowired
	BookRepository bookRepository;
	public static void main(String[] args) {
		SpringApplication.run(BooksLiteratureApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Runing...");
		Inicial inicial = new Inicial(bookRepository);
		inicial.desplegarOpciones();
	}
}
