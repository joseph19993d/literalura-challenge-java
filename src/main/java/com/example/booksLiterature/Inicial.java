package com.example.booksLiterature;
import java.sql.SQLOutput;
import java.util.Scanner;
import com.example.booksLiterature.utils.Validator;

public class Inicial {
    public Inicial() {

    }

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
       Scanner leerConsola = new Scanner(System.in);
       String opcion = leerConsola.nextLine();
      if(Validator.isNumeric(opcion)) {
           if(Integer.parseInt(opcion)>=1 &&  Integer.parseInt(opcion)<=5 ) {
               System.out.println("bien echo ");
           }else{
               System.out.println("fuera del rango de opciones ");
               desplegarOpciones();
           }
      }else {
          System.out.println("Ingrese un numero ");
          desplegarOpciones();
      }

   }

}
