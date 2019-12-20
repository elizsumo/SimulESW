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
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.rave.web.ui.component.Button;
import com.sun.rave.web.ui.component.ImageComponent;
import java.util.List;
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
 * @version PlayGamePage.java
 * @version Created on Feb 21, 2011, 4:54:06 PM
 * @author CarlosAlvarezH
 */
public class PlayGamePage extends AbstractPageBean {

    private List<Round> activeRound = null;
    private String playerName = null;
    private String nextPlayerName = null;

    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private Button btnPlayActionsRound = new Button();

    public Button getBtnPlayActionsRound() {
        return btnPlayActionsRound;
    }

    public void setBtnPlayActionsRound(Button b) {
        this.btnPlayActionsRound = b;
    }
    private ImageComponent img1 = new ImageComponent();

    public ImageComponent getImg1() {
        return img1;
    }

    public void setImg1(ImageComponent ic) {
        this.img1 = ic;
    }
    private ImageComponent img2 = new ImageComponent();

    public ImageComponent getImg2() {
        return img2;
    }

    public void setImg2(ImageComponent ic) {
        this.img2 = ic;
    }
    private ImageComponent img3 = new ImageComponent();

    public ImageComponent getImg3() {
        return img3;
    }

    public void setImg3(ImageComponent ic) {
        this.img3 = ic;
    }
    private Button btnPlayStartRound = new Button();

    public Button getBtnPlayStartRound() {
        return btnPlayStartRound;
    }

    public void setBtnPlayStartRound(Button b) {
        this.btnPlayStartRound = b;
    }
    private Button btnPlayConceptRound = new Button();

    public Button getBtnPlayConceptRound() {
        return btnPlayConceptRound;
    }

    public void setBtnPlayConceptRound(Button b) {
        this.btnPlayConceptRound = b;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public PlayGamePage() {
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
            log("PlayGamePage Initialization Failure", e);
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

        disabledButtons();
        getRoundActive();
        getPlayerActive();
        getNextPlayer();
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
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
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

    //@episodie obter a descripção da ronda ativa
    public void getRoundActive() {

        btnPlayStartRound.setDisabled(true);

        RoundController roundController = new RoundController();

        Round roundActive = new Round();

        Round actRound = roundController.getActiveRound();

        int idRound = actRound.getRoundId();

        switch (idRound) {
            case 1:
                btnPlayStartRound.setDisabled(false);
                img1.setVisible(true);
                break;
            case 2:
                btnPlayActionsRound.setDisabled(false);
                img2.setVisible(true);
                break;
            case 3:
                btnPlayConceptRound.setDisabled(false);
                img3.setVisible(true);
                break;
            default:
                disabledButtons();
                break;
        }
    }

    public void disabledButtons() {
        btnPlayStartRound.setDisabled(true);
        btnPlayConceptRound.setDisabled(true);
        btnPlayActionsRound.setDisabled(true);
        img1.setVisible(false);
        img2.setVisible(false);
        img3.setVisible(false);
    }

    public String btnPlayStartRound_action() {

        return "case1";
    }

    public void getPlayerActive() {
        try {
            Move move = null;
            MoveController movecontroller = new MoveController();
            move = movecontroller.getMoveActive();

            Player player = move.getPlayer();

            setPlayerName(player.getNickname());
        } catch (Exception ex) {
            ex.printStackTrace();
            FacesMessage fm = new FacesMessage("user has not registred yet");
            fm.setSeverity(FacesMessage.SEVERITY_INFO);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
    }

    /**
     * @return the playerName
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * @param playerName the playerName to set
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
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

    public String btnPlayConceptRound_action() {
        return "case3";
    }

    public String btnPlayActionsRound_action() {
        return "case2";
    }

    //episodio obter o seguinte jogador
     public void getNextPlayer() {
        try {
            Move move = null;
            MoveController movecontroller = new MoveController();
            move = movecontroller.getMoveActive();

            Player actPlayer = move.getPlayer();
            Player nextPlayer = null;

            PlayerController playercontroller = new PlayerController();
            nextPlayer = playercontroller.getNextPlayer(actPlayer);

            setNextPlayerName(nextPlayer.getNickname());

        } catch (Exception ex) {
            ex.printStackTrace();
            FacesMessage fm = new FacesMessage("user has not registred yet");
            fm.setSeverity(FacesMessage.SEVERITY_INFO);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
    }

    /**
     * @return the nextPlayerName
     */
    public String getNextPlayerName() {
        return nextPlayerName;
    }

    /**
     * @param nextPlayerName the nextPlayerName to set
     */
    public void setNextPlayerName(String nextPlayerName) {
        this.nextPlayerName = nextPlayerName;
    }


}

