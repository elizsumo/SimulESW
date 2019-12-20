
package SimulES.Util;

/**
 *
 * @author Elizabeth
 */
public class AppException extends Exception{
    private Object[] parameters;

    public AppException(String message,Object...parameters) {
        super(message);
        this.parameters=parameters;
    }
    public Object[] getParameters(){
        return parameters;
    }


}