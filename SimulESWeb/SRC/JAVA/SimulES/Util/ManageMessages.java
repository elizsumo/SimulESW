

package SimulES.Util;

import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Elizabeth
 */
public class ManageMessages {

    /**
     * Adiciona uma mensagem de erro baseando-se na excecao
     * @param ex
     */
    public static void addErrorMessage(Exception ex) {
        log(JSFUtils.class, ex);
        String message;
        if (ex instanceof AppException){
            AppException app = (AppException)ex;
            if (app.getParameters() != null){
                message = app.getMessage();
                Object[] parameters = app.getParameters();
                message = MessageFormat.format(message, parameters);
            } else {
                message = app.getMessage();
            }
        }else{
            message = ex.getMessage();
        }
        FacesMessage fm = new FacesMessage(message);
        fm.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext.getCurrentInstance().addMessage(null, fm);
    }
    /**
     * Adiciona uma mensagem de erro baseando-se na excecao
     * @param messagem a mensagem de erro
     * @param parametros os parametros para serem mostrados
     */
    public static void addMessage(String  message,Object...parameters) {
            if (parameters != null){
                message = MessageFormat.format(message, parameters);
            }
        FacesMessage fm = new FacesMessage(message);
        fm.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, fm);
    }
    public static void log(Class klass,String message){
         Logger.getLogger(klass.getName()).log(Level.SEVERE, null, message);
    }
    public static void log(Class klass,Exception ex){
         Logger.getLogger(klass.getName()).log(Level.SEVERE, null, ex);
    }


}
