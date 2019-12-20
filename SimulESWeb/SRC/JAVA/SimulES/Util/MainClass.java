
package SimulES.Util;

import SimulES.Control.ModulesProjectController;
import java.util.Arrays;

/**
 *
 * @author emonsalve
 */
public class MainClass {

    public static void main(String[] args) {

      

//        JSFUtils jsfUtils = new JSFUtils();
//
//        String cadena = "R0,C1,VC1/R0,C1,VC1/R0,C1,VC1/R1,C1,VC1/R1,C2,VC1/R2,C1,VC1/R2,C2,VC1/R3,C1,VC1/R3,C2,VC1/R4,C1,VC1/R4,C2,VC1/";
//
// int valor =   jsfUtils.maxColumnValue(cadena);
//
//System.out.println(valor);


        ValidateCharacters validate = new ValidateCharacters();

   boolean valor =   validate.validateOnlyCharacters("fdsjklfsd");

        System.out.println("el valor es:" + valor);

    }

}
