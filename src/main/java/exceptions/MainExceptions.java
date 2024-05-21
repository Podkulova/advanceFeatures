package exceptions;

import java.io.IOException;

// Ukazka prace s exceptions
public class MainExceptions {

    public static void main(String[] args) {
        exceptHandle("test 1");
        exceptHandleSimple("setr 2");

        customException("AHOJ");

    }
    public static void exceptHandle(String s){

        System.out.println("start metody --------------------------------------------");
        try {

            System.out.println("start try");
            printStringThrowIlegalArgException(s);
            printStringThrowException(s);
            printStringNoThrow(s);
            System.out.println("end try");
            getFile();

        // je treba skladat hiearchicky podle parent / child
        }catch (IllegalArgumentException ilEx) {
            System.out.println("exception cath : IllegalArgumentException " + ilEx.getMessage());
        }catch (RuntimeException rt) {
            System.out.println("exception cath : RuntimeException " + rt.getMessage());
        }catch (IOException ioX){
            System.out.println("IOException ");
        }catch (Exception t) {
            System.out.println("exception catch " + t.getMessage());
        }finally{
            System.out.println("blok finally je vyvolán vždy");
        }
        System.out.println("konec metody ----------------------------------------------");

    }

    public static void exceptHandleSimple(String s){
        System.out.println("start metody --------------------------------------------");

        try {
            // otevreme soubor
            System.out.println("start try");
            printStringThrowIlegalArgException(s);
            printStringThrowException(s);
            printStringNoThrow(s);
            System.out.println("end try");
            getFile();
            // zavirame soubor - lepe datr do finally
        }catch (Exception ilEx) {
            System.out.println("exception cath " + ilEx.getMessage());
            // zavirame soubor - lepe datr do finally
        }finally{
            System.out.println("blok finally je vyvolán vždy");
            // zavirame soubor - nejlepsi reseni
        }


        System.out.println("konec metody ----------------------------------------------");
    }


    // exception se musí deklarovat u metody (throws Exception)
    // pokud to neni RuntimeException
    public static void printStringThrowException(String s) throws Exception {
        if(s!=null) {
            System.out.println(s);
            System.out.println(s.length());
        }else
            throw new Exception("Moje chyba : text chyby >>> string si nulllllllll");
    }

    // test vstupu a pokud je null vyhozeni chyby
    public static void printStringThrowIlegalArgException(String s){
        if(s!=null) {
            System.out.println(s);
            System.out.println(s.length());
        }else
            throw new IllegalArgumentException("Chyba : IllegalArgumentException");
    }


    // runtime exception se nemusí deklarovat u metody
    public static void printStringCheckNull02(String s) {
        if(s!=null) {
            System.out.println(s);
            System.out.println(s.length());
        }else
            throw new RuntimeException("Moje chyba : text chyby >>> string si nulllllllll");
    }

    public static void printStringNoThrow(String s){
        System.out.println(s);
        System.out.println(s.length());
    }

    public static void getFile() throws IOException {
        throw new IOException();
    }

    // typicke pouziti
    public static Double methodClasicDeleni(Double num1, Double num2){
        try{
            return num1 / num2;
        }catch (Exception ex){
            return null;
        }
    }

    // deleni s throw exception
    public static Double methodClasicDeleni02(Double num1, Double num2) {
      if(num2<1)
         throw new IllegalArgumentException();
      return num1 / num2;
    }

    // odchyceni chyby ve smycce
    public static void smyckaCatchException(){
        for(Integer i = 5; i>-5; i--) {
            try {
                Double d = methodClasicDeleni02(55.5, new Double(i));
                System.out.println(i + " -> " + d);
            } catch (Exception ex){
                break;
            }
        }
    }

    // vlastni exception
    public static void customException(String s) {
        try {
            if (s.equalsIgnoreCase("AHOJ"))
                //throw new MyException(this.getClass(), "retezec nesmi mit hodnotu AHOJ - zadne tykani");
                throw new MyException("ExcClass", "retezec nesmi mit hodnotu AHOJ - zadne tykani");
        }catch (MyException myEx){
            System.out.println("data z nasi MyException : " + myEx.getDate());
        }
    }


}
