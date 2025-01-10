package com.example.booksLiterature.utils;


import java.util.Scanner;

public class Validator {

    private static boolean isPresent(String str){
       if(str == null || str.isEmpty()){
           return false;
       }
       return true;
    }

    public static boolean isNumeric(String str) {
        if (!isPresent(str)){return false;}
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean question(String YesOption, String NotOption) {
        Scanner scanner = new Scanner(System.in);
        String yQ=YesOption+"- SI"  ;
        String nQ=NotOption+"- NO" ;
        String FQ=  yQ+"\n"+nQ;
        System.out.println(FQ);
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase(NotOption)) {
            return false;
        }else if (answer.equalsIgnoreCase( YesOption)){
            return true;
        }else if(!isPresent(answer ) || (!answer.equalsIgnoreCase(yQ) && !answer.equalsIgnoreCase(nQ))) {
            question(YesOption, NotOption);
        }
        return true;
    }

}
