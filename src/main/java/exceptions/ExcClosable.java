package exceptions;

import composition.Computer;

import java.io.BufferedReader;
import java.io.FileReader;

public class ExcClosable {

    // konstrukce hlídání chyby u oběktu který implementuje rozhraní closable
    // nemusíme pro jeho uzavření používat blok finally
    public String readFirstLineFromFile(String path) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {

            bufferedReader.readLine();

        } catch (Exception e) {
            //return "FAILED";
        }

        // -------------------------------------------
        try (Computer c = new Computer()) {

        } catch (Exception e) {
        }
        return "FAILED";


        // -------------------------------------------

    }
}
