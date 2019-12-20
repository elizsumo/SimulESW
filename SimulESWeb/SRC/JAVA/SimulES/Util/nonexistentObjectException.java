

package SimulES.Util;

/**
 *
 * @author Elizabeth
 */
public class nonexistentObjectException extends DaoException{

    public nonexistentObjectException(String message,Object...parameters) {
        super(message,parameters);
    }

}
