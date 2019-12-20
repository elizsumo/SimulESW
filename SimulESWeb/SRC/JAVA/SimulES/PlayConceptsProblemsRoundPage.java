/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SimulES;

import SimulES.Control.MoveController;
import SimulES.Control.PlayerController;
import SimulES.Control.RoundController;
import SimulES.Model.Move;
import SimulES.Model.Player;
import SimulES.Model.Round;
import SimulES.Util.ManageMessages;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.rave.web.ui.component.Button;
import com.sun.rave.web.ui.component.Hyperlink;
import java.awt.TextField;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version PlayConceptsProblemsRoundPage.java
 * @version Created on Jul 30, 2010, 3:30:17 PM
 * @author CarlosAlvarezH
 */
public class PlayConceptsProblemsRoundPage extends AbstractPageBean {

    

    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public PlayConceptsProblemsRoundPage() {
    }

    /**
     * <p>Callback method that is called whenever a page is navigated to,
     * either directly via a URL, or indirectly via page navigation.
     * Customize this method to acquire resources that will be needed
     * for event handlers and lifecycle methods, whether or not this
     * page is performing post back processing.</p>
     * 
     * <p>Note that, if the current request is a postback, the property
     * values of the components do <strong>not</strong> represent any
     * values submitted with this request.  Instead, they represent the
     * property values that were saved for this view when it was rendered.</p>
     */
    @Override
    public void init() {
        // Perform initializations inherited from our superclass
        super.init();
        // Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here
      

        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("PlayConceptsProblemsRoundPage Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }

    // </editor-fold>
    // Perform application initialization that must complete
    // *after* managed components are initialized
    // TODO - add your own initialization code here
    }

    /**
     * <p>Callback method that is called after the component tree has been
     * restored, but before any event processing takes place.  This method
     * will <strong>only</strong> be called on a postback request that
     * is processing a form submit.  Customize this method to allocate
     * resources that will be required in your event handlers.</p>
     */
    @Override
    public void preprocess() {
    }

    /**
     * <p>Callback method that is called just before rendering takes place.
     * This method will <strong>only</strong> be called for the page that
     * will actually be rendered (and not, for example, on a page that
     * handled a postback and then navigated to a different page).  Customize
     * this method to allocate resources that will be required for rendering
     * this page.</p>
     */
    @Override
    public void prerender() {

          //@episodio1 jogador entra no jogo
        String username = (String) getExternalContext().getRequestParameterMap().get("username");
        if (username != null) {

            getSessionBean1().setUsername(username);

        }
       
    }

    /**
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>init()</code> was called (regardless of whether
     * or not this was the page that was actually rendered).  Customize this
     * method to release resources acquired in the <code>init()</code>,
     * <code>preprocess()</code>, or <code>prerender()</code> methods (or
     * acquired during execution of an event handler).</p>
     */
    @Override
    public void destroy() {
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
    }

    //episodio5 SimulES disponibiliza as informações dos movimentos do jogo;
    public String getTranscript() {
        String[][] entries =
                getApplicationBean1().getEntries();
        if (entries == null) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < entries.length; i++) {
            String entryUsername = entries[i][0];
            String comment = entries[i][1];
            String color = "purple";
            String username = getSessionBean1().getUsername();
            if (username.equals(entryUsername)) {
                color = "blue";
            }
            sb.append(
                    "<div><span style=\"font-weight:bold;color:");
            sb.append(color);
            sb.append("\">[");
            sb.append(entryUsername);
            sb.append("]</span> ");
            sb.append(comment);
            sb.append("</div>");
        }
        return sb.toString();
    }

    public String btnSubmit_action() {

        if (validMove()) {
            String username = getSessionBean1().getUsername();
            PlayerController playerControler = new PlayerController();
            Player playerMax = playerControler.getMaxIdPlayer();
            if (playerMax.getNickname().equals(username)) {
                nextRoundNextPlayer();
                FacesMessage fm = new FacesMessage("You have made your move, next player");
                fm.setSeverity(FacesMessage.SEVERITY_INFO);
                FacesContext.getCurrentInstance().addMessage(null, fm);
                getApplicationBean1().addEntry(username, "You have made your move, next player");
            } else {
                nextPlayer();
            }
        }

        return "case3";
    }

    //@episodio pasa a seguinte ronda
    public void nextRoundNextPlayer() {
        MoveController moveController = new MoveController();
        RoundController roundController = new RoundController();
        moveController.closeMove(5);
        moveController.enableNextMove(4);
        roundController.closeRound(3);
        roundController.enableNextRound(2);
        moveController.enableMinPlayerToMove(4);
    }

    //@episodio pasa ao seguinte jogador
    public void nextPlayer() {
        MoveController moveController = new MoveController();
        moveController.updateNextPlayerToMove();
    }

    //@episodio valida que o usuario e a jogada seja valida
    public synchronized Boolean validMove() {

        boolean validUser = false;
        String username = getSessionBean1().getUsername();

        if (userIsValid()) {
            MoveController mController = new MoveController();
            Move move = mController.getMove(5);
            if (move.getState().equals("A")) {
                if (move.getPlayer().getNickname().equals(username)) {
                    return true;
                } else {
                    ManageMessages.addMessage("Player who should play is: " + move.getPlayer().getNickname());
                    return false;
                }
            } else if (move.getState().equals("E")) {
                ManageMessages.addMessage("The move has already been executed by all players");
                return false;
            } else {
                FacesMessage fm = new FacesMessage("This move is invalid");
                fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext.getCurrentInstance().addMessage(null, fm);
                return false;
            }

        }
        return validUser;
    }

    //@episodio validamos a sessao do usuario
    public boolean userIsValid() {
        boolean isValid = true;
        String username = null;
        PlayerController playerController = new PlayerController();

        username = getSessionBean1().getUsername();
        try {
            if (username.isEmpty() || username.equals("")) {
                isValid = false;
            } else if (!playerController.playerExist(username)) {
                isValid = false;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            FacesMessage fm = new FacesMessage("user is invalid");
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, fm);
            isValid = false;

        }
        return isValid;

    }

   
}

