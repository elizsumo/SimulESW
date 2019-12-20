/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SimulES.Util;

// se importa el paquete java.util.regex
import java.util.regex.*;

/**
 *
 * @author elizsumoComputer
 */
public class ValidateCharacters {

    public boolean validateOnlyCharacters(String charToValidate) {
        boolean stringIsValided = true;
        if (!charToValidate.matches("[a-zA-Z]*")) {
            stringIsValided = false;
            System.out.println("please enter char only");
        }
        return stringIsValided;
    }
}
