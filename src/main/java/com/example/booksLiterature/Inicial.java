package com.example.booksLiterature;
import java.util.Optional;
import java.util.Scanner;

import com.example.booksLiterature.repository.BookRepository;
import com.example.booksLiterature.services.GetAPI;
import com.example.booksLiterature.utils.Validator;
import org.springframework.stereotype.Repository;


public class Inicial {

    private BookRepository repository;
    private final String API_URL= "https://gutendex.com/books/";
    public Inicial(BookRepository repository) {
        this.repository = repository;
    }

    private Scanner leerConsola = new Scanner(System.in);

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

   public void desplegarOpciones (){
       System.out.println(menu);
       String opcion = leerConsola.nextLine();
      if(Validator.isNumeric(opcion)) {
           System.out.println("bien echo ");
           switch ( Integer.parseInt(opcion)) {
               case 1:
                   System.out.print("Ingrese el título o palabras clave: ");
                   String title = leerConsola.nextLine();
                   //bookService.searchBookByTitle(title);
                   buscarLibro(title);
                   break;
               case 2:
                   //bookService.listAllBooks();
                   break;
               case 3:
                   //bookService.listAllAuthors();
                   break;
               case 4:
                   System.out.print("Ingrese el año de interés: ");
                   int year = Integer.parseInt(leerConsola.nextLine());
                   //bookService.listAuthorsByYear(year);
                   break;
               case 5:
                   System.out.print("Ingrese el código de idioma (ej. en, fr): ");
                   String language = leerConsola.nextLine();
                   //bookService.listBooksByLanguage(language);
                   break;
               case 0:
                   System.out.println("Saliendo del programa...");
                   break;
               default:
                   System.out.println("Opción inválida. Intente nuevamente.");
           }
      }else {
          System.out.println("Ingrese un numero ");
          desplegarOpciones();
      }

   }

    private void buscarLibro(String nombreDelLibro) {
        System.out.println("logica de busqueda de libro");

        var json= GetAPI.obtenerJson(API_URL+ "?search="+nombreDelLibro.replace(" ","+"));
        System.out.println(json);
//       var convierteBusqueda= convierteDatos.obtenerDatos(json,LibroDTO.class);
//        Optional<DatosLibro> libroBuscado = convierteBusqueda.libros().stream()
//                .filter(t-> t.titulo().toUpperCase().contains(nombreDelLibro.toUpperCase()))
//                .findFirst();
//        if (libroBuscado.isPresent()){
////            Libro libro = new Libro(libroBuscado.get());
////            repository.save(libro);
////            System.out.println(libro.toString());
//
//        }else {
//            System.out.println("No se encontro el libro");
//        }
    }

}
