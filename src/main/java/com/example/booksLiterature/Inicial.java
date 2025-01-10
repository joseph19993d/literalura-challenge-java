package com.example.booksLiterature;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.example.booksLiterature.dto.BookDTO;
import com.example.booksLiterature.dto.BookData;
import com.example.booksLiterature.model.Author;
import com.example.booksLiterature.model.Book;
import com.example.booksLiterature.repository.BookRepository;
import com.example.booksLiterature.services.DataTransformer;
import com.example.booksLiterature.services.GetAPI;
import com.example.booksLiterature.utils.Validator;
import org.springframework.dao.DataIntegrityViolationException;


public class Inicial {

    private BookRepository bookRepository;
    private final String API_URL= "https://gutendex.com/books/";
    DataTransformer dataTransformer = new DataTransformer();
    private Scanner readConsole = new Scanner(System.in);
    private List<Book> books;
    private List<Author> authors;

    public String menu=
            """
            Elija una opcion (solo numeros)
            1 - Buscar libro por titulo
            2 - Listar libros registrados
            3 - Listar autores registrados
            4 - Listar autores vivos en un determinado año
            5 - Listar libros por idioma 
            0 -salir
            """;

    private String languageMenu =
            """
             Ingrese el idioma para buscar los libros
             es- Español
             en- Ingles
             fr- Frances
             pt- Portugues
            """;

    public Inicial(BookRepository repository) {
        this.bookRepository = repository;
    }


   public void desplegarOpciones (){
       System.out.println(menu);
       String opcion = readConsole.nextLine();
      if(Validator.isNumeric(opcion)) {
           switch ( Integer.parseInt(opcion)) {
               case 1:
                   do{
                   System.out.print("Ingrese el título o palabras clave: ");
                   String title = readConsole.nextLine();
                   buscarLibro(title);
                   System.out.println("¿Desea buscar otro libro? ");
                   }while (Validator.question("s","n"));
                   break;
               case 2:
                   showAllBooks();
                   break;
               case 3:
                   showAuthors();
                   break;
               case 4:
                   System.out.print("Ingrese el año de interés: ");
                   int year = Integer.parseInt(readConsole.nextLine());
                   listAuthorsByYear(year);
                   break;
               case 5:
                   System.out.print("Ingrese el código de idioma (ej. en, fr): ");
                   System.out.println(languageMenu);
                   String language = readConsole.nextLine();
                   //bookService.listBooksByLanguage(language);
                   showBooksByIdiom(language);
                   break;
               case 0:
                   System.out.println("Saliendo del programa...");
                   break;
               default:
                   System.out.println("Opción inválida. Intente nuevamente.");
           }
      } else {
          System.out.println("Ingrese un numero ");
          desplegarOpciones();
      }
       if (Validator.isNumeric(opcion) && Integer.parseInt(opcion) != 0) {
           desplegarOpciones();
       }

   }

    private void buscarLibro(String bookName) {
       //logica de busqueda de libro
        System.out.println("Buscando..");
        var json= GetAPI.obtenerJson(API_URL+ "?search="+bookName.replace(" ","+"));
        var objectBookData = dataTransformer.getData(json, BookDTO.class);
        Optional <BookData> SearchedBookDataObject = objectBookData.books().stream()
                .filter(t->t.title().toUpperCase().contains(bookName.toUpperCase()))
                .map(bookData -> {
                    // Modifica el campo idiom para que solo contenga el primer idioma
                    List<String> firstLanguageList = (bookData.idiom() != null && !bookData.idiom().isEmpty())
                            ? List.of(bookData.idiom().get(0))  // Solo el primer idioma
                            : List.of();
                    return new BookData(
                            bookData.title(),
                            bookData.author(),
                            firstLanguageList,
                            bookData.cantidaDeDescargas()
                    );
                })
                .findFirst();
        if(SearchedBookDataObject.isPresent()) {
            Book bookData = new Book( SearchedBookDataObject.get());
            System.out.println(bookData);
            try {
                bookRepository.save(bookData);
            } catch (DataIntegrityViolationException e) {
                System.out.println(" El libro con este título ya fue registrado anteriormente .");
            }
        }else{
            System.out.println("Libro no encontrado");
        }

    }

    private void showAllBooks() {
        books = bookRepository.findAll();
        books.forEach(System.out::println);
    }

    private void showAuthors() {
        var authors= bookRepository.listAllAuthors();
        authors.forEach(System.out::println);
    }

    private void listAuthorsByYear(Integer year) {
        var syear = String.valueOf(year);
        var objectList = bookRepository.findByAnios(syear);
        if (objectList.isEmpty()){
            System.out.println("No se encontro autores en ese año");
        }else {
            objectList.forEach(System.out::println);
            System.out.println(objectList.size());
        }

    }

    private void showBooksByIdiom(String searchidiom) {

        try {
            books = bookRepository.findByIdioma(searchidiom.trim());
        } catch (Exception e) {
            System.out.println("Ocurrió un error al buscar los libros: " + e.getMessage());
            return;
        }

        if (books.isEmpty()){
            System.out.println("No se encontro libros con ese idioma");
        }else {
            books.forEach(System.out::println);
            System.out.println(books.size());
        }

    }


}
